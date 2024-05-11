package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MaxHeap_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });

        for(int n=0; n<N; n++) {
            int num = Integer.parseInt(br.readLine());
            if(num>0) {
                pq.add(num);
            }
            else{
                if(pq.isEmpty()){
                    sb.append(0).append('\n');
                }
                else{
                    sb.append(pq.poll()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
