class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i = 0; i < babbling.length; i++){
            if(babbling[i].contains("ayaaya") ||
               babbling[i].contains("yeye")   ||
               babbling[i].contains("woowoo") ||
               babbling[i].contains("mama")){
                continue;
            }
            
            babbling[i] = babbling[i].replace("aya", "1");
            babbling[i] = babbling[i].replace("ye", "1");
            babbling[i] = babbling[i].replace("woo", "1");
            babbling[i] = babbling[i].replace("ma", "1");
            babbling[i] = babbling[i].replace("1","");
            
            if(babbling[i].length() == 0) answer++;
        }
        
        return answer;
    }
}