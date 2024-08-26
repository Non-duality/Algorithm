import java.util.*;
    
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        ArrayList<Integer>[] outList = new ArrayList[1000001];
        ArrayList<Integer>[] inList = new ArrayList[1000001];
        
        for(int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            
            if(outList[a] == null) outList[a] = new ArrayList<>();
            if(outList[b] == null) outList[b] = new ArrayList<>();
            if(inList[a] == null) inList[a] = new ArrayList<>();
            if(inList[b] == null) inList[b] = new ArrayList<>();

            outList[a].add(b);
            inList[b].add(a);
        }
        
        int total = 0;

        for(int i = 1; i < 1000001; i++) {
            if(outList[i] == null || inList[i] == null) continue;

            if(outList[i].size() >= 2 && inList[i].size() == 0) {
                total = outList[i].size();
                answer[0] = i;
            }
        }

        for(int i = 1; i < 1000001; i++) {
            if(outList[i] == null || inList[i] == null) continue;
            if(i == answer[0]) continue;
            if(outList[i].size() == 2) answer[3]++;
            else if (outList[i].isEmpty()) answer[2]++;
        }

        answer[1] = total - (answer[2] + answer[3]);
        
        return answer;
    }
}