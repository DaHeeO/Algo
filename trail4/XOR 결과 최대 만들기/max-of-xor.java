import java.util.*;

public class Main {

    static int n, m, ans;
    static int[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        // Please write your code here.

        ans = 0;
        Combination(0, 0, 0);

        System.out.println(ans);
    }

    public static void Combination(int cur, int depth, int res) {
        if(depth == m) {
            ans = Math.max(ans, res);
            return;
        }

        for(int i = cur; i<n; i++) {
            Combination(i + 1, depth+1, res ^ A[i]);
        }
    }
}