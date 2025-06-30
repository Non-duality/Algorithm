import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0; i < n; i++){
            currentSum = Math.max(currentSum + arr[i], arr[i]);
            result = Math.max(result, currentSum);
        }

        System.out.println(result);
    }
}