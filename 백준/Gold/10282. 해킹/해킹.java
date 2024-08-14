import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, D, C;
    private static List[] list;
    private static int[] dist;
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 컴퓨터 갯수
            D = Integer.parseInt(st.nextToken()); // 의존성 갯수
            C = Integer.parseInt(st.nextToken()); // 감염된 컴퓨터 번호

            list = new ArrayList[N + 1];
            for(int i = 1; i <= N; i++){
                list[i] = new ArrayList<>();
            }

            int from, to, time;
            for(int i = 0; i < D; i++){
                st = new StringTokenizer(br.readLine());

                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                time = Integer.parseInt(st.nextToken());

                list[to].add(new int[]{from, time});
            }

            dist = new int[N + 1];
            getInfection();

            int cnt = 0;
            int maxTime = 0;
            for(int i = 1; i <= N; i++){
                if(dist[i] == INF) continue;

                cnt ++;
                maxTime = Math.max(maxTime, dist[i]);
            }

            sb.append(cnt).append(" ").append(maxTime).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void getInfection(){
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));

        Arrays.fill(dist, INF);
        dist[C] = 0;
        pq.offer(new int[]{C, 0});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int curIdx = current[0];
            int time = current[1];

            for(int i = 0; i < list[curIdx].size(); i++){
                int[] next = (int[]) list[curIdx].get(i);

                if(dist[next[0]] > next[1] + time){
                    dist[next[0]] = next[1] + time;
                    pq.offer(new int[] {next[0], dist[next[0]]});
                }
            }
        }
    }
}