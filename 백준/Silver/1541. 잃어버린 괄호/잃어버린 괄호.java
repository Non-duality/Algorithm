import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] separation = input.split("-");
        int length = separation.length;
        // 1차로 덧셈 먼저 해주기
        for(int i = 0; i < length; i++){
            String[] tempArr = separation[i].split("\\+");
            int tempLength = tempArr.length;
            int num = 0;
            for(int j = 0; j < tempLength; j++){
                if(tempArr[j].equals("+")){
                    continue;
                }
                num += Integer.parseInt(tempArr[j]);
            }
            separation[i] = String.valueOf(num);
        }

        // 2차로 뺄셈
        int result = Integer.parseInt(separation[0]);
        for(int i = 1; i < length; i++){
            result -= Integer.parseInt(separation[i]);
        }

        System.out.println(result);
    }
}