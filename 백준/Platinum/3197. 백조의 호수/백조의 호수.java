import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int R, C;
    private static char[][] map;
    private static Queue<int[]> waterQueue;
    private static Queue<int[]> nextWaterQueue;
    private static Queue<int[]> swanQueue;
    private static Queue<int[]> nextSwanQueue;
    private static List<int[]> swanList;

    private static boolean[][] waterVisited;
    private static boolean[][] swanVisited;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = { 0, 0,-1, 1};

    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        swanQueue = new ArrayDeque<>();
        nextSwanQueue = new ArrayDeque<>();
        waterQueue = new ArrayDeque<>();
        nextWaterQueue = new ArrayDeque<>();
        swanList = new ArrayList<>();

        swanVisited = new boolean[R][C];
        waterVisited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            String temp = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = temp.charAt(j);

                if(map[i][j] == 'L'){
                    swanList.add(new int[] {i, j});
                }

                if(map[i][j] == '.' || map[i][j] == 'L'){
                    waterQueue.offer(new int[] {i, j});
                    waterVisited[i][j] = true;
                }
            }
        }

        result = 0;
        int[] swan1 = swanList.get(0);
        int[] swan2 = swanList.get(1);
        swanQueue.offer(swan1);
        swanVisited[swan1[0]][swan1[1]] = true;

        // 큐를 이용하여 현재 상황을 저장할 수 있음.
        while(true){
            // 백조들이 만날 수 있는지 확인
            if(canSwansMeet(swan2)){
                System.out.println(result);
                break;
            }
            meltIce();
            result ++;
        }

    }

    // 백조들이 만날 수 있는지 확인하는 메서드
    private static boolean canSwansMeet(int[] targetSwan){

        while(!swanQueue.isEmpty()){
            int[] cur = swanQueue.poll();

            for(int d = 0; d < 4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C || swanVisited[nr][nc]){
                    continue;
                }

                if(nr == targetSwan[0] && nc == targetSwan[1]){
                    return true;
                }

                swanVisited[nr][nc] = true;

                if(map[nr][nc] == 'X'){
                    nextSwanQueue.offer(new int[] {nr, nc});
                }
                else {
                    swanQueue.offer(new int[] {nr, nc});
                }

            }
        }

        Queue<int[]> temp = swanQueue;
        swanQueue = nextSwanQueue;
        nextSwanQueue = temp;

        return false;
    }

    private static void meltIce(){
        while(!waterQueue.isEmpty()) {
            int[] cur = waterQueue.poll();

            for(int d = 0; d < 4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C || waterVisited[nr][nc]){
                    continue;
                }

                if(map[nr][nc] == 'X'){
                    map[nr][nc] = '.';
                    waterVisited[nr][nc] = true;
                    nextWaterQueue.offer(new int[] {nr, nc});
                }

            }
        }

        Queue<int[]> temp = waterQueue;
        waterQueue = nextWaterQueue;
        nextWaterQueue = temp;
    }
}