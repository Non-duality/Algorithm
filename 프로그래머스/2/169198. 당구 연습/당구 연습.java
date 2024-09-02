class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int cnt = 0;
        for(int[] ball : balls){
            double x = startX - ball[0];
            double y = startY - ball[1];
            
            double left = Math.pow((startX + ball[0]), 2) + Math.pow(y, 2); //왼쪽 벽으로 칠 때
            double right = Math.pow((m - startX) + (m - ball[0]), 2) + Math.pow(y, 2); // 오른쪽 벽으로 칠 때
            double up = Math.pow(x, 2) + Math.pow((n - startY) + (n - ball[1]), 2); //위쪽 벽으로 칠 때
            double down = Math.pow(x, 2) + Math.pow(startY + ball[1], 2); // 아래쪽 벽으로 칠때
            
            answer[cnt] = (int)Math.min(Math.min(left,right), Math.min(up,down));
            // 같은 x축 위에 있을 경우
            if(x == 0){
                if(y > 0) answer[cnt] = (int)Math.min(Math.min(left, right), up);
                else answer[cnt] = (int)Math.min(Math.min(left, right), down);
            } 
            
            else if(y == 0){
                if(x > 0) answer[cnt] = (int)Math.min(Math.min(up, down), right);
                else answer[cnt] = (int)Math.min(Math.min(up, down), left);
            }
            cnt++;
        }
        
        return answer;
    }
}