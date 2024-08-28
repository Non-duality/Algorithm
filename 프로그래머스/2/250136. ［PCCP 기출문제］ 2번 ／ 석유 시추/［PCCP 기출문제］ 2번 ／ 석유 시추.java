import java.util.*;

class Solution {
    
    static int N, M;
    static int[] oil;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = { 0, 0,-1, 1};
    
    public int solution(int[][] land) {
        int maxValue = 0;

        N = land.length;
        M = land[0].length;
        oil = new int[M];

        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(land[i][j] == 0 || visited[i][j]) continue;
                BFS(land, i, j);
            }
        }

        for(int i = 0; i < M; i++){
            maxValue = Math.max(maxValue, oil[i]);
        }

        return maxValue;
    }
    
    public static void BFS(int[][] land, int startR, int startC){
        Queue<int[]> q = new ArrayDeque<>();

        visited[startR][startC] = true;
        q.offer(new int[] {startR, startC});

        int cnt = 1;
        Set<Integer> set = new HashSet<>();

        while(!q.isEmpty()){
            int[] cur = q.poll();
            set.add(cur[1]);

            for(int d = 0; d < 4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(land[nr][nc] == 0) continue;
                if(visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
                cnt++;
            }
        }

        for(int idx : set){
            oil[idx] += cnt;
        }
    }
}