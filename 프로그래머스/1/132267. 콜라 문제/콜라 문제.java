class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            int cnt = (n / a) * b;
            answer += cnt;
            n = n % a;
            n += cnt;
        }
        return answer;
    }
}