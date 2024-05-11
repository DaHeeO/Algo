package baekjoon.silver2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinHeap_1927 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = sc.nextInt();
        for(int n=0; n<N; n++) {
            int num = sc.nextInt();
            if(num>0){
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
