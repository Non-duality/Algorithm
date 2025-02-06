import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] counts = new int[26];
        for(char c : input.toCharArray()){
            counts[c - 'A']++;
        }

        int oddCount = 0;
        for(int count : counts){
            if(count % 2 != 0) oddCount++;
        }

        if(oddCount > 1) System.out.println("I'm Sorry Hansoo");
        else{
            StringBuilder leftHalf = new StringBuilder();
            String middle = "";
            for(int i = 0; i < 26; i++){
                if(counts[i] % 2 != 0) middle += (char)(i + 'A');

                for(int j = 0; j < counts[i] / 2; j++){
                    leftHalf.append((char)(i + 'A'));
                }
            }
            String rightHalf = new StringBuilder(leftHalf).reverse().toString();
            System.out.println(leftHalf + middle + rightHalf);
        }
    }
}