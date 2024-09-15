import java.util.*;
    
class Solution {
    public int solution(int[] elements) {   
        int len = elements.length;
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        while(cnt < len){
            boolean[] check = new boolean[len];
            
            for(int left = 0; left < len; left++){
                int sum = elements[left];
                for(int right = left + 1; right <= left + cnt; right++){
                    int idx = right % len;
                    sum += elements[idx];
                }
                set.add(sum);
            }
            cnt++;
        }
        
        return set.size();
    }
}