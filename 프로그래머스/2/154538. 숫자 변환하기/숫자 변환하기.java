import java.util.*;

class Solution {
    
    static int X, Y, N;
    static boolean[] visited;
    
    static int[] dn = {0, 2, 3};
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        X = x;
        Y = y;
        N = n;
        
        visited = new boolean[1000001];
        answer = BFS();
        
        return answer;
    }
    
    public int BFS(){
        Queue<int[]> q = new ArrayDeque<>();
        visited[X] = true;
        q.offer(new int[]{X, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == Y){
                return cur[1];
            }
            
            int next = 0;
            for(int i = 0; i < 3; i++){
                if(i == 1) next = 2 * cur[0];
                else if(i == 2) next = 3 * cur[0];
                else next = N + cur[0];
                
                if(next > 1000000) continue;
                if(visited[next]) continue;
                
                visited[next] = true;
                q.offer(new int[]{next, cur[1] + 1});
            }
        }
        
        return -1;
    }
}