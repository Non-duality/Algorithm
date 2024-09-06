import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        Map<String, Integer> map = getPosMap(points, routes);
        
        for(String key : map.keySet()){
            int cnt = map.get(key);
            if(cnt > 1) answer++;
        }
        
        return answer;
    }
    
    public Map<String, Integer> getPosMap(int[][] points, int[][] routes){
        
        Map<String, Integer> map = new HashMap<>();
        
        // 각 로봇마다 최단 경로 위치를 MAP에 집어 넣기
        for(int i = 0; i < routes.length; i++){
            int time = 0;
            String key = "";
            for(int j = 0; j < routes[i].length; j++){
                if(j == routes[i].length - 1) continue;
                
                int start = routes[i][j];
                int[] startPos = points[start - 1].clone();
                
                int goal = routes[i][j + 1];
                int[] goalPos = points[goal - 1].clone();
                
                if(j == 0){
                    key = startPos[0] + "r" + startPos[1] + "c" + time;
                    if(map.containsKey(key)){
                        map.put(key, map.get(key) + 1);
                    }else{
                        map.put(key, 1);
                    }
                    time++;
                }
                
                // 목표 지점이 시작 지점 보다 위에 있을 경우
                if(goalPos[0] < startPos[0]){
                    while(startPos[0] != goalPos[0]){
                        startPos[0] --;
                        key = startPos[0] + "r" + startPos[1] + "c" + time;
                        if(map.containsKey(key)){
                            map.put(key, map.get(key) + 1);
                        }else{
                            map.put(key, 1);
                        }
                        time ++;
                    }
                }
                
                // 목표 지점이 시작 지점 보다 아래에 있을 경우
                if(goalPos[0] > startPos[0]){
                    while(startPos[0] != goalPos[0]){
                        startPos[0] ++;
                        key = startPos[0] + "r" + startPos[1] + "c" + time;
                        if(map.containsKey(key)){
                            map.put(key, map.get(key) + 1);
                        }else{
                            map.put(key, 1);
                        }
                        time ++;
                    }
                }
                
                // 목표 지점이 시작 지점 보다 왼쪽에 있을 경우
                if(goalPos[1] < startPos[1]){
                    while(startPos[1] != goalPos[1]){
                        startPos[1] --;
                        key = startPos[0] + "r" + startPos[1] + "c" + time;
                        if(map.containsKey(key)){
                            map.put(key, map.get(key) + 1);
                        }else{
                            map.put(key, 1);
                        }
                        time ++;
                    }
                }
                
                // 목표 지점이 시작 지점 보다 오른쪽에 있을 경우
                if(goalPos[1] > startPos[1]){
                    while(startPos[1] != goalPos[1]){
                        startPos[1] ++;
                        key = startPos[0] + "r" + startPos[1] + "c" + time;
                        if(map.containsKey(key)){
                            map.put(key, map.get(key) + 1);
                        }else{
                            map.put(key, 1);
                        }
                        time ++;
                    }
                }
                
            }
            
        }
        
        return map;
    }
}