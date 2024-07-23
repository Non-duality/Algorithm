import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[N-1];
        int mid;
        while(start <= end){

            mid = (start + end) / 2;
            int cnt = 0;
            for(int i = 0; i < N; i++){
                if(arr[i] >= mid){
                    cnt += arr[i] / mid;
                }
            }

            if(cnt >= M ){
                start = mid + 1;
            }
            else {
                end = mid -1;
            }

        }
        System.out.println(end);
    }
}