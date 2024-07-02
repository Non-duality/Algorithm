import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int total, current, time;
    private static int[][] map;
    private static Queue<int[]> dq;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = { 0, 0,-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        total = M * N;
        current = 0;
        map = new int[N][M];
        dq = new ArrayDeque<>();

        int temp = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;

                if(temp == 1) {
                    current ++;
                    dq.offer(new int[] {i,j});
                }

                else if(temp == -1){
                    total --;
                }
            }
        }

        time = 0;
        BFS();

        if(total == current){
            System.out.println(time);
        }

        else{
            System.out.println(-1);
        }

    }

    private static void BFS() {

        Queue<int[]> cycleQ = new ArrayDeque<>();

        while(true){
            while(!dq.isEmpty()){
                cycleQ.offer(dq.poll());
            }

            while(!cycleQ.isEmpty()){
                int[] cntTomato = cycleQ.poll();

                for(int d = 0; d < 4; d++){
                    int nr = dr[d] + cntTomato[0];
                    int nc = dc[d] + cntTomato[1];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                        continue;
                    }

                    if(map[nr][nc] == -1 || map[nr][nc] == 1){
                        continue;
                    }

                    current ++;
                    map[nr][nc] = 1;
                    dq.offer(new int[] {nr, nc});
                }

            }

            if(dq.isEmpty()){
                break;
            }
            else{
                time++;
            }
        }

    }
}