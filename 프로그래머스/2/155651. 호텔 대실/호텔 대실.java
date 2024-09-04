import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        List<Info> infoList = new ArrayList<>();
        for(int i = 0; i < book_time.length; i++){
            String startStr = book_time[i][0];
            String endStr = book_time[i][1];
            
            String[] start = startStr.split(":");
            String[] end = endStr.split(":");
            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            
            infoList.add(new Info(startTime, endTime));
        }
        Collections.sort(infoList, (o1,o2) -> Integer.compare(o1.start, o2.start));
        Set<Info> bookTime = new LinkedHashSet<>(infoList);
        
        while(!bookTime.isEmpty()){
            Iterator<Info> iterator = bookTime.iterator();
            List<Info> toRemove = new ArrayList<>();
            Info info = iterator.next();
            int curEnd = info.end;
            answer++;
            toRemove.add(info);
            
            while (iterator.hasNext()) {
                Info other = iterator.next();
                if (curEnd + 10 <= other.start) {
                    curEnd = other.end;
                    toRemove.add(other);
                }
            }
            
            bookTime.removeAll(toRemove);
        }
        
        return answer;
    }
    
    class Info{
        int start;
        int end;
        
        public Info(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}