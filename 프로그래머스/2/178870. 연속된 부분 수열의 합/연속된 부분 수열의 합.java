import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        List<Info> list = new ArrayList<>();

        int left = 0;
        int right = 0;
        int sum = sequence[left];

        while(left <= right){
            if(sum == k){
                list.add(new Info(left, right, right - left + 1));
                if(left + 1 > right){
                    right ++;
                    if(right > sequence.length - 1) break;
                    sum += sequence[right];
                } else{
                    sum -= sequence[left];
                    left ++;
                }
            } else if(sum > k){
                if(left + 1 > right){
                    right ++;
                    if(right > sequence.length - 1) break;
                    sum += sequence[right];
                } else{
                    sum -= sequence[left];
                    left ++;
                }

            } else if(sum < k) {
                right++;
                if(right > sequence.length - 1) break;
                sum += sequence[right];
            }

        }

        Collections.sort(list, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {

                if(o1.len == o2.len){
                    return Integer.compare(o1.left, o2.left);
                }
                return Integer.compare(o1.len, o2.len);
            }
        });

        Info result = list.get(0);
        answer[0] = result.left;
        answer[1] = result.right;
        return answer;
    }
    
    class Info {
        public int left;
        public int right;
        public int len;

        public Info(int left, int right, int len){
            this.left = left;
            this.right = right;
            this.len = len;
        }
    }
}