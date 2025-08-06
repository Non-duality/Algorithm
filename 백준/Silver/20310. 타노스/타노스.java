import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int zero = 0;
        int one = 0;
        for(int i = 0; i < S.length(); i++){
            int temp = S.charAt(i) - '0';
            if(temp == 0) zero ++;
            else one ++;
        }

        zero = zero / 2;
        one = one / 2;

        char[] arr = new char[zero + one];
        Arrays.fill(arr, 0, zero, '0');
        Arrays.fill(arr, zero, zero + one, '1');

        String result = new String(arr);
        System.out.println(result);
    }
}
