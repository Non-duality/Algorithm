import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        Queue<String> q1 = new ArrayDeque<>();
        for(int i = 0; i < cards1.length; i++){
            q1.offer(cards1[i]);
        }
        
        Queue<String> q2 = new ArrayDeque<>();
        for(int i = 0; i < cards2.length; i++){
            q2.offer(cards2[i]);
        }
        
        for(int i = 0; i < goal.length; i++){
            String temp = goal[i];
            
            if(!q1.isEmpty() && q1.peek().equals(temp)){
                q1.poll();
                continue;
            }
            
            if(!q2.isEmpty() && q2.peek().equals(temp)){
                q2.poll();
                continue;
            }
            
            answer = "No";
            break;
        }
        
        return answer;
    }
}