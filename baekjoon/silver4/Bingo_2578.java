package baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bingo_2578 {

    static int[][] map;
    static boolean[][] checked;
    static int[] orders;
    static int bingo;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];
        checked = new boolean[5][5];

        for(int n=0; n<5; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<5; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        orders = new int[25];
        for(int n=0; n<5; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<5; m++) {
                orders[n*5+m] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        bingo = 0;

        while(ans<25) {
            int num = orders[ans];

            for(int n=0; n<5; n++) {
                for(int m=0; m<5; m++) {
                    if(map[n][m] == num) {
                        checked[n][m] = true;
                        Row(n, m);
                        Column(n, m);
                        Diagonal(n, m);
                    }
                }
            }

            if(bingo >= 3) {
                System.out.println(ans+1);
                break;
            }
            ans++;
        }
    }

    private static void Diagonal(int n, int m) {
        if(n+m != 4 && n!=m) return;

        if(n == m) {
            for(int i=0; i<5; i++) {
                if(checked[i][i] == false) {
                    return;
                }
            }

            bingo++;
        }

        if(n+m == 4) {
            for(int i=0; i<5; i++) {
                if(checked[i][4-i] == false) {
                    return;
                }
            }

            bingo++;
        }

    }

    private static void Column(int n, int m) {
        for(int i=0; i<5; i++) {
            if(checked[i][m] == false) {
                return;
            }
        }

        bingo++;
    }

    private static void Row(int n, int m) {
        for(int i=0; i<5; i++) {
            if(checked[n][i] == false) {
                return;
            }
        }

        bingo++;
    }

}
