import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();

        StringBuilder sb = new StringBuilder();

        // 원본 문자열 하나씩 처리
        for(int i = 0; i < str.length(); i++){
            sb.append(str.charAt(i)); // 문자를 추가

            if(sb.length() >= bombLen){
                boolean isBomb = true;
                for(int j = 0; j < bombLen; j++){
                    if(sb.charAt(sb.length() - bombLen + j) != bomb.charAt(j)){
                        isBomb = false;
                        break;
                    }
                }
                if(isBomb) sb.delete(sb.length() - bombLen, sb.length());
            }
        }

        if(sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb.toString());
    }
}