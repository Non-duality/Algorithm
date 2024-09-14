import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        Stack<Integer> auxiliaryBelt = new Stack<>();
        int mainBeltIndex = 1; // 메인 컨테이너 벨트에서 현재 확인할 상자 번호 (1부터 시작)
        int orderIndex = 0;    // 적재해야 할 상자의 순서 (order 배열의 인덱스)

        while (mainBeltIndex <= n || !auxiliaryBelt.isEmpty()) {
            if (mainBeltIndex <= n && mainBeltIndex == order[orderIndex]) {
                // 메인 벨트의 앞쪽 상자가 필요한 상자인 경우
                answer++;
                mainBeltIndex++;
                orderIndex++;
            } else if (!auxiliaryBelt.isEmpty() && auxiliaryBelt.peek() == order[orderIndex]) {
                // 보조 벨트의 맨 위 상자가 필요한 상자인 경우
                answer++;
                auxiliaryBelt.pop();
                orderIndex++;
            } else if (mainBeltIndex <= n) {
                // 메인 벨트의 앞쪽 상자를 보조 벨트로 이동
                auxiliaryBelt.push(mainBeltIndex);
                mainBeltIndex++;
            } else {
                // 더 이상 진행할 수 없는 경우 루프 종료
                break;
            }
        }

        return answer;
    }
}