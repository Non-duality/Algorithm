import java.util.*;

class Solution {
    // 두 수의 최대 공약수를 구하는 함수
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 배열의 최대 공약수를 구하는 함수
    public int findGCD(int[] array) {
        int result = array[0];
        for (int num : array) {
            result = gcd(result, num);
            if (result == 1) { // 최대 공약수가 1이면 더 계산할 필요 없음
                return 1;
            }
        }
        return result;
    }

    // arrayB에 있는 모든 원소가 gcd로 나눠지는지 확인하는 함수
    public boolean canDivide(int gcd, int[] array) {
        for (int num : array) {
            if (num % gcd == 0) { // 나눠지면 안됨
                return false;
            }
        }
        return true;
    }

    // 솔루션 함수
    public int solution(int[] arrayA, int[] arrayB) {
        // 1. arrayA와 arrayB의 최대 공약수를 구함
        int gcdA = findGCD(arrayA);
        int gcdB = findGCD(arrayB);
        
        // 2. gcdA가 arrayB를 나눌 수 없는지 확인
        boolean canGcdADivideB = canDivide(gcdA, arrayB);
        
        // 3. gcdB가 arrayA를 나눌 수 없는지 확인
        boolean canGcdBDivideA = canDivide(gcdB, arrayA);
        
        // 4. 두 경우 중 더 큰 값을 리턴 (조건을 만족하는 경우만)
        int answer = 0;
        if (canGcdADivideB) {
            answer = gcdA;
        }
        if (canGcdBDivideA) {
            answer = Math.max(answer, gcdB);
        }
        
        return answer;
    }
}