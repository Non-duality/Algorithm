import java.util.*;

class Solution {
    private static List[] list;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        int len = n - 1;
        list = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < n-1; i++){
            int from = wires[i][0];
            int to = wires[i][1];
            
            list[from].add(to);
            list[to].add(from);
        }
        
        boolean[] visited;
        for(int[] wire : wires){
            int tower1 = wire[0];
            int tower2 = wire[1];
            
            visited = new boolean[n + 1];
            visited[tower1] = true;
            visited[tower2] = true;
            
            int tower1Result = BFS(visited, tower1);
            int tower2Result = BFS(visited, tower2);
            int result = Math.abs(tower1Result - tower2Result);
            answer = Math.min(answer, result);
        }
        
        return answer;
    }
    
    private static int BFS(boolean[] visited, int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        
        int count = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i = 0; i < list[cur].size(); i++){
                int next = (int)list[cur].get(i);
                
                if(visited[next]) continue;
                
                count++;
                visited[next] = true;
                q.offer(next);
            }
        }
        
        return count;
    }
    
}