import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

        StringBuilder sb =new StringBuilder(S);
        zero = zero / 2;
        one = one / 2;

        int idx = 0;
        while(one != 0){
            if(sb.charAt(idx) - '0' == 1){
                sb.deleteCharAt(idx);
                one --;
            }
            else idx++;

            if(idx == sb.length()) break;
        }

        idx = sb.length() - 1;
        while(zero != 0){
            if(sb.charAt(idx) - '0' == 0){
                sb.deleteCharAt(idx);
                zero --;
            }

            idx--;
            if(idx == -1) break;
        }

        System.out.println(sb.toString());
    }
}
