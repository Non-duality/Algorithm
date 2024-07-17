import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, P;
    private static char[][] map;
    private static int[] S;

    private static Queue<int[]>[] playerQueue;
    private static int[] castleCnt;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = { 0, 0,-1, 1};

    private static int target;
    private static int wallCnt;
    private static int current;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        // 움직일 수 있는 횟수 저장
        S = new int[P+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < P; i++){
            S[i+1] = Integer.parseInt(st.nextToken());
        }

        playerQueue = new ArrayDeque[P+1];
        for(int i = 1; i <= P; i++){
            playerQueue[i] = new ArrayDeque<>();
        }

        map = new char[N][M];
        castleCnt = new int[P+1];

        wallCnt = 0;

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < M; j++){
                char info = temp.charAt(j);
                map[i][j] = info;

                if(info == '#'){
                    wallCnt ++;
                } else if(info != '.'){
                    int player = info - '0';
                    playerQueue[player].offer(new int[] {i, j, S[player]}); // r, c, 이동 가능한 거리
                    castleCnt[player] ++;
                }
            }
        }

        target = N * M;
        current = 0;

        while(target != current){

            for(int i = 1; i <= P; i++){
                expandCastle(i);
            }

            int castleSum = 0;
            int emptyCheck = 0;
            for(int i = 1; i <= P; i++){
                castleSum += castleCnt[i];
                if(playerQueue[i].isEmpty()){
                    emptyCheck ++;
                }
            }

            if(emptyCheck == P){
                break;
            }
            current = castleSum + wallCnt;
        }

        for(int i = 1; i <= P; i++){
            System.out.print(castleCnt[i] + " ");
        }
    }

    private static void expandCastle(int player){
        for(int i = 0; i < S[player]; i++){
            int size = playerQueue[player].size();
            for(int j = 0; j < size; j++){
                int[] cur = playerQueue[player].poll();
                int r = cur[0];
                int c = cur[1];

                for(int d = 0; d < 4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                        continue;
                    }

                    if(map[nr][nc] == '.'){
                        map[nr][nc] = (char)(player + '0');
                        playerQueue[player].offer(new int[] {nr, nc});
                        castleCnt[player] ++;
                    }
                }
            }

            if(playerQueue[player].isEmpty()){
                break;
            }
        }
    }
}