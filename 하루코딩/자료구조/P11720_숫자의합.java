package 하루코딩.자료구조;

import java.util.Scanner;

public class P11720_숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] numArr = sc.next().toCharArray();

        int ans = 0;
        for(int n=0; n<N; n++) {
            ans += numArr[n]-'0';
        }

        System.out.println(ans);
    }
}
