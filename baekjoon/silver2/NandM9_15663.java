package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class NandM9_15663 {

    static int N, M;
    static int[] res, arr;
    static boolean[] visited;
    static LinkedHashSet<String> ans = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        // tree set 으로 구현시 test케이스가 이러면
        // 3 1
        // 1 19 2
        // 순서가 1 19 2 로 오름차순 정렬되서 나오기 때문에 적합하지 않다.
        // 그럴때는 자료구조의 순서를 보장하는 linkedHashSet을 쓰는게 더 적합하다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        res = new int[M];
        visited = new boolean[N];
        combi( 0);

        for(String s : ans) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }

    private static void combi(int step) {

        if(step == M) {
            String s = "";
            for(int a : res) {
                s += a + " ";
            }
            ans.add(s);
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            res[step] = arr[i];
            visited[i] = true;
            combi(step+1);
            visited[i] = false;
        }
    }
}
