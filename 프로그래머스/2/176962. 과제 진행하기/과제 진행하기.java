import java.util.*;

class Solution {
    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        int size = plans.length;
        Queue<HomeWork> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.start, o2.start));

        for(int i = 0; i < size; i++){
            String subject = plans[i][0];

            String[] temp = plans[i][1].split(":");
            int hour = Integer.parseInt(temp[0]);
            int min = Integer.parseInt(temp[1]);

            int start = (hour * 60) + min;
            int playTime = Integer.parseInt(plans[i][2]);

            pq.offer(new HomeWork(subject, start, playTime));
        }

        Stack<HomeWork> stack = new Stack<>();
        while(!pq.isEmpty()){
            HomeWork nowWork = pq.poll();
            int currentTime = nowWork.start;

            // 과제가 남아있는 경우
            if(!pq.isEmpty()){
                HomeWork nextWork = pq.peek();

                // 현재 과제를 빨리 끝내 멈춰둔 과제를 할 수 있는 경우
                if(currentTime + nowWork.playtime < nextWork.start){
                    answer.add(nowWork.subject);
                    currentTime += nowWork.playtime;

                    // 잠시 멈춘 과제가 있는 경우
                    while(!stack.isEmpty()){
                        HomeWork delayWork = stack.pop();
                        // 다음 과제 시작 전 까지 끝내는 경우
                        if(currentTime + delayWork.playtime <= nextWork.start){
                            currentTime += delayWork.playtime;
                            answer.add(delayWork.subject);
                        }
                        // 끝내지 못하는 경우
                        else{
                            int remainTime = delayWork.playtime - (nextWork.start - currentTime);
                            int changeStart = delayWork.start + (nextWork.start - currentTime);
                            stack.push(new HomeWork(delayWork.subject, changeStart, remainTime));
                            break;
                        }
                    }

                }

                // 과제 끝난 시점과 새 과제 시점이 같을 경우
                else if(nowWork.start + nowWork.playtime == nextWork.start){
                    answer.add(nowWork.subject);
                }

                // 새 과제 전까지 지금 과제를 끝내지 못했을 경우
                else {
                    int remainTime = nowWork.playtime - (nextWork.start - currentTime);
                    int changeStart = nowWork.start + (nextWork.start - currentTime);
                    stack.push(new HomeWork(nowWork.subject, changeStart, remainTime));
                }
            }

            // 과제가 없는 경우
            else{
                // 남은 과제도 없는 경우
                if(stack.isEmpty()){
                    answer.add(nowWork.subject);
                }
                // 남은 과제가 있는 경우
                else{
                    answer.add(nowWork.subject);
                    while(!stack.isEmpty()){
                        HomeWork delayWork = stack.pop();
                        answer.add(delayWork.subject);
                    }
                }
            }

        }

        return answer;
    }
    
    class HomeWork{
        String subject;
        int start;
        int playtime;

        public HomeWork(String subject, int start, int playtime){
            this.subject = subject;
            this.start = start;
            this.playtime = playtime;
        }
    }
}