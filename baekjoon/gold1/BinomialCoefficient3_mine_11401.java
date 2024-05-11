package baekjoon.gold1;

import java.util.Scanner;

public class BinomialCoefficient3_mine_11401 {
    // 1. key process : overflow 처리
    // % 나머지 연산을 어떻게 처리하는냐에 따라 long에서도 overflow 발생할 수 있기 때문에
    // 주의 해서 처리해야한다.

    // 2. p 가 소수일때 페르마 소정리에 의하면 a ^ (p-1) = 1 (mod p)라는 공식이있음
    // 그러면 a ^ (-1) = a ^ ( p-2)로 역원이 유도가 가능한데,
    // 모듈로연산에서는 나머지가 생각하는것 만큼 쉽지 않기 때문에
    // base ^ (1000000007-2)를 곱해줌으로 처리를 할 거다.
    // 그러면 이때 쓰는게 시간복잡도를 줄이기 위해 분할 정복을 활용
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long K = sc.nextLong();
        K = Math.max(K, N-K);

        long prime = 1000000007;

        long ans = 1L;
        for(long n=N; n>K; n--) {
            ans = (ans * n) % prime;
        }

        long inverse = 1L;
        for(long i=2; i<=N-K; i++) {
            inverse = (inverse * i) % prime;
        }

        ans = (ans * power(inverse % prime, prime-2, prime) % prime);


        System.out.println(ans);
    }

    private static long power(long inverse, long i, long prime) {
        if(i==0) {
            return 1;
        }

        long res = power(inverse, i/2, prime);

        if(i % 2 == 0){
            return res * res % prime;
        }
        else {
            return (res * res % prime) * inverse % prime;
        }
    }
}
