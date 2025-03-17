import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int water = 0;
        for(int i = 0; i < W; i++){
            int leftMax = 0;
            int rightMax = 0;

            for(int j = 0; j <= i; j++){
                leftMax = Math.max(leftMax, arr[j]);
            }

            for(int j = i; j < W; j++){
                rightMax = Math.max(rightMax, arr[j]);
            }

            water += Math.max(Math.min(leftMax, rightMax) - arr[i], 0);
        }

        System.out.println(water);
    }
}