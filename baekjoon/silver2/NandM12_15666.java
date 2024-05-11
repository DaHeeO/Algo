package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class NandM12_15666 {

    static int N, M;
    static int[] arr, res;
    static LinkedHashSet<String> ans = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        res = new int[M];
        Arrays.sort(arr);

        combi(0, 0);

        for(String s : ans) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }

    private static void combi(int cur, int step) {

        if(step == M) {
            String s = "";
            for(int a : res) {
                s += a + " ";
            }
            ans.add(s);
            return;
        }

        for(int i=cur; i<N; i++) {
            res[step] = arr[i];
            combi(i, step+1);
        }
    }
}
