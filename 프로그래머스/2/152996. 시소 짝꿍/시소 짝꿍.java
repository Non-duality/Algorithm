import java.util.*;

class Solution {
    
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        
        Map<Double, Integer> map = new HashMap<>();
        
        for(int i : weights){
            double c1 = i * 1.0; // 같을 때
            double c2 = (i * 2.0) / 3.0; // 2/3 일때
            double c3 = (i * 1.0) / 2.0; // 2/4 일때
            double c4 = (i * 3.0) / 4.0; // 3/4 일때
            
            if(map.containsKey(c1)) answer += map.get(c1);
            if(map.containsKey(c2)) answer += map.get(c2);
            if(map.containsKey(c3)) answer += map.get(c3);
            if(map.containsKey(c4)) answer += map.get(c4);
            
            map.put((i * 1.0), map.getOrDefault((i * 1.0), 0) + 1);
        }
        
        return answer;
    }
}