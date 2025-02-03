import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[5][15];
        for(int i = 0; i < 5; i++){
            String str = br.readLine();
            int leng = str.length();
            for(int j = 0; j < 15; j++){
                if(j < leng) arr[i][j] = str.charAt(j);
                else arr[i][j] = '.';
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 5; j++){
                if(arr[j][i] == '.') continue;
                else sb.append(arr[j][i]);
            }
        }

        System.out.println(sb.toString());
    }
}