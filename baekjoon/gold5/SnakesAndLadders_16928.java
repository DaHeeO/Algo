package baekjoon.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SnakesAndLadders_16928 {

    static int[] snakeAndLadder =  new int[100];
    static boolean[] visited = new boolean[100];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        for(int i=0; i<S+L; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;

            snakeAndLadder[from] = to;
        }

        System.out.println(bfs());

    }

    private static int bfs() {

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0) {
                int cur = q.poll();
                visited[cur] = true;

                if(cur == 99) {
                    return cnt;
                }

                for(int i=1; i<7; i++) {
                    int next = cur + i;
                    if(next > 99 || visited[next]) continue;
                    visited[next] = true;

                    // 뱀이거나 사다리면
                    if(snakeAndLadder[next]!=0) {
                        int jump = snakeAndLadder[next];
                        visited[jump] = true;
                        q.add(jump);
                    }
                    else {
                        q.add(next);
                    }
                }
            }
            cnt++;
        }

        return cnt;
    }
}
