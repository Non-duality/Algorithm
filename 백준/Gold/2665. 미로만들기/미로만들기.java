import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    private static int N;
    private static int[][] map;
    private static int[][] distance;

    private static int INF = Integer.MAX_VALUE;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = { 0, 0,-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        distance = new int[N][N];

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = temp.charAt(j) - '0';
                distance[i][j] = INF;
            }
        }

        getCnt();
        System.out.println(distance[N-1][N-1]);
    }

    private static void getCnt() {
        Queue<int[]> q = new ArrayDeque<>();

        distance[0][0] = 0;
        q.offer(new int[] {0, 0});

        while(!q.isEmpty()){
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                if(distance[nr][nc] > distance[r][c]){
                    if(map[nr][nc] == 1) distance[nr][nc] = distance[r][c];
                    else distance[nr][nc] = distance[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}