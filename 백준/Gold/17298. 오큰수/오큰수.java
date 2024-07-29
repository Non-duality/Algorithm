import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            int number = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if(stack.peek()[0] < number){
                    int[] current = stack.pop();
                    arr[current[1]] = number;
                }
                else break;
            }

            stack.push(new int[]{number, i});
        }

        for(int i : arr){
            if(i != 0) sb.append(i).append(" ");
            else sb.append(-1).append(" ");
        }
        System.out.println(sb.toString());

    }
}