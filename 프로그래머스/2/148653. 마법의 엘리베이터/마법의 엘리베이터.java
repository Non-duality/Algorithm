import java.util.*;

class Solution {

    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int remainder = storey % 10;
            if (remainder > 5 || (remainder == 5 && (storey / 10) % 10 >= 5)) {
                // 5 이상이거나, 5일 때 앞자리의 숫자가 5 이상인 경우 올림 처리
                answer += (10 - remainder);
                storey = storey / 10 + 1; // 다음 자리로 올림
            } else {
                // 5 미만인 경우 그냥 더해주기
                answer += remainder;
                storey /= 10; // 다음 자리로 넘어가기
            }
        }
        
        return answer;
    }
    
}