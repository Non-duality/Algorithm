import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = { 0, 0,-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        List<int[]> list = new ArrayList<>();

        int temp;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;

                if(temp == 1){
                    list.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[N][M];

        int[] arr;
        int count = 0;
        int maxSize = 0;
        for(int i = 0; i < list.size(); i++){
            arr = list.get(i);
            if(visited[arr[0]][arr[1]]){
                continue;
            }
            int size = BFS(arr[0], arr[1]);
            count++;

            maxSize = Math.max(maxSize, size);

        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    private static int BFS(int r, int c){
        Queue<int[]> dq = new ArrayDeque<>();

        dq.offer(new int[] {r, c});
        visited[r][c] = true;
        int size = 1;

        while(!dq.isEmpty()){
            int[] curr = dq.poll();

            for(int d = 0; d < 4; d++){
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                    continue;
                }

                if(visited[nr][nc]){
                    continue;
                }

                if(map[nr][nc] == 0){
                    continue;
                }

                visited[nr][nc] = true;
                size ++;
                dq.offer(new int[] {nr, nc});
            }
        }

        return size;
    }
}