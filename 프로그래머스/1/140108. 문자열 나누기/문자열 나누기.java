import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int cntTarget = 1;
        int cntOther = 0;
        char target = s.charAt(0);
        
        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch != target) cntOther++;
            if(ch == target) cntTarget++;
            
            if(cntOther == cntTarget){
                answer++;
                cntTarget = 0;
                cntOther = 0;
                target = s.charAt((i + 1) % s.length());
            }
        }
        if(cntOther != cntTarget){
            answer++;
        }
        
        return answer;
    }
}