import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int N;
    private static char[] arr;
    private static List<Integer> numbers = new ArrayList<>();
    private static List<Character> operators = new ArrayList<>();
    private static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();

        for(int i = 0; i < N; i++){
            if(i % 2 == 0){
                numbers.add(arr[i] - '0');
            }
            else{
                operators.add(arr[i]);
            }
        }

        DFS(0, numbers.get(0));
        System.out.println(maxValue);

    }

    private static void DFS(int index, int currentResult) {
        if(index == operators.size()){
            maxValue = Math.max(maxValue, currentResult);
            return;
        }

        // 괄호 없는 연산
        int nextResult = calculate(currentResult, numbers.get(index + 1), operators.get(index));
        DFS(index + 1, nextResult);

        // 괄호를 넣는 연산
        if(index + 1 < operators.size()){
            int bracketResult = calculate(numbers.get(index + 1), numbers.get(index + 2), operators.get(index + 1));
            nextResult = calculate(currentResult, bracketResult, operators.get(index));
            DFS(index + 2, nextResult);
        }

    }

    private static int calculate(int a, int b, char operator) {
        switch (operator){
            case '+' : return a + b;
            case '-' : return a - b;
            case '*' : return a * b;
            default: return -1;
        }
    }
}