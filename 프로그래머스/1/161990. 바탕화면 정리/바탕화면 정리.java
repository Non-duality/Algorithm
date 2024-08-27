import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int n = wallpaper.length;
        int m = wallpaper[0].length();

        int topPos = Integer.MAX_VALUE;
        int leftPos = Integer.MAX_VALUE;
        int rightPos = Integer.MIN_VALUE;
        int bottomPos = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(wallpaper[i].charAt(j) == '.') continue;

                topPos = Math.min(topPos, i);
                leftPos = Math.min(leftPos, j);
                rightPos = Math.max(rightPos, j);
                bottomPos = Math.max(bottomPos, i);
            }
        }

        int[] answer = {topPos, leftPos, bottomPos + 1, rightPos + 1};
        return answer;
    }
}