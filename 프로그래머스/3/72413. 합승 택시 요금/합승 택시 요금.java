import java.util.*;

class Solution {
    static List[] list;
    static int N;
    static int INF = Integer.MAX_VALUE;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;

        N = n;
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        int from, to, cost;
        for(int i = 0; i < fares.length; i++){
            from = fares[i][0];
            to = fares[i][1];
            cost = fares[i][2];

            list[from].add(new int[] {to, cost});
            list[to].add(new int[] {from, cost});
        }

        int[] costA = dijkstra(a);
        int[] costB = dijkstra(b);
        int[] costS = dijkstra(s);

        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, costS[i] + costA[i] + costB[i]);
        }

        return answer;
    }

    // 경로랑 다익스트라 값 뱉기
    public static int[] dijkstra(int start){
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);

        distance[start] = 0;
        pq.offer(new int[] {start, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curIdx = cur[0];
            int curCost = cur[1];

            for(int i = 0; i < list[curIdx].size(); i++){
                int[] next = (int[]) list[curIdx].get(i);

                if(distance[next[0]] > next[1] + curCost){
                    distance[next[0]] = next[1] + curCost;
                    pq.offer(new int[]{next[0], distance[next[0]]});
                }

            }
        }

        return distance;
    }
}