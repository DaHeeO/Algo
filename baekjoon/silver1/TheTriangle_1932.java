package baekjoon.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheTriangle_1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] tri = new int[N][N];

        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<=n; i++) {
                tri[n][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] DP = new int[N][N];

        DP[0][0] = tri[0][0];

        for(int i=1; i<N; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0) {
                    DP[i][j] = DP[i-1][j] + tri[i][j];
                }
                else if(j==i){
                    DP[i][j] = DP[i-1][j-1] + tri[i][j];
                }
                else{
                    DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + tri[i][j];
                }
            }
        }

        int res = 0;
        for(int n=0; n<N; n++) {
            res = Math.max(res, DP[N-1][n]);
        }

        System.out.println(res);
    }
}
