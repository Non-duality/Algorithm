import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N,M;
    private static List[] list;
    private static long[] distance;
    private static long INF = Long.MAX_VALUE;

    private static int START, END;
    private static int[] route;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<int[]>();
        }

        int from, to, fee;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            fee = Integer.parseInt(st.nextToken());

            list[from].add(new int[]{to, fee});
        }

        st = new StringTokenizer(br.readLine());
        START = Integer.parseInt(st.nextToken());
        END = Integer.parseInt(st.nextToken());

        distance = new long[N + 1];
        route = new int[N + 1];
        getValue();
        System.out.println(distance[END]);

        List<Integer> routes = new ArrayList<>();
        int temp = END;
        while(temp != 0){
            routes.add(temp);
            temp = route[temp];
        }
        System.out.println(routes.size());
        for(int i = routes.size() - 1; i >= 0; i--){
            System.out.print(routes.get(i) + " ");
        }
    }

    private static void getValue(){

        Queue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(distance, INF);

        distance[START] = 0;
        pq.offer(new long[] {START, 0});

        while(!pq.isEmpty()){
            long[] current = pq.poll();
            int curIdx = (int)current[0];
            long min = current[1];

            if(visited[curIdx]) continue;
            visited[curIdx] = true;

            for(int i = 0; i < list[curIdx].size(); i++){
                int[] next = (int[]) list[curIdx].get(i);

                if(visited[next[0]]) continue;

                if(distance[next[0]] > next[1] + min){
                    distance[next[0]] = next[1] + min;
                    route[next[0]] = curIdx;
                    pq.offer(new long[] {next[0], distance[next[0]]});
                }
            }
        }
    }
}