package baekjoon.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBDistance_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][3];
        int[][] DP = new int[N][3];

        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<3; i++) {
                cost[n][i] = Integer.parseInt(st.nextToken());
                if(n==0) {
                    DP[n][i] = cost[n][i];
                }
            }
        }

        for(int n=1; n<N; n++) {
            DP[n][0] = Math.min(DP[n-1][1], DP[n-1][2]) + cost[n][0];
            DP[n][1] = Math.min(DP[n-1][0], DP[n-1][2]) + cost[n][1];
            DP[n][2] = Math.min(DP[n-1][0], DP[n-1][1]) + cost[n][2];

        }

        int res = Integer.MAX_VALUE;
        for(int i=0; i<3; i++) {
            if(DP[N-1][i] < res) res = DP[N-1][i];
        }

        System.out.println(res);
    }
}
