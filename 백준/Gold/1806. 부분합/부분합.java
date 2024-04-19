import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minLength = Integer.MAX_VALUE;
        int length = 0;
        int front = 0;
        int back = 1;
        int sum = arr[front];

        if(sum >= S){
            length = 1;
            minLength = 1;
            sum = 0;
            front++;
        }

        sum += arr[back];

        if(sum >= S){
            length = back - front + 1;
            minLength = Math.min(length, minLength);
            sum -= arr[front];
            front++;
        }

        while(front < N){
            if(sum >= S){
                length = back - front + 1;
                minLength = Math.min(minLength, length);

                sum -= arr[front];
                front++;
            }

            else{
                if(back + 1 < N){
                    back++;
                    sum += arr[back];
                }

                else if(back == N-1){
                    sum -= arr[front];
                    front++;
                }

            }

        }

        if(minLength == Integer.MAX_VALUE){
            System.out.println(0);
            return;
        }
        System.out.println(minLength);
    }
}