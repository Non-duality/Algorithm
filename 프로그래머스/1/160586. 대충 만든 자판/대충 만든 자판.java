import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        int[] alCnt = new int[26];
        
        int INF = Integer.MAX_VALUE;
        Arrays.fill(alCnt, INF);
        
        for(int i = 0; i < keymap.length; i++){
            for(int j = 0; j < keymap[i].length(); j++){
                int idx = keymap[i].charAt(j) - 'A';
                int cnt = j + 1;
                
                alCnt[idx] = Math.min(alCnt[idx], cnt);
            }
        }
        
        int[] answer = new int[targets.length];
        for(int i = 0; i < targets.length; i++){
            int total = 0;
            for(int j = 0; j < targets[i].length(); j++){
                int cnt = alCnt[targets[i].charAt(j) - 'A'];
                if(cnt == INF){
                    total = -1;
                    break;
                } else{
                    total += cnt;
                }
            }
            answer[i] = total;
        }
        
        return answer;
    }
}