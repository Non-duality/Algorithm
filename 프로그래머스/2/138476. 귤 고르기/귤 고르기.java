import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] arr = new int[10000001];
        
        for(int i = 0; i < tangerine.length; i++){
            arr[tangerine[i]] += 1;
        }
        Arrays.sort(arr);
        
        for(int i = 10000000; i >= 0; i--){
            k -= arr[i];
            if(k <= 0){
                answer += 1;
                break;
            }
            answer += 1;
        }
        
        return answer;
    }
}