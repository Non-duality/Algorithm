import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        int maxVal = 0;
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxVal = Math.max(map[i][j], maxVal);
            }
        }

        int maxResult = 0;
        int cnt = 0;
        for(int i = 0; i < maxVal; i++){
            visited = new boolean[N][N];
            cnt = 0;
            for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c++){
                    if(!visited[r][c] && map[r][c] > i){
                        DFS(i, r, c);
                        cnt++;
                    }
                }

            }

            maxResult = Math.max(cnt, maxResult);
        }

        System.out.println(maxResult);
    }

    private static void DFS(int rainHeight, int r, int c){

        visited[r][c] = true;

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= N){
                continue;
            }

            if(visited[nr][nc]){
                continue;
            }

            if(map[r][c] <= rainHeight){
                continue;
            }

            DFS(rainHeight, nr, nc);
        }
    }
}