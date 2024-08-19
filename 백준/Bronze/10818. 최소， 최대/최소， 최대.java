import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            maxVal = Math.max(maxVal, temp);
            minVal = Math.min(minVal,temp);
        }

        System.out.println(minVal + " " + maxVal);
    }
}