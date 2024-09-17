import java.util.*;

class Solution {
    static int result = 0;
    static int[] numbers;
    public int solution(int[] number) {
        numbers = number;
        comb(3, 0, 0, new boolean[number.length]);
        return result;
    }
    
    public void comb(int r, int cnt, int start, boolean[] visited){
        if(cnt == r){
            int sum = 0;
            for(int i = 0; i < visited.length; i++){
                if(visited[i]) sum += numbers[i];
            }
            if(sum == 0) result ++;
            return;
        }
        
        for(int i = start; i < numbers.length; i++){
            visited[i] = true;
            comb(r, cnt + 1, i + 1, visited);
            visited[i] = false;
        }
    } 
}