import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        
        for(String call : callings){
            int curRank = map.get(call);
            
            String front = players[curRank - 1];
            players[curRank - 1] = call;
            players[curRank] = front;
            
            map.put(call, curRank - 1);
            map.put(front, curRank);
        }
        
        return players;
    }

}