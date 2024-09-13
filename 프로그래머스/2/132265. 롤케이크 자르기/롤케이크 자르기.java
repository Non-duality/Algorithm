class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] leftCnt = new int[10001];
        int[] rightCnt = new int[10001];
        
        int len = topping.length;
        int[] leftTotal = new int[len];
        int[] rightTotal = new int[len];
        
        int left = 0;
        int right = len - 1;
        
        int leftOther = 0;
        int rightOther = 0;
        while(left < len && right >= 0){
            // 왼쪽
            if(left < len){
                int leftNum = topping[left];
                if(leftCnt[leftNum] == 0){
                    leftCnt[leftNum] += 1;
                    leftOther++;
                }
                leftTotal[left] = leftOther;
            }
            
            // 오른쪽
            if(right >= 0){
                int rightNum = topping[right];
                if(rightCnt[rightNum] == 0){
                    rightCnt[rightNum] += 1;
                    rightOther++;
                }
                rightTotal[right] = rightOther; 
            }
            
            left++;
            right--;
        }
        
        for(int i = 0; i < len; i++){
            if(i == len -1) continue;
            if(leftTotal[i] == rightTotal[i + 1]) answer ++;
        }
        
        
        return answer;
    }
}