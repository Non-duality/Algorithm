import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M; // 건물의 개수, 도로의 개수
    static ArrayList[] arr = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            arr[i] = new ArrayList<Integer>();
        }

        int from, to;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            arr[from].add(to);
            arr[to].add(from);
        }

        int[] result = new int[3];
        int sum;
        int minSum = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++){
            for(int j = i + 1; j <= N; j++){
                sum = BFS(i,j);
                if(minSum > sum){
                    minSum = sum;
                    result = new int[]{i,j,minSum};
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0; i < 3; i++){
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    static int BFS(int chicken1, int chicken2){
        Queue<int[]> q = new ArrayDeque<>();

        // chicken1에서 시작해서 다른 지역으로 갈 때 걸리는 시간을 저장하는 배열
        int[] distArr = new int[N + 1];
        // 방문 배열
        boolean[] visited = new boolean[N + 1];
        // 치킨 1번집에서 탐색 시작
        visited[chicken1] = true;
        q.offer(new int[]{chicken1, 0});

        while(!q.isEmpty()){
            int[] curArr = q.poll();

            for(int i = 0; i < arr[curArr[0]].size(); i++){
                // 다음 도시 찾아서
                int nextCity = (Integer)arr[curArr[0]].get(i);
                // 방문한 도시면 건너뜀
                if(visited[nextCity]){
                    continue;
                }
                distArr[nextCity] = curArr[1] + 1;
                visited[nextCity] = true;
                q.offer(new int[]{nextCity, distArr[nextCity]});

            }

        }

        // 방문 배열
        visited = new boolean[N + 1];
        // 두번째 치킨집 왕복 계산
        visited[chicken2] = true;
        q.offer(new int[]{chicken2, 0});
        distArr[chicken2] = 0;

        while(!q.isEmpty()){
            int[] curArr = q.poll();

            for(int i = 0; i < arr[curArr[0]].size(); i++){
                // 다음 도시 찾아서
                int nextCity = (Integer)arr[curArr[0]].get(i);
                // 방문한 도시면 건너뜀
                if(visited[nextCity]){
                    continue;
                }

                if(distArr[nextCity] > curArr[1]){
                    distArr[nextCity] = curArr[1] + 1;
                }
                visited[nextCity] = true;
                q.offer(new int[]{nextCity, curArr[1] + 1});
            }

        }

        // 왕복거리 반환
        int sum = 0;
        for(int i = 1; i <= N; i++){
            sum += distArr[i];
        }

        return sum * 2;
    }
}