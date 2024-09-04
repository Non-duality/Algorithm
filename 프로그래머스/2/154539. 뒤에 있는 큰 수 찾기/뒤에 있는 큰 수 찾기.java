import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<int[]> stack = new Stack<>();
        int len = numbers.length;
        int[] answer = new int[len];
        
        for(int i = 0; i < len; i++){
            int number = numbers[i];
            
            while(!stack.isEmpty()){
                if(stack.peek()[0] < number){
                    int[] current = stack.pop();
                    answer[current[1]] = number;
                }
                else break;
            }
            stack.push(new int[]{number, i});
        }
        
        for(int i = 0; i < len; i++){
            if(answer[i] == 0){
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}