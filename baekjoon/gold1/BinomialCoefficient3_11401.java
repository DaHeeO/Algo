package baekjoon.gold1;

import java.util.Scanner;

public class BinomialCoefficient3_11401 {

    static long prime = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long K = sc.nextLong();

        long numerator = factorial(N);

        long denomenator = factorial(K) * factorial(N-K) % prime;

        System.out.println(numerator * power(denomenator, prime - 2) % prime);

    }

    private static long factorial(long n) {

        long fac = 1L;

        while(n>1) {
            fac = (fac * n) % prime;
            n--;
        }

        return fac;

    }

    private static long power(long base, long expo) {
        if(expo==1) {
            return base % prime;
        }

        long temp = power(base, expo/2);

        if(expo % 2 == 1){
            return (temp * temp % prime) * base % prime;
        }
        return temp * temp % prime;
    }
}
