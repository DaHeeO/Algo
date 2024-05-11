package baekjoon.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NandM5_15654 {

    static int N, M;
    static int[] res, arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        res = new int[M];
        visited = new boolean[N];
        Arrays.sort(arr);

        Combination( 0);

        System.out.println(sb);
    }

    private static void Combination(int step) {

        if(step == M) {
            for(int a: res) {
                sb.append(a).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            res[step] = arr[i];
            Combination(step+1);
            visited[i] = false;
        }

    }
}
