import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            String na = name[i]; 
            int ye = yearning[i];
            
            map.put(na, ye);
        }
        
        for(int i = 0; i < photo.length; i++){
            int cnt = 0;
            for(int j = 0; j < photo[i].length; j++){
                if(map.containsKey(photo[i][j])) cnt += map.get(photo[i][j]);
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}