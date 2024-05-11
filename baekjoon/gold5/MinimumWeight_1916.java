package baekjoon.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinimumWeight_1916 {
    static int V;
    static ArrayList<ArrayList<Bus>> adj;

    static class Bus {
        int no;
        int weight;

        public Bus(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();

        for(int v=0; v<V; v++) {
            adj.add(new ArrayList<Bus>());
        }

        for(int e=0; e<E; e++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int expense = Integer.parseInt(st.nextToken());

            adj.get(from).add(new Bus(to, expense));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken())-1;
        int end = Integer.parseInt(st.nextToken())-1;
        System.out.println(dijkstra(start, end));

    }

    private static int dijkstra(int start, int end) {
        int[] distance = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Bus> pq = new PriorityQueue<>(
                (v1, v2) -> v1.weight - v2.weight
        );
        pq.add(new Bus(start, 0));

        int cnt = 0;
        while(!pq.isEmpty()) {
            Bus b = pq.poll();
            if(visited[b.no]) continue;

            visited[b.no] = true;
            cnt++;

            if(b.no == end || cnt==V) return distance[end];

            for(int i=0; i<adj.get(b.no).size(); i++) {
                Bus next = adj.get(b.no).get(i);

                if(visited[next.no]) continue;

                distance[next.no] = Math.min(distance[next.no], distance[b.no] + next.weight);
                pq.offer(new Bus(next.no, distance[next.no]));
            }
        }

        return distance[end];
    }
}
