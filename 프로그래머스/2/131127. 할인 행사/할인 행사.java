import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wantMap = new HashMap<>();
        // 총 일수
        int day = 0;
        for(int i = 0; i < number.length; i++){
            day += number[i];
            wantMap.put(want[i], number[i]);
        }
        
        // 첫째날부터 연속된 날 까지 할인 품목 map에 삽입
        Map<String, Integer> disMap = new HashMap<>();
        for(int i = 0; i < day; i++){
            if(!disMap.containsKey(discount[i])){
                disMap.put(discount[i], 1);
            }else{
                disMap.put(discount[i], disMap.get(discount[i]) + 1);
            }
        }
        
        if(check(wantMap, disMap)) answer++;
        
        int left = 1;
        int right = day;
        while(right < discount.length){
            // 한 칸 이동했으므로 그 전 품목 삭제
            String prevItem = discount[left - 1];
            disMap.put(prevItem, disMap.get(prevItem) - 1);
            
            // 한 칸 이동했으므로 다음 품목 추가
            String nextItem = discount[right];
            if(!disMap.containsKey(nextItem)){
                disMap.put(nextItem, 1);
            }else{
                disMap.put(nextItem, disMap.get(nextItem) + 1);
            }
            
            if(check(wantMap, disMap)) answer++;
            
            left ++;
            right ++;
        }
        
        return answer;
    }
    
    public boolean check(Map<String, Integer> want, Map<String, Integer> discount){
        int cnt = 0;
        int target = want.size();
        
        for(String key : discount.keySet()){
            if(want.containsKey(key) && (discount.get(key) == want.get(key))){
                cnt++;
            }
        }
        
        return target == cnt ? true : false;
    }
}