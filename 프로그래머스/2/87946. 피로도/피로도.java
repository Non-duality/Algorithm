class Solution {
    private static int[][] dungeon;
    private static int answer = 0; 
    private static int curK;
    public int solution(int k, int[][] dungeons) {
        dungeon = dungeons;
        curK = k;
        
        permu(new int[dungeon.length], new boolean[dungeon.length], 0, dungeon.length);
        
        return answer;
    }
    
    public static void permu(int[] output, boolean[] visited, int cnt, int target){
        
        if(cnt == target){
            int count = 0;
            int k = curK;
            for(int i = 0; i < output.length; i++){
                int need = dungeon[output[i]][0];
                int consum = dungeon[output[i]][1];
                
                if(k >= need){
                    count++;
                    k -= consum;
                }else{
                    break;
                }
            }
            answer = Math.max(count, answer);
            return;
        }
        
        for(int i = 0; i < dungeon.length; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            output[cnt] = i;
            permu(output, visited, cnt + 1, target);
            visited[i] = false;
        }
    }
}