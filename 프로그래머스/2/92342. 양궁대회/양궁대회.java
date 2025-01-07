class Solution {
    
    static int maxDiff = 0;
    static int[] best;
    static int N;
    static int[] apeach;
    
    public int[] solution(int n, int[] info) {
        N = n;
        apeach = info.clone();
        best = new int[11];
        
        DFS(0, 0, new int[11]);
        
        if(maxDiff == 0) return new int[] {-1};
        return best;
    }
    
    private static void DFS(int scoreIdx, int usedArrows, int[] lion){
        
        if(scoreIdx == 11){
            
            // 화살을 다 쏘지 않았다면 0점에 몰아주기
            if(usedArrows < N) lion[10] += (N - usedArrows);
            
            // 라이언이 이겼는지 확인하기
            int lionScore = 0;
            int apeachScore = 0;
            
            for(int i = 0; i < 11; i++){
                if(lion[i] > apeach[i]) lionScore += (10 - i);
                else if(apeach[i] > 0) apeachScore += (10 - i);
            }
            
            int diff = lionScore - apeachScore;
            
            // 라이언의 점수가 더 크다면
            if(diff > maxDiff){
                maxDiff = diff;
                best = lion.clone();
            }
            
            // diff = maxDiff 인 경우, 더 낮은 점수를 맞힌 경우인지 확인하기
            else if(diff == maxDiff && diff > 0){
                for(int i = 10; i >= 0; i--){
                    if(lion[i] > best[i]){
                        best = lion.clone();
                        break;
                    } else if(lion[i] < best[i]){
                        break;
                    }
                }
                
            }
            
            if(usedArrows < N) lion[10] -= (N - usedArrows);
            
            return;
        }
        
        // 라이온이 이길 수 있는 경우의 수를 구함
        int lionArrows = apeach[scoreIdx] + 1;
        
        // 화살이 충분히 남아있다면
        if(lionArrows <= (N - usedArrows)){
            // 해당 경우의수를 DFS돌림
            lion[scoreIdx] = lionArrows;
            DFS(scoreIdx + 1, usedArrows + lionArrows, lion);
            lion[scoreIdx] = 0;
        }
        
        // 해당 과녁에는 쏘지 않음
        lion[scoreIdx] = 0;
        DFS(scoreIdx + 1, usedArrows, lion);
    }
    
}