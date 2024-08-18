import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        while(true){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            if(A == 0) break;

            int B = Integer.parseInt(st.nextToken());

            sb.append(A + B).append("\n");
        }
        System.out.println(sb.toString());
    }
}