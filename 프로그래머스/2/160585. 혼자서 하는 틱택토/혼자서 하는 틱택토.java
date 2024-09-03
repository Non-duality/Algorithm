class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        int Ocnt = 0;
        int Xcnt = 0;
        
        int[] rowOCnt = new int[3]; 
        int[] colOCnt = new int[3];
        int[] diaOCnt = new int[2];
        
        int[] rowXCnt = new int[3]; 
        int[] colXCnt = new int[3];
        int[] diaXCnt = new int[2];
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i].charAt(j) == 'O'){
                    Ocnt ++;
                    rowOCnt[i]++;
                    colOCnt[j]++;
                    if((i == 1 && j == 1) || (i == 0 && j == 0) || (i == 2 && j == 2)){
                        diaOCnt[0]++;
                    }
                    
                    if((i == 1 && j == 1) || (i == 0 && j == 2) || (i == 2 && j == 0)){
                        diaOCnt[1]++;
                    }
                }
                else if(board[i].charAt(j) == 'X'){
                    Xcnt ++;
                    rowXCnt[i]++;
                    colXCnt[j]++;
                    if((i == 1 && j == 1) || (i == 0 && j == 0) || (i == 2 && j == 2)){
                        diaXCnt[0]++;
                    }
                    
                    if((i == 1 && j == 1) || (i == 0 && j == 2) || (i == 2 && j == 0)){
                        diaXCnt[1]++;
                    }
                
                }
            }
        }
        
        if(Ocnt == 0 && Xcnt == 0) answer = 1; // 아무것도 놓지 않았을 경우
        else if(Ocnt == 0 && Xcnt == 1) answer = 0; // 후공이 먼저 놓였을 경우
        else if(Ocnt == 1 && Xcnt == 0) answer = 1; // 선공이 먼저 놓았을 경우
        else if(Xcnt > Ocnt) answer = 0; // 후공이 더 많은 수를 놓았을 경우
        else if(Math.abs(Ocnt - Xcnt) > 1) answer = 0; // 후공과 선공의 차이가 2 이상인 경우
        else if(Ocnt >= 3 || Xcnt >= 2){
            // 이긴 사람이 있는지 확인
            int OwinCnt = 0;
            int XwinCnt = 0;
            for(int i = 0; i < 3; i++){
                if(rowOCnt[i] == 3 || colOCnt[i] == 3){
                    OwinCnt ++;
                }
                if(rowXCnt[i] == 3 || colXCnt[i] == 3){
                    XwinCnt ++;
                }
            }
            
            for(int i = 0; i < 2; i++){
                if(diaOCnt[i] == 3){
                    OwinCnt ++;
                }
                if(diaXCnt[i] == 3){
                    XwinCnt ++;
                }
            }
            
            if(OwinCnt > 0 && XwinCnt > 0) {
                answer = 0; // 선공과 후공이 동시에 승리하는 경우는 잘못된 상태
            } else if(OwinCnt > 0 && Ocnt > Xcnt) {
                answer = 1; // 선공 승리
            } else if(XwinCnt > 0 && Ocnt == Xcnt) {
                answer = 1; // 후공 승리
            } else if(OwinCnt == 0 && XwinCnt == 0) {
                answer = 1; // 승자가 없는 경우
            } else {
                answer = 0; // 그 외의 잘못된 상태
            }
        }
        else{
            answer = 1;
        }
        
        return answer;
    }
    
    
}