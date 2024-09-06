class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int start = 1;
        int end = 100001;
        while(start <= end){
            int mid = (start + end) / 2;
            long time = getLevel(diffs, times, mid);
            if(time <= limit){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        answer = start;
        return answer;
    }
    
    public long getLevel(int[] diffs, int[] times, int tempLevel){
        
        long totalTime = 0;
        long timePrev = 0;
        for(int i = 0; i < diffs.length; i++){
            long diff = diffs[i];
            long time = times[i];
            
            if(diff > tempLevel){
                totalTime += (time + timePrev) * (diff - tempLevel) + time;
                timePrev = time;
                continue;
            }
            else{
                totalTime += time;
                timePrev = time;
            }
        }
        
        return totalTime;
    }
}