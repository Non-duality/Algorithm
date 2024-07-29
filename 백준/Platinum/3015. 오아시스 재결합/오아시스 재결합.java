import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();

        long cnt = 0;
        for(int i = 0; i < N; i++){
            int height = Integer.parseInt(br.readLine());
            int[] current = new int[]{height, 1};

            while(!stack.isEmpty()){
                if(stack.peek()[0] <= height){
                    int[] pop = stack.pop();
                    cnt += pop[1];
                    if(pop[0] == height){
                        current[1] += pop[1];
                    }
                }
                else break;
            }

            if(!stack.isEmpty()) cnt ++;

            stack.push(current);
        }

        System.out.println(cnt);
    }
}