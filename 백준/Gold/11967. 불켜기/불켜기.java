import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[][] map;
    private static Map<String, List<int[]>> switchInfo;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = { 0, 0,-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        switchInfo = new HashMap<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            String key = x + "+" + y;
            int[] value = new int[2];
            value[0] = a;
            value[1] = b;

            if(!switchInfo.containsKey(key)){
                List<int[]> list = new ArrayList<>();
                list.add(value);
                switchInfo.put(key, list);
            }
            else{
                switchInfo.get(key).add(value);
            }
        }

        int result = turnOn();
        System.out.println(result);

    }

    private static int turnOn(){
        int result = 1;
        Queue<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        dq.offer(new int[] {0,0});
        map[0][0] = 1; // 시작 방 불켜기
        visited[0][0] = true;

        // 불을 켰다면 탐색 시작
        while(!dq.isEmpty()){
            int[] cur = dq.poll();

            // 방에 스위치가 있는지 확인하고 불 키기
            String key = cur[0] + "+" + cur[1];
            if(switchInfo.containsKey(key)){
                List<int[]> list = switchInfo.get(key);
                for(int[] info : list){
                    if(map[info[0]][info[1]] == 0){
                        map[info[0]][info[1]] = 1;
                        result++;
                        visited = new boolean[N][N];
                        visited[cur[0]][cur[1]] = true;
                    }
                }
            }

            for(int d = 0; d < 4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N){
                    continue;
                }

                if(visited[nr][nc]){
                    continue;
                }

                if(map[nr][nc] == 0){
                    continue;
                }

                visited[nr][nc] = true;
                dq.offer(new int[] {nr, nc});
            }
        }

        return result;
    }
}