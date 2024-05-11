package baekjoon.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PsychologicalDistance_20529 {
    static int N;
    static String[] MBTI;
    static String[] group;
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            // 33명 이상이라면 더이상 할 필요가 없음..
            if(N>=33) {
                sb.append(0).append('\n');
                continue;
            }

            // MBTI 저장
            MBTI = new String[N];
            group = new String[3];
            min = 12;
            for(int n=0; n<N; n++) {
                MBTI[n] = st.nextToken();
            }

            combination(0, 0);
            sb.append(min).append('\n');

        }

        System.out.println(sb);
    }

    private static void combination(int k, int n) {

        if(n==3) {
            // 심리적 거리 계산
            int pd = 0;
            for(int i=0; i<3; i++) {
                pd += psychologicalDistance(group[i], group[(i+1)%3]);
            }
            min = Math.min(min, pd);
            return;
        }

        for(int i=k; i<N; i++) {
            group[n] = MBTI[i];
            combination(i+1, n+1);
        }
    }

    private static int psychologicalDistance(String p1, String p2) {
        int pd = 0;
        for(int i=0; i<4; i++) {
            if(p1.charAt(i)!=p2.charAt(i)) pd++;
        }
        return pd;
    }
}
