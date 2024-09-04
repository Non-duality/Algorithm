import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int round = 0;
        
        Set<Integer> currentCard = new HashSet<>();
        Set<Integer> availableCard = new HashSet<>();
        
        int n = cards.length;
        int idx = n / 3;
        for(int i = 0; i < idx; i++){
            currentCard.add(cards[i]);
        }
        
        int target = n + 1;
        while(true){
            round++; // 라운드 시작
            if(idx >= n){
                break;
            }
            // 카드 두장 뽑기
            availableCard.add(cards[idx]);
            availableCard.add(cards[idx + 1]);
            idx += 2;
            
            boolean canNextRound = false;
            // 내가 현재 가지고 있는 카드로 처리가 가능한지 확인하기
            for(int i : currentCard){
                if(currentCard.contains(target - i)){
                    currentCard.remove(i);
                    currentCard.remove(target - i);
                    canNextRound = true;
                    break;
                }    
            }
            
            // 현재 가지고 있는 카드로도 해결이 안된다면 1코인을 써서 한장 가져가기
            if(!canNextRound){
                if(coin >= 1){
                    for(int i : currentCard){
                        if(availableCard.contains(target - i)){
                            currentCard.remove(i);
                            availableCard.remove(target - i);
                            coin --;
                            canNextRound = true;
                            break;
                        }
                    }
                }
            }
            
            // 현재 가지고 있는 카드로도 해결이 안된다면 2코인을 써서 두장 가져가기
            if(!canNextRound){
                if(coin >= 2){
                    for(int i : availableCard){
                        if(availableCard.contains(target - i)){
                            availableCard.remove(i);
                            availableCard.remove(target - i);
                            coin -= 2;
                            canNextRound = true;
                            break;
                        }
                    }
                }
            }
            
            if(!canNextRound){
                break;
            }
            
        }
        
        return round;
    }
}