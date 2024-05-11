package baekjoon.silver1;

import java.util.Scanner;

public class Multiplication_1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(power(A, B, C));

    }

    private static long power(int a, int b, int c) {
        if(b == 1){
            return a % c;
        }

        long x = power(a, b/2, c);

        if(b % 2 == 0) {
            return x * x % c;
        }
        else {
            return  (x * x % c) * a % c;
        }
    }
}
