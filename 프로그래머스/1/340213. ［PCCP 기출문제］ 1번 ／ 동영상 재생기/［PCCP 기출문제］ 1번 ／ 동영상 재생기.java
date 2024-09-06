class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String[] video = video_len.split(":");
        int videoTotal = Integer.parseInt(video[0]) * 60 + Integer.parseInt(video[1]);
        
        String[] current = pos.split(":");
        int posTotal = Integer.parseInt(current[0]) * 60 + Integer.parseInt(current[1]);
        
        String[] opS = op_start.split(":");
        int opSTotal = Integer.parseInt(opS[0]) * 60 + Integer.parseInt(opS[1]);
        
        String[] opE = op_end.split(":");
        int opETotal = Integer.parseInt(opE[0]) * 60 + Integer.parseInt(opE[1]);
        
        for(String comm : commands){
            // 시작 구간이 오프닝 구간에 있는지 확인하기
            if(opSTotal <= posTotal && posTotal <= opETotal) posTotal = opETotal;
            
            if(comm.equals("next")) {
                posTotal += 10;
                if(posTotal > videoTotal){
                    posTotal = videoTotal;
                }
            }
            else if(comm.equals("prev")) {
                posTotal -= 10;
                if(posTotal < 0){
                    posTotal = 0;
                }
            };
        }
        if(opSTotal <= posTotal && posTotal <= opETotal) posTotal = opETotal;
        
        int min = posTotal / 60;
        int sec = posTotal % 60;
        
        String minStr = min + "";
        if(minStr.length() == 1) minStr = 0 + minStr;
        
        String secStr = sec + "";
        if(secStr.length() == 1) secStr = 0 + secStr;
        
        answer = minStr + ":" + secStr;
        
        return answer;
    }
}