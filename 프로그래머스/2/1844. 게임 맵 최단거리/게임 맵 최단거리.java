import java.util.*;
class Solution {
    
    private static int N, M;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = { 0, 0,-1, 1};
    public int solution(int[][] maps) {
        int answer = 0;
        
        N = maps.length;
        M = maps[0].length;
        answer = BFS(maps);
        return answer;
    }
    
    private static int BFS(int[][] maps){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,1});
        
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == N - 1 && cur[1] == M - 1){
                return cur[2];
            }
            
            for(int d = 0; d < 4; d++){
                int nr = dr[d] + cur[0];
                int nc = dc[d] + cur[1];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(maps[nr][nc] == 0) continue;
                
                q.offer(new int[]{nr, nc, cur[2] + 1});
                visited[nr][nc] = true;
            }
        }
        
        return -1;
    }
}