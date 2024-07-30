import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if(N == 0) break;

            int height[] = new int[N];
            for(int i = 0; i < N; i++){
                height[i] = Integer.parseInt(st.nextToken());
            }

            Stack<Integer> stack = new Stack<>();
            long result = 0;

            for(int i = 0; i < N; i++){

                while(!stack.isEmpty()){
                    if(height[stack.peek()] > height[i]){
                        int index = stack.pop();
                        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                        result = Math.max(result, (long) width * height[index]);
                    }
                    else break;
                }
                stack.push(i);
            }

            while(!stack.isEmpty()){
                int index = stack.pop();
                int width = stack.isEmpty() ? N : N - stack.peek() - 1;
                result = Math.max(result, (long) width * height[index]);
            }

            System.out.println(result);
        }
    }
}