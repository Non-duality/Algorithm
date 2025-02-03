import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] count = new int[26];
        for(int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);

            // 소문자
            if((int)temp >= (int)'a'){
                count[temp - 'a'] += 1;
            }
            // 대문자
            else{
                count[temp - 'A'] += 1;
            }
        }

        int max = -1;
        char alpha = '?';
        for(int i = 0; i < 26; i++){
            if(max < count[i]){
                max = count[i];
                alpha = (char)(i + 'A');
            }
            else if(max == count[i]){
                alpha = '?';
            }
        }
        System.out.println(alpha);
    }
}