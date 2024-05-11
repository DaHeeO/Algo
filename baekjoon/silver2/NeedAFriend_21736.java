package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NeedAFriend_21736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] campus = new char[N][M];

        for(int n=0; n<N; n++) {
            campus[n] = br.readLine().toCharArray();
        }

        int start = 0;


        for(int n=0; n<N; n++) {
            for(int m=0; m<M; m++) {
                if(campus[n][m] == 'I'){
                    start = n*M + m;
                }
            }
        }

        int encountered = 0;
        int[][] deltas = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

        boolean[][] visited = new boolean[N][M];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start/M][start%M] = true;

        while(!q.isEmpty()){
            int idx = q.poll();
            int x = idx/M;
            int y = idx%M;

            for(int d=0; d<4; d++) {
                int nx = x + deltas[d][0];
                int ny = y + deltas[d][1];

                // out of range OR already visited
                if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny]) continue;

                // wall
                if(campus[nx][ny] == 'X') continue;

                if(campus[nx][ny] == 'P') encountered++;

                visited[nx][ny] = true;
                q.add(nx * M + ny);

            }
        }

        System.out.println(encountered==0 ? "TT" : encountered);

    }
}
