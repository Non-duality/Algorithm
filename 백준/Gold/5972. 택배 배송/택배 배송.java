import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M;
    private static List[] list;
    private static int[] dist;
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<int[]>();
        }

        int from, to, value;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());

            list[from].add(new int[] {to, value});
            list[to].add(new int[] {from, value});
        }

        dist = new int[N + 1];
        dijkstra();
        System.out.println(dist[N]);
    }

    private static void dijkstra() {
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));

        Arrays.fill(dist, INF);
        dist[1] = 0;
        pq.offer(new int[] {1, 0});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int curIdx = current[0];
            int value = current[1];

            for(int i = 0; i < list[curIdx].size(); i++){
                int[] next = (int[]) list[curIdx].get(i);

                if(dist[next[0]] > next[1] + value){
                    dist[next[0]] = next[1] + value;
                    pq.offer(new int[] {next[0], dist[next[0]]});
                }
            }
        }
    }
}