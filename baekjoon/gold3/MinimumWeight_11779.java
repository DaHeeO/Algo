package baekjoon.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinimumWeight_11779 {

    static int V;
    static ArrayList<ArrayList<Bus>> adj;
    static int[] previousNode;
    static class Bus implements Comparable<Bus>{
        int no;
        int weight;

        public Bus(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Bus bus) {
            return this.weight - bus.weight;
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
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());

            adj.get(start).add(new Bus(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken())-1;
        int end = Integer.parseInt(st.nextToken())-1;

        previousNode = new int[V];
        System.out.println(dijstra(start, end));

        ArrayList<Integer> routes = new ArrayList<>();
        int cur = end;
        while(cur != -1) {
            routes.add(cur);
            cur = previousNode[cur];
        }

        System.out.println(routes.size());
        for(int i=routes.size()-1; i>=0; i--) {
            System.out.print(routes.get(i)+1 + " ");
        }

    }

    private static int dijstra(int start, int end) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        previousNode[start] = -1;

        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.add(new Bus(start, 0));

        int cnt = 0;
        while(!pq.isEmpty()) {
            Bus b = pq.poll();
            if(visited[b.no]) continue;
            visited[b.no] = true;
            cnt++;

            if(b.no == end || cnt==V) return dist[end];

            for(int i=0; i<adj.get(b.no).size(); i++) {
                Bus next = adj.get(b.no).get(i);

                if(visited[next.no]) continue;

                if(dist[next.no] > dist[b.no] + next.weight) {
                    dist[next.no] = dist[b.no] + next.weight;
                    pq.offer(new Bus(next.no, dist[next.no]));
                    previousNode[next.no] = b.no;
                }
            }

        }

        return dist[end];
    }
}
