package baekjoon.gold5;

import java.util.Scanner;

public class RemoteController_Mine_1107 {

    public static void main(String[] args) {
        // 내 방식 target으로 부터 작은거 큰거 찾아서
        // 치는거다...

        // 고장난 Button 이 n 일때 BufferedReader 사용하면 nullPointer 에러나서
        // scanner이 좀더 좋음
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();
        int N = sc.nextInt();
        boolean[] broken = new boolean[10];
        for(int n=0; n<N; n++) {
            broken[sc.nextInt()] = true;
        }

        int min = target;
        int max = target;

        boolean maxConfirmed = false;

        int result = Math.abs(target - 100);
        // 작은거 구하기
        while(min>=0){
            String num = String.valueOf(min);
            boolean isBreak = false;
            for(int i=0; i<num.length(); i++) {
                if(broken[num.charAt(i)-'0']){
                    isBreak = true;
                    min--;
                    break;
                }
            }
            if(!isBreak){
                result = Math.min(result, target - min + num.length());
                break;
            }
        }

        while(max<=999999){
            String num = String.valueOf(max);
            boolean isBreak = false;
            for(int i=0; i<num.length(); i++) {
                if(broken[num.charAt(i)-'0']){
                    isBreak = true;
                    max++;
                    break;
                }
            }
            if(!isBreak){
                result = Math.min(result, max - target + num.length());
                break;
            }
        }

        System.out.println(result);
    }
}
