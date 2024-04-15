import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int result = 0;
        int front = 0;
        int back = N-1;
        int sum = 0;

        while(front < back){

            sum = arr[front] + arr[back];
            if(sum > M){
                back--;
            }

            else if(sum < M){
                front++;
            }
            else{
                result++;
                front++;
                back--;
            }
        }

        System.out.println(result);

    }
}