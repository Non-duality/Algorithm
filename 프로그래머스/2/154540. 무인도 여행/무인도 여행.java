import java.util.*;

class Solution {
    
    static int N,M;
    static String[] map;
    
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = { 0, 0,-1, 1};
    
    public List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        N = maps.length;
        M = maps[0].length();
        map = maps;
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(maps[i].charAt(j) == 'X') continue;
                if(visited[i][j]) continue;
                int cnt = BFS(i,j);
                answer.add(cnt);
            }
        }
        Collections.sort(answer);
        if(answer.size() == 0){
            answer.add(-1);
        }
        return answer;
    }
    
    public int BFS(int startR, int startC){
        Queue<int[]> q = new ArrayDeque<>();
        
        visited[startR][startC] = true;
        q.offer(new int[]{startR, startC});
        
        int cnt = map[startR].charAt(startC) - '0';
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(map[nr].charAt(nc) == 'X') continue;
                
                visited[nr][nc] = true;
                cnt += map[nr].charAt(nc) - '0';
                q.offer(new int[]{nr, nc});
            }
        }
        return cnt;
    }
}