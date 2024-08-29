class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        double start = h1 * 3600 + m1 * 60 + s1;
        double end = h2 * 3600 + m2 * 60 + s2;

        //12시나 0시 정각이면 모두 겹치는 순간
        if(start == 0 || start == 12 * 3600) answer++;

        while(start < end){

            double angleH = start / 120 % 360;
            double angleM = start / 10 % 360;
            double angleS = start * 6 % 360;

            // 1초 뒤 각도
            double nextAH = (start + 1) / 120 % 360;
            if(nextAH == 0) nextAH = 360;

            double nextAM = (start + 1) / 10 % 360;
            if(nextAM == 0) nextAM = 360;

            double nextAS = (start + 1) * 6 % 360;
            if(nextAS == 0) nextAS = 360;

            if(angleS < angleH && nextAH <= nextAS) answer++;
            if(angleS < angleM && nextAM <= nextAS) answer++;
            if(nextAS == nextAH && nextAS == nextAM) answer--;

            start++;
        }

        return answer;
    }
}