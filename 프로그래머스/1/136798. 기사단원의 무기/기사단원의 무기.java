class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] mCnt = new int[number + 1];
        
        // 약수 개수 구하기
        for(int i = 1; i <= number; i++){
            int cnt = 0;
            for(int j = 1; j * j <= i; j++){
                if(j * j == i) cnt ++;
                else if(i % j == 0) cnt += 2;
            }
            mCnt[i] = cnt;
        }
        
        for(int i = 1; i <= number; i++){
            if(mCnt[i] > limit){
                answer += power;
            }else{
                answer += mCnt[i];
            }
        }
        return answer;
        
    }
}