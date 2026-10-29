import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // Please write your code here.

        arr = new int[m];
        Combination(0, 0);
    }

    public static void Combination(int depth, int cur) {
        if(depth == m) {
            for(int i=0; i<m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=cur+1; i<=n; i++) {
            arr[depth] = i;
            Combination(depth+1, i);
        }
    }
}