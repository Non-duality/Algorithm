import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int I;
    private static int[] dr = {-1, -2,-2,-1, 1, 2, 2, 1};
    private static int[] dc = {-2, -1, 1, 2,-2,-1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int TC = Integer.parseInt(br.readLine());

        for(int t = 0; t < TC; t++){
            I = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] currP = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            st = new StringTokenizer(br.readLine());
            int[] wantP = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            int result = BFS(currP, wantP);

            if(result != -1){
                System.out.println(result);
            }

        }

    }

    private static int BFS(int[] curr, int[] wantP) {
        Queue<int[]> dq = new ArrayDeque<>();

        boolean[][] visited = new boolean[I][I];
        dq.offer(new int[] {curr[0], curr[1], 0}); // 현재위치 r c, 이동횟수
        visited[curr[0]][curr[1]] = true;

        while(!dq.isEmpty()){
            int[] info = dq.poll();
            int r = info[0];
            int c = info[1];
            int move = info[2];

            if(r == wantP[0] && c == wantP[1]){
                return move;
            }

            for(int d = 0; d < 8; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= I || nc < 0 || nc >= I){
                    continue;
                }

                if(visited[nr][nc]){
                    continue;
                }

                visited[nr][nc] = true;
                dq.offer(new int[] {nr, nc, move + 1});

            }
        }

        return -1;
    }
}