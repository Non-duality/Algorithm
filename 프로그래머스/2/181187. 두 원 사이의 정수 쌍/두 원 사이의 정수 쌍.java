class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        long r2Cnt = 0;
        long r1Cnt = 0;

        for(int i = 1; i < r2; i++){
            double maxY = Math.sqrt(((long)r2 * r2) - ((long)i * i));
            long cnt = (long) Math.floor(maxY);
            r2Cnt += cnt;
        }

        for(int i = 1; i < r1; i++){
            double maxY = Math.sqrt(((long)r1 * r1) - ((long)i * i));

            if(maxY - (long)maxY == 0.0) {
                System.out.println(maxY);
                r1Cnt += (long)maxY - 1;
            }
            else{
                long cnt = (long) Math.floor(maxY);
                r1Cnt += cnt;
            }
        }

        answer = (r2Cnt - r1Cnt) * 4 + (r2 - r1 + 1) * 4L;

        return answer;
    }
}