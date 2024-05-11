package baekjoon.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShortestPath_1753 {

    static int V;
    static ArrayList<ArrayList<Vertex>> adj;
    static int[] distance;

    static class Vertex implements Comparable<Vertex>{
        int no;
        int weight;

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }


        @Override
        public int compareTo(Vertex v) {
            return this.weight - v.weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine())-1;

        adj = new ArrayList<>();

        for(int v=0; v<V; v++) {
            adj.add(new ArrayList<Vertex>());
        }

        for(int e=0; e<E; e++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            adj.get(a).add(new Vertex(b, w));
        }

        dijkstra(start);

        for(int v=0; v<V; v++) {
            sb.append(distance[v] == Integer.MAX_VALUE ? "INF" : distance[v]).append('\n');
        }

        System.out.println(sb);

    }

    private static void dijkstra(int start) {

        distance = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(start, 0));

        int cnt = 0;
        while(!pq.isEmpty()) {
            Vertex v = pq.poll();
            int minVertex = v.no;

            if(visited[minVertex]) continue;

            visited[minVertex] = true;
            cnt++;

            if(cnt == V) break;

            for(int i=0; i<adj.get(minVertex).size(); i++) {
                Vertex next = adj.get(minVertex).get(i);

                if(visited[next.no]) continue;

                distance[next.no] = Math.min(distance[next.no], distance[minVertex] + next.weight);
                pq.offer(new Vertex(next.no, distance[next.no]));

            }
        }

    }
}
