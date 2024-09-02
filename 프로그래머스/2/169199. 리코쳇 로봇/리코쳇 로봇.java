import java.util.*;

class Solution {
    
    static int N, M;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = { 0, 0,-1, 1};
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        
        int[] start = new int[2];
        int[] goal = new int[2];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                char temp = board[i].charAt(j);
                if(temp == '.') continue;
                else if(temp == 'R'){
                    start[0] = i;
                    start[1] = j;
                } else if(temp == 'G'){
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }
        
        visited = new boolean[N][M];
        int answer = BFS(start, goal, board);
        return answer;
    }
    
    public int BFS(int[] start, int[] goal,String[] board){
        
        Queue<int[]> q = new ArrayDeque<>();
        
        visited[start[0]][start[1]] = true;
        q.offer(new int[]{start[0], start[1], 0});
        
        int result = -1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == goal[0] && cur[1] == goal[1]){
                result = cur[2];
                break;
            }
            
            for(int d = 0; d < 4; d++){
                int nr = cur[0];
                int nc = cur[1];
                
                while(true){
                    nr += dr[d];
                    nc += dc[d];
                    
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                        nr -= dr[d];
                        nc -= dc[d];
                        break;
                    }
                    
                    if(board[nr].charAt(nc) == 'D'){
                        nr -= dr[d];
                        nc -= dc[d];
                        break;
                    }
                    
                }
                
                if(visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc, cur[2] + 1});
            } 
            
        }
        return result;
    }
}