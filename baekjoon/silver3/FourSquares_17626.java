package baekjoon.silver3;

import java.util.Arrays;
import java.util.Scanner;

public class FourSquares_17626 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] DP = new int[N+1];

        Arrays.fill(DP, Integer.MAX_VALUE);

        for(int n=1; n*n<=N; n++) {
            DP[n*n] = 1;
        }


        for(int i=1; i<=N; i++) {
            for(int j=1; i-j*j > 0; j++) {
                DP[i] = Math.min(DP[i], DP[i-j*j] + 1);
            }
        }

        System.out.println(DP[N]);
    }
}
