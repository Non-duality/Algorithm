class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        for(int i = 0; i < section.length; i++){
            int curPos = section[i];
            answer++;
            while(true){
                if((i + 1 < section.length) && curPos + m - 1 >= section[i + 1]) i++;
                else break;
            }
        }
        return answer;
    }
}