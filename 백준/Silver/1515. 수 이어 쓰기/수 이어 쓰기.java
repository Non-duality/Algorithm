import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String subStr = br.readLine();

        int N = 1;
        int index = 0;

        while(index < subStr.length()){
            String curNum = String.valueOf(N);

            for(int i = 0; i < curNum.length(); i++){
                if(curNum.charAt(i) == subStr.charAt(index)){
                    index++;
                }

                if(index == subStr.length()){
                    System.out.println(N);
                    return;
                }
            }
            N++;
        }

    }
}