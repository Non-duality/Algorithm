import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<Data> list = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            list.add(new Data(data[i][0], data[i][1], data[i][2], data[i][3]));
        }
        
        // 작은 데이터 뽑아내기
        if(ext.equals("code")){
            Collections.sort(list, (o1, o2) -> Integer.compare(o1.code, o2.code));
            
            int cut = 0;
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).code >= val_ext) {
                    cut = i;
                    break;
                }
            }
            list = list.subList(0,cut);
        }
        
        else if(ext.equals("date")){
            Collections.sort(list, (o1, o2) -> Integer.compare(o1.date, o2.date));
            
            int cut = 0;
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).date >= val_ext) {
                    cut = i;
                    break;
                }
            }
            list = list.subList(0,cut);
        }
        
        else if(ext.equals("maximum")){
            Collections.sort(list, (o1, o2) -> Integer.compare(o1.maximum, o2.maximum));
            
            int cut = 0;
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).maximum >= val_ext) {
                    cut = i;
                    break;
                }
            }
            list = list.subList(0,cut);
        }
        
        else if(ext.equals("remain")){
            Collections.sort(list, (o1, o2) -> Integer.compare(o1.remain, o2.remain));
            
            int cut = 0;
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).remain >= val_ext) {
                    cut = i;
                    break;
                }
            }
            list = list.subList(0,cut);
        }
        
        int[][] answer = new int[list.size()][4];
        
        // sort_by 오름차순 정렬
        if(sort_by.equals("code")) Collections.sort(list, (o1, o2) -> Integer.compare(o1.code, o2.code));
        else if(sort_by.equals("date")) Collections.sort(list, (o1, o2) -> Integer.compare(o1.date, o2.date));
        else if(sort_by.equals("maximum")) Collections.sort(list, (o1, o2) -> Integer.compare(o1.maximum, o2.maximum));
        else if(sort_by.equals("remain")) Collections.sort(list, (o1, o2) -> Integer.compare(o1.remain, o2.remain));
        
        for(int i = 0; i < list.size(); i++){
            Data temp = list.get(i); 
            answer[i][0] = temp.code;
            answer[i][1] = temp.date;
            answer[i][2] = temp.maximum;
            answer[i][3] = temp.remain;
        }
        
        return answer;
    }
    
    class Data{
        int code;
        int date;
        int maximum;
        int remain;
        
        public Data(int code, int date, int maximum, int remain){
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
    }
}