class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        int lenOfT = t.length();
        int lenOfP = p.length();

        int left = 0;
        int right = lenOfP;

        long numberP = Long.parseLong(p);
        while(right <= lenOfT){
            String subStr = t.substring(left, right);
            long subNum = Long.parseLong(subStr);
            if(subNum <= numberP) answer++;

            left++;
            right++;
        }

        return answer;
    }
}