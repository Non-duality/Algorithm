import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 뒤에서 부터 탐색했을 때 오름차순이 깨지는 pivot 찾기
        boolean last = true;
        int pivot = -1;
        for(int i = N - 1; i >= 1; i--){
            if(arr[i] > arr[i - 1]){
                last = false;
                pivot = i - 1;
                break;
            }
        }

        if(last){
            System.out.println(-1);
        }

        else{
            // pivot 보다 크면서 제일 작은 값 찾기
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int i = pivot; i < N; i++){
                if(arr[pivot] < arr[i] && min > arr[i]) {
                    min = Math.min(min, arr[i]);
                    minIdx = i;
                }
            }
            // 자리 바꾸기
            int temp = arr[pivot];
            arr[pivot] = arr[minIdx];
            arr[minIdx] = temp;

            // pivot 뒤를 오름차순 정렬
            Arrays.sort(arr, pivot + 1, N);

            StringBuilder sb = new StringBuilder();
            for(int val : arr){
                sb.append(val).append(" ");
            }
            System.out.println(sb.toString());
        }

    }
}
