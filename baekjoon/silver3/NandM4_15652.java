package baekjoon.silver3;

import java.util.Scanner;

public class NandM4_15652 {

    static int N, M;
    static int[] res;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         N = sc.nextInt();
         M = sc.nextInt();

         res = new int[M];

         sequence(1, 0);

        System.out.println(sb);
    }

    private static void sequence(int cur, int step) {

        if(step == M){
            for(int a: res) {
                sb.append(a).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=cur; i<=N; i++){
            res[step] = i;
            sequence(i, step+1);
        }
    }


}
