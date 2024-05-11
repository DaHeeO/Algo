package baekjoon.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetromino_14500 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        // 여기서 backtracking할때 true/false가 잘안먹어서 처음에
        // visited = new boolean[][]을 계속하면서
        /* visited = new boolean[N][M];
        visited[n][m] = true;
        DFS(n, m, 1, map[n][m]); */
        //이렇게 했는데 이러면 시초가 나요

        // 왜냐면 N, M < 500인데 최대로 생각하면
        // 250000 번을 배열을 재할당하는데 시간이 많이 소요되기 때문에
        // 배열을 만들어놓고 재사용하는게 좋은 코드임


        for(int n=0; n<N; n++) {
            for(int m=0; m<M; m++) {
                visited[n][m] = true;
                DFS(n, m, 1, map[n][m]);
                visited[n][m] = false;
            }
        }

        System.out.println(res);

    }

    private static void DFS(int n, int m, int step, int total) {
        // 이렇게 하면 뻑큐가 구현이 안된다... 우째하냐면
        //  step = 2에서 양갈래로 뻗어나갈 수 있도록 한개씩 더 추가해주는거 구현

        if(step == 4) {
            res = Math.max(total, res);
            return;
        }

        for(int d=0; d<4; d++) {
            int nx = n + deltas[d][0];
            int ny = m + deltas[d][1];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            DFS(nx, ny, step+1, total+map[nx][ny]);
            visited[nx][ny] = false;

            // 뻑큐 구현을 위해 2번째에서 바로 step 4로 넘어가면서 2개를 추가해는 로직
            if(step == 2) {
                int nd = (d+1) % 4;
                int nx2 = n + deltas[nd][0];
                int ny2 = m + deltas[nd][1];

                if(nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= M || visited[nx2][ny2]) continue;

                res = Math.max(total + map[nx][ny] + map[nx2][ny2], res);
            }

        }

    }
}
