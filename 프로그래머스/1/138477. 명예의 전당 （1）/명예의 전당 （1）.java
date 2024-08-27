import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));

        for(int i = 0; i < score.length; i++){
            if(i <= k - 1) {
                pq.offer(score[i]);
                answer[i] = pq.peek();
                continue;
            }

            if(pq.peek() < score[i]){
                pq.poll();
                pq.offer(score[i]);
                answer[i] = pq.peek();
            }
            else{
                answer[i] = pq.peek();
            }

        }

        return answer;
    }
}