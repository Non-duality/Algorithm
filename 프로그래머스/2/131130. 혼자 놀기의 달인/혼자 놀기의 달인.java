import java.util.*;

class Solution {
    private static boolean[] check;
    private static List<Integer> list;
    public int solution(int[] cards) {
        int answer = 0;
        check = new boolean[cards.length + 1];
        list = new ArrayList<>();
        
        for(int i = 0;i < cards.length; i++){
            if(check[cards[i]]) continue;
            check[cards[i]] = true;
            DFS(1, cards[i], cards);
        }
        
        Collections.sort(list, (o1, o2) -> Integer.compare(o2, o1));
        
        if(list.size() == 1){
            return 0;
        } else{
            return list.get(0) * list.get(1);
        }
    }
    
    private void DFS(int cnt, int cur, int[] cards){
        if(check[cards[cur - 1]]){
            check[cur] = true;
            list.add(cnt);
            return;
        }
        check[cur] = true;
        DFS(cnt + 1, cards[cur - 1], cards);
    }
}