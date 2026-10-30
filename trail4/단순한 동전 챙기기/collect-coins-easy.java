import java.util.*;
import java.lang.*;

public class Main {

    static int N, size, ans = Integer.MAX_VALUE;
    static ArrayList<int[]> grid;
    static int[] idxOfGrid = new int[5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new ArrayList<>();
        size = 0; 
        // 입력
        for (int i = 0; i < N; i++) {
            String temp = sc.next();
            for(int j=0; j<N; j++) {
                char t = temp.charAt(j);

                if(t == '.') continue;

                if(t == 'S') grid.add(new int[] {0, i, j});
                else if(t == 'E') grid.add(new int[] {10, i, j});
                else grid.add(new int[] {t-'0', i, j});
            }
        }

        // 0: 시작, 
        // 10 : 끝
        grid.sort((a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        size = grid.size();
        idxOfGrid[0] = 0;
        idxOfGrid[4] = size-1;

        // 동전이 3개 미만이라서 -1 출력
        if(size < 5) {
            System.out.println(-1);
        }else { // 계산할 수 있다면 조합을 이용해서 최소거리를 bruteForce로 구해본다. 
            combination(1, 0);
            System.out.println(ans);
        }

    }

    static void combination(int cur, int depth) {
        if(depth == 3) {
            int tmp = 0;
            for(int i=1; i<5; i++) {
                int[] start = grid.get(idxOfGrid[i-1]);
                int[] end = grid.get(idxOfGrid[i]);
                int dx = Math.abs(start[1] - end[1]);
                int dy = Math.abs(start[2] - end[2]);
                tmp += (dx + dy);
            }
            ans = Math.min(tmp, ans);

            return;
        }
        for(int i = cur; i<size-1; i++) {
            idxOfGrid[depth+1] = i;
            combination(i+1, depth+1);
        }

    }
}