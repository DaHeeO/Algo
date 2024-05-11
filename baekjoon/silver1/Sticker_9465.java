package baekjoon.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int N = Integer.parseInt(br.readLine());

            int[][] stickers = new int[2][N+1];
            for(int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int n=1; n<=N; n++) {
                    stickers[i][n] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] DP = new int[2][N+1];

            DP[0][1] = stickers[0][1];
            DP[1][1] = stickers[1][1];

            for(int n=2; n<=N; n++) {
                DP[0][n] = Math.max(DP[1][n-1], DP[1][n-2]) + stickers[0][n];
                DP[1][n] = Math.max(DP[0][n-1], DP[0][n-2]) + stickers[1][n];
            }

            System.out.println(Math.max(DP[0][N], DP[1][N]));

        }
    }
}
