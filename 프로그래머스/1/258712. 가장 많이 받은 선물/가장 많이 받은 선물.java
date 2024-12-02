import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int len = friends.length;
        
        Map<String, HashMap<String, Integer>> giftInfo = new HashMap<>();
        Map<String, Integer> giftIndex = new HashMap<>();
        
        // 선물을 준 횟수, 선물을 받은 횟수, 선물 지수
        for(String gift : gifts){
            String[] temp = gift.split(" ");
            
            String sender = temp[0];
            String receiver = temp[1];
            
            if(!giftIndex.containsKey(sender)) giftIndex.put(sender, 1);
            else giftIndex.put(sender, giftIndex.get(sender) + 1);
            
            if(!giftIndex.containsKey(receiver)) giftIndex.put(receiver, -1);
            else giftIndex.put(receiver, giftIndex.get(receiver) - 1);
            
            if(!giftInfo.containsKey(sender)){
                giftInfo.put(sender, new HashMap<String, Integer>());
                giftInfo.get(sender).put(receiver, 1);
            }else{
                HashMap tempMap = giftInfo.get(sender);
                
                if(!tempMap.containsKey(receiver)){
                    tempMap.put(receiver, 1);
                }else{
                    tempMap.put(receiver, (int)tempMap.get(receiver) + 1);
                }
            }
        }
        
        int cnt = 0;
        int[] result = new int[len];
        for(String sender : giftInfo.keySet()){
            int gift = 0;
            
            for(String receiver : friends){
                // 선물을 준 친구인지 확인
                if(giftInfo.get(sender).containsKey(receiver)){
                    int senVal = giftInfo.get(sender).get(receiver);
                    int reVal = 0;
                    if (giftInfo.containsKey(receiver) && giftInfo.get(receiver).containsKey(sender)) {
                        reVal = giftInfo.get(receiver).get(sender);
                    }
                    
                    if(senVal == reVal){
                    int senIndex = giftIndex.get(sender);
                    int reIndex = giftIndex.get(receiver);
                        if(senIndex > reIndex) {
                            gift++;
                        }
                    }else if(senVal > reVal){
                        gift++;
                    }
                }
                
                // 선물을 주지 않았더라면 선물을 받았는지 체크
                else{
                    
                    // 선물을 받지 않았더라면
                    if(!giftInfo.containsKey(receiver)){
                        int senIndex = giftIndex.get(sender);
                        int reIndex = 0;
                        if(giftIndex.containsKey(receiver)) reIndex = giftIndex.get(receiver);
                        if(senIndex > reIndex)gift++;
                    }
                    if(giftInfo.containsKey(receiver) && !giftInfo.get(receiver).containsKey(sender)){
                        int senIndex = giftIndex.get(sender);
                        int reIndex = giftIndex.get(receiver);
                        if(senIndex > reIndex)gift++;
                    }
                }
            }
            
            
            result[cnt] = gift;
            cnt++;
        }
        Arrays.sort(result);
        return result[len - 1];
    }
}