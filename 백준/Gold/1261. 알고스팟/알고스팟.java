import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N,M;
    private static int[][] map;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = { 0, 0,-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        int result = getBreakCnt();
        System.out.println(result);
    }

    public static int getBreakCnt(){

        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        boolean[][] visited = new boolean[N][M];

        visited[0][0] = true;
        pq.offer(new int[]{0, 0, 0}); // r, c, breakCnt;

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int cr = current[0];
            int cc = current[1];
            int bcnt = current[2];

            if(cr == N - 1 && cc == M -1){
                return bcnt;
            }

            for(int d = 0; d < 4; d++){

                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc]) continue;

                if(map[nr][nc] == 1){
                    visited[nr][nc] = true;
                    pq.offer(new int[] {nr, nc, bcnt + 1});
                } else{
                    visited[nr][nc] = true;
                    pq.offer(new int[] {nr, nc, bcnt});
                }

            }
        }

        return -1;
    }
}