import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int M, N, K;
    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = { 0, 0,-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int lc = Integer.parseInt(st.nextToken());
            int lr = Integer.parseInt(st.nextToken());
            int rc = Integer.parseInt(st.nextToken()) - 1;
            int rr = Integer.parseInt(st.nextToken()) - 1;

            for(int j = 0; j < rr - lr + 1; j++){
                int sr = lr + j;

                for(int k = 0; k < rc - lc + 1; k++){
                    int sc = lc + k;

                    map[sr][sc] = 1;
                }
            }
        }

        visited = new boolean[M][N];

        List<Integer> list = new ArrayList<>();

        int count = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1){
                    continue;
                }

                if(visited[i][j]){
                    continue;
                }

                int size = BFS(i, j);
                list.add(size);
                count ++;
            }
        }

        Collections.sort(list);

        System.out.println(count);
        for(int i : list){
            System.out.print(i + " ");
        }
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

                if(nr < 0 || nr >= M || nc < 0 || nc >= N){
                    continue;
                }

                if(visited[nr][nc]){
                    continue;
                }

                if(map[nr][nc] == 1) {
                    continue;
                }

                size ++;
                visited[nr][nc] = true;
                dq.offer(new int[] {nr, nc});
            }

        }

        return size;
    }
}