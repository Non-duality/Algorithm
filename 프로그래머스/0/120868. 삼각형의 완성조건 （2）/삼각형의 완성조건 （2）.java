class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        int max, other;
        if(sides[0] >= sides[1]){
            max = sides[0];
            other = sides[1];
        } else{
            max = sides[1];
            other = sides[0];
        }

        // 주어진 값에서 가장 큰 값이 가장 긴 변일 경우
        int cnt = max - ((max + 1) - other) + 1;
        answer += cnt;

        // 다른 변이 가장 긴 변이 되는 경우
        cnt = (max + other) - max - 1;
        answer += cnt;

        return answer;
    }
}