import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        
        int[] alphaPos = new int[26];
        Arrays.fill(alphaPos, -1);
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(alphaPos[ch - 'a'] > -1){
                answer.add(i - alphaPos[ch - 'a']);
                alphaPos[ch - 'a'] = i;
            }else{
                answer.add(-1);
                alphaPos[ch - 'a'] = i;
            }
        }
        
        return answer;
    }
}