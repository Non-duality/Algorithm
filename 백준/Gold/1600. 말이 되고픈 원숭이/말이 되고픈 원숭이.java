import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int K, W, H;
    private static int[][] map;
    private static boolean[][][] visited;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = { 0, 0,-1, 1};

    private static int[] hr = {-1, -2,-2,-1, 1, 2, 2, 1};
    private static int[] hc = {-2, -1, 1, 2,-2,-1, 1, 2};

    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS();
        System.out.println(result);
    }

    private static void BFS() {
        Queue<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {0, 0, 0, 0}); // r, c, 말 이동, 총 이동
        visited[0][0][0] = true;

        while(!dq.isEmpty()){
            int[] current = dq.poll();
            int r = current[0];
            int c = current[1];
            int horseMove = current[2];
            int totalMove = current[3];

            if(r == H - 1 && c == W - 1){
                result = totalMove;
                return;
            }

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= H || nc < 0 || nc >= W){
                    continue;
                }

                if(map[nr][nc] == 1){
                    continue;
                }

                if(visited[nr][nc][horseMove]){
                    continue;
                }

                visited[nr][nc][horseMove] = true;
                dq.offer(new int[] {nr, nc, horseMove, totalMove + 1});
            }

            if(horseMove < K){
                for(int d = 0; d < 8; d++){
                    int nr = r + hr[d];
                    int nc = c + hc[d];

                    if(nr < 0 || nr >= H || nc < 0 || nc >= W){
                        continue;
                    }

                    if(map[nr][nc] == 1){
                        continue;
                    }

                    if(visited[nr][nc][horseMove + 1]){
                        continue;
                    }

                    visited[nr][nc][horseMove + 1] = true;
                    dq.offer(new int[] {nr, nc, horseMove + 1, totalMove + 1});
                }
            }
        }

    }
}