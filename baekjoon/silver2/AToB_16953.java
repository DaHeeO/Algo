package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AToB_16953 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // B에서 A로 반대로 계산
        // 만약에 1의 자리수가 홀수면 만들수가 없는거고 (1제외)
        // 만약에 짝수면 2로 나누고
        // 가장 짧게 만드는 방법이 이것밖에 없음 홀순데 1의 자리가 1이면 1을 붙였다고 판단할 수 밖에

        int cnt = 0;
        while(B >= 1) {
            cnt++;

            if(A == B) {
                break;
            }

            // 홀수라면
            if(B%2 != 0) {
                if(B%10 != 1) break;
                B /= 10;
            }

            // 짝수라면
            else {
                B /= 2;
            }
        }

        System.out.println(A==B ? cnt : -1);
    }
}
