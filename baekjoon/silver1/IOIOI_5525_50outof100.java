package baekjoon.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIOI_5525_50outof100 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 2*Integer.parseInt(br.readLine())+1;
        String[] p = {"I", "O"};

        String pn = "";
        for(int n=0; n<N; n++) {
            pn += p[n%2];
        }

        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int cnt = 0;
        for(int i=0; i<M-N+1; i++){
            String temp = S.substring(i, i+N);
            if(S.substring(i, i+N).equals(pn)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
