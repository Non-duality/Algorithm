import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M;
    private static int A, B, C;

    private static List[] list;
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
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

        int[] distA = dijkstra(A);
        int[] distB = dijkstra(B);
        int[] distC = dijkstra(C);

        int maxMinDistance = -1;
        int answer = -1;

        for(int i = 1; i <= N; i++){
            int minDist = Math.min(distA[i], Math.min(distB[i], distC[i]));
            if(minDist > maxMinDistance){
                maxMinDistance = minDist;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    private static int[] dijkstra(int start){
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        int[] distance = new int[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.offer(new int[] {start, 0});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int curIdx = current[0];
            int curDist = current[1];

            if(curDist > distance[curIdx]) continue;

            for(int i = 0; i < list[curIdx].size(); i++){
                int[] next = (int[]) list[curIdx].get(i);

                if(distance[next[0]] > next[1] + curDist){
                    distance[next[0]] = next[1] + curDist;
                    pq.offer(new int[] {next[0], distance[next[0]]});
                }
            }
        }

        return distance;
    }
}