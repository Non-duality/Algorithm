class Solution {
    public int solution(String word) {
        int answer = 0;        
        
        String vowel = "AEIOU";
        int[] jump = {781, 156, 31, 6, 1};
        
        for(int i = 0; i < word.length(); i++){
            int idx = vowel.indexOf(word.charAt(i) + "");
            answer += idx * jump[i] + 1;
        }
        
        return answer;
    }
}