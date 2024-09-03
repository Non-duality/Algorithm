import java.util.*;

class Solution {
    
    static int N, M;
    static String[] map;
    
    static int[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = { 0, 0,-1, 1};
    
    public int solution(String[] maps) {
        map = maps;
        N = maps.length;
        M = maps[0].length();
        
        int startR = 0, startC = 0;
        int endR = 0, endC = 0;
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(maps[i].charAt(j) == 'S'){
                    startR = i;
                    startC = j;
                }
                
                else if(maps[i].charAt(j) == 'E'){
                    endR = i;
                    endC = j;
                }
            }
        }
        
        visited = new int[N][M][2];
        BFS(new int[]{startR, startC});
        int answer = 0;
        if(visited[endR][endC][1] == 0){
            answer = -1;
        }else{
            answer = visited[endR][endC][1] - 1;
        }
        return answer;
    }
    
    public void BFS(int[] start){
        Queue<int[]> q = new ArrayDeque<>();
        
        visited[start[0]][start[1]][0] = 1;
        q.offer(new int[]{start[0], start[1], 0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int isOn = cur[2];
            
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc][isOn] != 0) continue;
                if(map[nr].charAt(nc) == 'X') continue;
                if(map[nr].charAt(nc) == 'L'){
                    visited[nr][nc][0] = visited[r][c][0] + 1;
                    visited[nr][nc][1] = visited[r][c][0] + 1;
                    q.offer(new int[]{nr, nc, 1});
                    continue;
                }
                visited[nr][nc][isOn] = visited[r][c][isOn] + 1;
                q.offer(new int[]{nr, nc, isOn});
            }
        }
    }
}