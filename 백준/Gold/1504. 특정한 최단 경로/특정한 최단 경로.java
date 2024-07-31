import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, E;
    private static List[] list;
    private static int mustFirst, mustSecond;
    private static int[] distance;
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        int from, to, weight;
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            list[from].add(new int[] {to, weight});
            list[to].add((new int[] {from, weight}));

        }
        st = new StringTokenizer(br.readLine());

        mustFirst = Integer.parseInt(st.nextToken());
        mustSecond = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];

        int result1 = 0;
        while(true){
            getDistance(1);
            if(distance[mustFirst] == INF){
                result1 = -1;
                break;
            }
            result1 += distance[mustFirst];

            getDistance(mustFirst);
            if(distance[mustSecond] == INF){
                result1 = -1;
                break;
            }
            result1 += distance[mustSecond];

            getDistance(mustSecond);
            if(distance[N] == INF){
                result1 = -1;
                break;
            }
            result1 += distance[N];
            break;
        }

        int result2 = 0;
        while(true){
            getDistance(1);
            if(distance[mustSecond] == INF){
                result2 = -1;
                break;
            }
            result2 += distance[mustSecond];

            getDistance(mustSecond);
            if(distance[mustFirst] == INF){
                result2 = -1;
                break;
            }
            result2 += distance[mustFirst];

            getDistance(mustFirst);
            if(distance[N] == INF){
                result2 = -1;
                break;
            }
            result2 += distance[N];
            break;
        }

        if(result1 == -1 && result2 == -1){
            System.out.println(-1);
        } else if (result1 == -1){
            System.out.println(result2);
        } else if (result2 == -1){
            System.out.println(result1);
        } else{
            System.out.println(Math.min(result1, result2));
        }

    }

    private static void getDistance(int start){

        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(distance, INF);

        distance[start] = 0;
        pq.offer(new int[] {start, 0});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int curIdx = current[0];
            int min = current[1];

            if(visited[curIdx]) continue;

            visited[curIdx] = true;

            for(int i = 0; i < list[curIdx].size(); i++){
                int[] next = (int[])list[curIdx].get(i);

                if(visited[next[0]]) continue;

                if(distance[next[0]] > next[1] + min){
                    distance[next[0]] = next[1] + min;
                    pq.offer(new int[] {next[0], distance[next[0]]});
                }
            }
        }
    }
}