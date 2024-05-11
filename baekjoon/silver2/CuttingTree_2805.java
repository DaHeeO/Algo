package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CuttingTree_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        int M = Integer.parseInt(st.nextToken());

        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++) {
            tree[n] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[n]);
        }

        while(min < max) {

            int mid = (min + max) /2;
            long sum = 0;
            for(int t : tree) {
                if(t > mid) {
                    sum += (t - mid);
                }
            }
            if(sum < M) {
                max = mid;
            }
            else {
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
}
