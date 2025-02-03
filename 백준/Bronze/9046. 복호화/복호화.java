import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr;
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            arr = new int[26];

            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == ' ') continue;
                arr[str.charAt(j) - 'a'] += 1;
            }

            int max = -1;
            char result = '?';
            for(int j = 0; j < 26; j++){
                if(max < arr[j]){
                    max = arr[j];
                    int temp = 'a' + j;
                    result = (char) temp;
                }
                else if(max == arr[j]){
                    result = '?';
                }
            }

            System.out.println(result);
        }
    }
}