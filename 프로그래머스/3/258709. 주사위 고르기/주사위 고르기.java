import java.util.*;

class Solution {
    
    static int N;
    static int[][] dices;
    static List<int[]> combo;
    
    public int[] solution(int[][] dice) {
        
        // 전역 변수 초기화
        N = dice.length;
        dices = dice;
        combo = new ArrayList<>();
        
        // n/2 주사위를 선택하는 조합 구하기
        combination(0, 0, new int[N/2]);
        
        int[] answer = {};
        int maxWinCnt = 0;
        
        for(int[] aCombo : combo){
            List<Integer> aScores = new ArrayList<>();
            // A 주사위로 얻을 수 있는 점수 구하기
            getScores(0, 0, aCombo, aScores);
            Collections.sort(aScores);
            
            // B 주사위의 조합 구하기
            int[] bCombo = getBCombo(aCombo);
            // B 주사위로 얻을 수 있는 점수 하기
            List<Integer> bScores = new ArrayList<>();
            getScores(0, 0, bCombo, bScores);
            Collections.sort(bScores);
            
            int winCnt = getWinCntOfA(aScores, bScores);
            if(maxWinCnt < winCnt){
                maxWinCnt = winCnt;
                answer = aCombo;
            }
        }
        
        for (int i = 0; i < answer.length; i++) {
            answer[i]++;
        }
        
        return answer;
    }
    
    public void combination(int start, int depth, int[] numbers) {
        if(depth == N / 2){
            combo.add(numbers.clone());
            return;
        }
        
        for(int i = start; i < N; i++){
            numbers[depth] = i;
            combination(i + 1, depth + 1, numbers);
        }
    }
    
    public void getScores(int depth, int sum, int[] comb, List<Integer> scores){
        if(depth == N / 2){
            scores.add(sum);
            return;
        }
        
        for(int i = 0; i < 6; i++){
            getScores(depth + 1, sum + dices[comb[depth]][i], comb, scores);
        }
    }
    
    public int[] getBCombo(int[] aCombo){
        boolean[] isA = new boolean[N];
        for(int num : aCombo){
            isA[num] = true;
        }
        
        int cnt = 0;
        int[] bCombo = new int[N / 2];
        for(int i = 0; i < N; i++){
            if(!isA[i]){
                bCombo[cnt] = i;
                cnt ++;
            }
        }
        
        return bCombo;
    }
    
    private int getWinCntOfA(List<Integer> aScores, List<Integer> bScores){
        int winCnt = 0;
        
        for(int sum : aScores){
            int start = 0;
            int end = bScores.size() - 1;
            
            while(start <= end){
                int mid = (start + end) / 2;
                
                if(sum > bScores.get(mid)){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            winCnt += start;            
        }
        
        return winCnt;
    }
}