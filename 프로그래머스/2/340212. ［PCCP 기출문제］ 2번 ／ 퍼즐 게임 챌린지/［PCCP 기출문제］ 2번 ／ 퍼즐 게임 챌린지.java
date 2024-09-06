import java.util.*;

class Solution {
    public long solution(int[] diffs, int[] times, long limit) {
        long answer = 0;
        
        int length = diffs.length;
        
        long maxD = 1;
        for(int i = 1; i < length; i++) {
            maxD = Math.max(maxD, diffs[i]);
        }
        
        long left = 1;
        long right = maxD;
        long level = (left + right) / 2;
        
        while(left <= right) {
            long time = times[0];
            
            for(int i = 1; i < length; i++) {
                if(diffs[i] > level) {
                    int t = times[i] + times[i - 1];
                    
                    long totalT = t * (diffs[i] - level) + times[i];
                    
                    time += totalT;
                } else {
                    time += times[i];
                }
            }
            
            if(time > limit) {
                left = level + 1;
                level = (left + right) / 2;
            } else {
                right = level - 1;
                level = (left + right) / 2;
            }
        }
        
        answer = left;
        
        return answer;
    }
}