import java.util.*;

public class Main {

    static int N, total, ans = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[2 * N];
        for (int i = 0; i < 2 * N; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        // Please write your code here.
        combi(0, 0, 0);
        System.out.println(ans);
    }

    public static void combi(int cur, int sum, int depth) {
        if(depth == N) {
            ans = Math.min(Math.abs(sum - (total - sum)), ans);
            return;
        }

        for(int i=cur; i<2*N; i++) {
            combi(i+1, sum+arr[i], depth+1);
        }
    }
}