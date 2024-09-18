import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        long sum1 = 0, sum2 = 0;
        
        for(int i : queue1){
            sum1 += i;
            q1.offer(i);
        }
        
        for(int i : queue2){
            sum2 += i;
            q2.offer(i);
        }
        
        int cnt = 0;
        while(cnt <= queue1.length * 4){
            if(sum1 > sum2){
                int temp = q1.poll();
                sum1 -= temp;
                sum2 += temp;
                q2.offer(temp);
                cnt ++;
            }
            
            else if(sum1 < sum2){
                int temp = q2.poll();
                sum2 -= temp;
                sum1 += temp;
                q1.offer(temp);
                cnt ++;
            }
            else if(sum1 == sum2){
                answer = cnt;
                break;
            }
        }
        
        return answer;
    }
}