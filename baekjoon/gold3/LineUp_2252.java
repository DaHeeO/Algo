package baekjoon.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LineUp_2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int n=0; n<N; n++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[N];

        // 진입차수 카운트 및 연결리스트 추가
        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adj.get(a).add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // 초기 진입차수 0인것 넣기
        for(int n=0; n<N; n++) {
            if(indegree[n]==0) {
                q.add(n);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            sb.append(node+1).append(' ');

            // 진출차수 반영 및 0인거 집어넣기
            for(int next : adj.get(node)) {
                if(--indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        System.out.println(sb);
    }
}
