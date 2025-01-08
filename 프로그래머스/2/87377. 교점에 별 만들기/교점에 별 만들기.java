import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        int lineNumber = line.length;
        
        List<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < lineNumber; i++){
            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];
            
            for(int j = i+1; j < lineNumber; j++){
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];
                
                long deno = (A * D) - (B * C);
                if(deno == 0) continue;
                
                long numX = (B * F) - (E * D);
                long numY = (E * C) - (A * F);
                
                
                if(numX % deno == 0 && numY % deno == 0){
                    long X = numX / deno;
                    long Y = numY / deno;
                    
                    list.add(new int[] {(int)X, (int)Y});
                }
                
            }
            
        }
        
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for(int[] p : list){
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            minY = Math.min(minY, p[1]);
            maxY = Math.max(maxY, p[1]);
        }
        
        int width = maxX - minX + 1;
        int height = maxY - minY + 1;
        
        char[][] grid = new char[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(grid[i], '.');
        }
        
        for(int[] p : list){
            int x = p[0];
            int y = p[1];
            
            int row = maxY - y;  
            int col = x - minX;   
            grid[row][col] = '*';
        }
        
        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(grid[i]);
        }
        
        
        
        return answer;
    }
}