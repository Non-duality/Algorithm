import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int result = 0;

    private static int N, M;
    private static int[][] arr;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = { 0, 0,-1, 1};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); // 가로의 길이
            N = Integer.parseInt(st.nextToken()); // 세로의 길이
            int K = Integer.parseInt(st.nextToken()); // 배추의 개수

            result = 0;
            arr = new int[N][M];
            visited = new boolean[N][M];

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                arr[r][c] = 1;
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){

                    if(arr[i][j] == 1 && !visited[i][j]){
                            DFS(i,j);
                            result++;
                    }
                }
            }

            System.out.println(result);


        }

    }

    private static void DFS(int r, int c){

        if(visited[r][c]){
            return;
        }

        visited[r][c] = true;

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                continue;
            }

            if(arr[nr][nc] == 1){
                DFS(nr, nc);
            }

        }

    }
}