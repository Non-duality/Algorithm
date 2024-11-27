import java.util.*;

class Solution {
    static private int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = { 0, 0,-1, 1};
    
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        
        N = park.length;
        M = park[0].length;        
        
        Integer[] WraMats = Arrays.stream(mats).boxed().toArray(Integer[]::new);        
        Arrays.sort(WraMats, Collections.reverseOrder());
        
        boolean check = false;
        L:for(int x : WraMats){
            for(int r = 0; r < N; r++){
                for(int c = 0; c < M; c++){
                    if(park[r][c].equals("-1")){
                        check = BFS(r, c, x, park);
                        if(check){
                            answer = x;
                            break L;
                        }
                    }
                }
            }        
        }
        
        if(check){
            return answer;
        }else{
            return -1;
        }
    }
    
    static private boolean BFS(int r, int c, int x, String[][] park){        
        
        int lr = r + x - 1;
        int lc = c + x - 1;
        if(lr >= N || lc >= M){
            return false;
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[] {r, c});
        visited[r][c] = true;
        
        int count = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int d = 0; d < 4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if(nr >= r && nc >= c && nr <= lr && nc <= lc){
                    if(!park[nr][nc].equals("-1")){
                        return false;
                    }
                
                    if(visited[nr][nc]){
                        continue;
                    }
                
                    count++;
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        
        if(count == x*x){
            return true;
        }else{
            return false;
        }
        
    }
}