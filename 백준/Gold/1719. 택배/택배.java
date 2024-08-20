import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M;
    private static List[] list;
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<int[]>();
        }

        int from, to, dist;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            dist = Integer.parseInt(st.nextToken());

            list[from].add(new int[] {to, dist});
            list[to].add(new int[] {from, dist});
        }

        for(int i = 1; i <= N; i++){
            int[] route = dijkstra(i);

            for(int j = 1; j <= N; j++){
                if (i == j) {
                    sb.append("-").append(" ");
                    continue;
                }
                int prev = j;
                while(true){
                    if(route[prev] == i) break;
                    prev = route[prev];
                }
                sb.append(prev).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int[] dijkstra(int start){
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        int[] distance = new int[N + 1];
        int[] route = new int[N + 1];
        Arrays.fill(distance, INF);

        distance[start] = 0;
        pq.offer(new int[] {start, 0});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int curIdx = current[0];
            int curDist = current[1];

            for(int i = 0; i < list[curIdx].size(); i++){
                int[] next = (int[]) list[curIdx].get(i);

                if(distance[next[0]] >  next[1] + curDist){
                    distance[next[0]] = next[1] + curDist;
                    route[next[0]] = curIdx;
                    pq.offer(new int[] {next[0], distance[next[0]]});
                }
            }
        }

        return route;
    }
}