class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dPow = (long)Math.pow(d, 2);
        for(int x = 0; x <= d; x += k){
            long xPow = (long)Math.pow(x, 2);
            double maxY = Math.sqrt(dPow - xPow);
            answer += ((long)maxY / k) + 1;
        }
        
        return answer;
    }
}