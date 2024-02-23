import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M; // 통로의 크기
    static int K; // 음식물 쓰레기의 개수
    static int result; // 가장 큰 음식물의 크기
    static int count;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        List<int[]> garbage = new ArrayList<>();
        int r, c;

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = 1; // 쓰레기 채우기
            garbage.add(new int[] {r,c});
        }

        result = 0;
        visited = new boolean[N][M];

        int length = garbage.size();
        for(int i = 0; i < length; i++){
            r = garbage.get(i)[0];
            c = garbage.get(i)[1];
            if(visited[r][c]){
                continue;
            }
            visited[r][c] = true;
            count = 1;
            DFS(garbage.get(i)[0], garbage.get(i)[1]);
        }

        System.out.println(result);

    }

    static public void DFS(int cr, int cc){

        if(count > result){
            result = count;
        }

        for(int d = 0; d < 4; d++){
            int nr = cr + dr[d];
            int nc = cc + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                continue;
            }

            if(visited[nr][nc]){
                continue;
            }

            if(map[nr][nc] == 1){
                visited[nr][nc] = true;
                count ++;
                DFS(nr, nc);
            }

        }

    }

}