package baekjoon.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemoteController_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int target = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];

        // nullpointr exception 예외처리..
        if(N>0){
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++) {
                int num = Integer.parseInt(st.nextToken());
                broken[num] = true;
            }
        }

        // 누른 횟수의 최솟값을 의미
        // 초기값은 100부터 시작하니깐 100부터 처음 target과 ++ or -- 로 얼마만큼 눌러야하는지를 저장
        int result = Math.abs(target - 100);

        for(int i=0; i<=999999; i++) {
            String num = String.valueOf(i);

            boolean isBreak = false;
            for(int j=0; j<num.length(); j++) {
                if(broken[num.charAt(j)-'0']){
                    isBreak = true;
                    break;
                }
            }
            if(!isBreak){
                int min = Math.abs(target-i) + num.length();
                result = Math.min(min, result);
            }
        }

        System.out.println(result);

    }
}
