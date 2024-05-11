package baekjoon.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class DualPriorityQueue_7662 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int Q = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> pq = new TreeMap<>();
            for(int q=0; q<Q; q++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                if(command.equals("I")) {
                    int num = Integer.parseInt(st.nextToken());
                    // 몇개 있는지 value값에 저장 이렇게 되면 key값 덮어씌워짐
                    pq.put(num, pq.getOrDefault(num, 0) +1);
                }
                else {
                    if(pq.isEmpty()) continue;
                    int type = Integer.parseInt(st.nextToken());
                    int num;
                    if(type == 1) {
                        num = pq.lastKey();
                    }
                    else {
                        num = pq.firstKey();
                    }
                    // num을 key로 갖고있는 원소가 value가 1일때만 삭제 가능
                    pq.put(num, pq.get(num)-1);
                    if(pq.get(num) == 0) pq.remove(num);
                }
            }
            if(pq.isEmpty()) {
                sb.append("EMPTY").append('\n');
            }
            else {
                sb.append(pq.lastKey()).append(' ').append(pq.firstKey()).append('\n');
            }

        }
        System.out.println(sb);
    }

}
