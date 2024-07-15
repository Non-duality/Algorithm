import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, K;
    private static int[][] map;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = { 0, 0,-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        int result = BFS();
        System.out.println(result);

    }

    private static int BFS() {
        PriorityQueue<int[]> dq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        boolean[][][] visited = new boolean[N][M][K+1];

        visited[0][0][0] = true;
        dq.offer(new int[] {0, 0, 1, 0}); // r, c, 이동거리, 벽을 부신 횟수

        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int moveCnt = cur[2];
            int breakCnt = cur[3];

            if(cur[0] == N-1 && cur[1] == M-1){
                return moveCnt;
            }

            for(int d = 0; d < 4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }

                if(map[nr][nc] == 1 && breakCnt < K &&!visited[nr][nc][breakCnt + 1]){
                        visited[nr][nc][breakCnt + 1] = true;
                        dq.offer(new int[] {nr, nc, moveCnt + 1, breakCnt + 1});
                }

                if(map[nr][nc] == 0 && !visited[nr][nc][breakCnt]){
                    visited[nr][nc][breakCnt] = true;
                    dq.offer(new int[] {nr, nc, moveCnt + 1, breakCnt});
                }

            }

        }


        return -1;
    }
}