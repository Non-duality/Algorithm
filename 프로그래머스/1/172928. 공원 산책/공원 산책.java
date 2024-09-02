class Solution {
    
    static int N, M;
    static String[] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = { 0, 0,-1, 1};
    
    public int[] solution(String[] park, String[] routes) {
        map = park;
        N = park.length;
        M = park[0].length();

        int startR = 0, startC = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(park[i].charAt(j) == 'S'){
                    startR = i;
                    startC = j;
                    break;
                }
            }
        }
        
        for(int i = 0; i < routes.length; i++){
            String[] info = routes[i].split(" ");
            int step = Integer.parseInt(info[1]);
            
            if(info[0].equals("N")){
                int nr = startR;
                boolean canMove = true;
                while(step-- > 0){
                    nr -= 1;
                    if(!check(nr,startC)) canMove = false;
                }
                if(!canMove) continue;
                startR = nr;
            }
            else if(info[0].equals("S")){
                int nr = startR;
                boolean canMove = true;
                while(step-- > 0){
                    nr += 1;
                    if(!check(nr,startC)) canMove = false;
                }
                if(!canMove) continue;
                startR = nr;
            }
            else if(info[0].equals("W")){
                int nc = startC;
                boolean canMove = true;
                while(step-- > 0){
                    nc -= 1;
                    if(!check(startR,nc)) canMove = false;
                }
                if(!canMove) continue;
                startC = nc;
            }
            else if(info[0].equals("E")){
                int nc = startC;
                boolean canMove = true;
                while(step-- > 0){
                    nc += 1;
                    if(!check(startR,nc)) canMove = false;
                }
                if(!canMove) continue;
                startC = nc;
            }
        }
        
        return new int[] {startR, startC};
    }
    
    public boolean check(int r, int c){
        // 공원을 벗어나는 경우
        if(r < 0 || r >= N || c < 0 || c >= M) return false;
        // 장애물인 경우
        if(map[r].charAt(c) == 'X') return false;
        
        return true;
    }
}