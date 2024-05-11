package baekjoon.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PathFinding_11403 {

    static int N;
    static int[][] adjMatrix;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        adjMatrix = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] pathExist = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(BFS(i, j) ? 1 : 0).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    private static boolean BFS(int i, int j) {

        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();

        q.add(i);

        int cnt = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                int cur = q.poll();
                if(cnt != 0 && cur == j) {
                    return true;
                }

                for(int n=0; n<N; n++) {
                    if(adjMatrix[cur][n] == 1 && !visited[n]){
                        visited[n] = true;
                        q.add(n);
                    }
                }

            }
            cnt++;
        }

        return false;
    }
}
