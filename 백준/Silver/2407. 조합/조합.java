import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BigInteger[] factorials;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        factorials = new BigInteger[n + 1];
        factorials[0] = BigInteger.ONE;

        for(int i = 1; i <= n; i++){
            factorials[i] = factorials[i - 1].multiply(BigInteger.valueOf(i));
        }

        BigInteger numerator = factorials[n];
        BigInteger denominator = factorials[m].multiply(factorials[n - m]);
        BigInteger result = numerator.divide(denominator);

        System.out.println(result.toString());
    }


}
