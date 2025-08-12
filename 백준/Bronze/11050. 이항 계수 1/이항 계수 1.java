import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] factorials = new int[N + 1];
        factorials[0] = 1;
        for(int i = 1; i < N + 1; i++){
            factorials[i] = factorials[i - 1] * i;
        }

        int numerator = factorials[N];
        int denominator = factorials[K] * factorials[N - K];

        int result = numerator / denominator;

        System.out.println(result);
    }

}
