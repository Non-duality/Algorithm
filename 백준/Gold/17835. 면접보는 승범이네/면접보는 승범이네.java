import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M, K;
    private static List[] list;

    private static long[] distance;
    private static long INF = Long.MAX_VALUE;
    private static Queue<long[]> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

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

            list[to].add(new int[] {from, dist});
        }

        st = new StringTokenizer(br.readLine());
        pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
        distance = new long[N + 1];
        Arrays.fill(distance, INF);

        for(int i = 0; i < K; i++){
            int place = Integer.parseInt(st.nextToken());
            pq.offer(new long[] {place, 0});
            distance[place] = 0;
        }

        dijkstra();

        int city = 0;
        long result = 0;
        for(int i = 1; i <= N; i++){
            if(result < distance[i]){
                result = distance[i];
                city = i;
            }
        }

        System.out.println(city);
        System.out.println(result);

    }

    private static void dijkstra(){

        while(!pq.isEmpty()){
            long [] current = pq.poll();
            int curIdx = (int) current[0];
            long min = current[1];

            if(distance[curIdx] < min) continue;

            for(int i = 0; i < list[curIdx].size(); i++){
                int[] next = (int[]) list[curIdx].get(i);

                if(distance[next[0]] > next[1] + min){
                    distance[next[0]] = next[1] + min;
                    pq.offer(new long[] {next[0], distance[next[0]]});
                }
            }
        }

    }
}