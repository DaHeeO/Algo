package baekjoon.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CainCalendar_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            boolean check = false;
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()) % N;

            // 만약 (mod m)이면 0 부터 m-1 인데
            // 카잉 달력은 1 부터 m 까지 이니깐
            // 보정해 주기 위해서 M을 기준으로 <x:y>라면
            // x = M 이면 mod(M) 은 0이지만 M부터 시작하는게 맞고
            // y = N 이면 그건 나머지 0으로 계산하는게 맞으니깐 y만 바꿔줌

            for(int i=x; i<=M*N; i+=M){
                if(i % N == y) {
                    System.out.println(i);
                    check = true;
                    break;
                }
            }

            if(!check) {
                System.out.println(-1);
            }
        }

    }
}
