package baekjoon.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NandM8_15657 {
    static int N, M;
    static int[] arr, res;
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
        Arrays.sort(arr);

        sequence(0, 0);

        System.out.println(sb);
    }

    private static void sequence(int cur, int step) {

        if(step == M) {
            for(int a: res) {
                sb.append(a).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=cur; i<N; i++) {
            res[step] = arr[i];
            sequence(i, step+1);

        }
    }
}
