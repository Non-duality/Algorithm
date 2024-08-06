import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M, R;
    private static int[] items;
    private static List[] list;
    private static int[] distance;
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        items = new int[N + 1];
        list = new ArrayList[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            items[i + 1] = Integer.parseInt(st.nextToken());
            list[i + 1] = new ArrayList<int[]>();
        }

        int from, to, value;
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());

            list[from].add(new int[] {to, value});
            list[to].add(new int[] {from, value});
        }

        int maxResult = 0;
        for(int i = 1; i <= N; i++){
            int result = getItems(i);
            maxResult = Math.max(maxResult, result);
        }
        System.out.println(maxResult);
    }

    private static int getItems(int start){
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        distance = new int[N + 1];
        Arrays.fill(distance, INF);

        distance[start] = 0;
        pq.offer(new int[] {start, 0});

        int result = 0;
        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int curIdx = current[0];
            int min = current[1];

            if(min > distance[curIdx]) continue;
            result += items[curIdx];

            for(int i = 0; i < list[curIdx].size(); i++){
                int[] next = (int[]) list[curIdx].get(i);

                if(distance[next[0]] > min + next[1] && next[1] + min <= M){
                    distance[next[0]] = min + next[1];
                    pq.offer(new int[]{next[0], distance[next[0]]});
                }
            }
        }
        return result;
    }
}