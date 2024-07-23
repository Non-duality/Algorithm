import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());
            sb.append(getUpperIndex(target) - getLowerIndex(target)).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int getLowerIndex(int target){
        int start = 0;
        int end = N;
        int mid;

        while (start < end){
            mid = (start + end) / 2;

            if(target <= arr[mid]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return start;
    }

    private static int getUpperIndex(int target){
        int start = 0;
        int end = N;
        int mid;

        while (start < end) {
            mid = (start + end) / 2;

            if(target < arr[mid]){
                end = mid;
            }else {
                start = mid + 1;
            }
        }

        return start;
    }
}