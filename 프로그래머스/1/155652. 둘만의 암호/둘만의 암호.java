import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
    
        List<String> order = new ArrayList<>();
        
        for(int i = 0; i < 26; i++){
            char temp = (char)('a' + i);
            if(skip.contains(temp + "")) continue;
            order.add(temp + "");
        }
        
        int size = order.size();
        for(int i = 0; i < s.length(); i++){
            String temp = s.charAt(i) + "";
            if(skip.contains(temp)){
                answer = answer + temp;
                continue;
            }
            int curIdx = order.indexOf(temp);
            int nextIdx = (curIdx + index) % size;
            
            answer = answer + order.get(nextIdx);
        }
        
        return answer;
    }
}