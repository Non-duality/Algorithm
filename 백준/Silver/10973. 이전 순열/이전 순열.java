import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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

        // 뒤에서 부터 탐색
        int pivot = -1;
        for(int i = N - 1; i >= 1; i--){
            if(arr[i - 1] > arr[i]){
                pivot = i - 1;
                break;
            }
        }

        if(pivot != -1){
            // pivot에서 부터 오른쪽에서 제일 작은 값 찾기
            int minIdx = -1;
            int minVal = Integer.MAX_VALUE;

            for(int i = pivot + 1; i < N; i++){
                if(arr[i] < arr[pivot]){
                    minIdx = i;
                    minVal = Math.min(minVal, arr[i]);
                }
            }
            
            // 위치 교환하기
            int temp = arr[minIdx];
            arr[minIdx] = arr[pivot];
            arr[pivot] = temp;

            Integer[] integerArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            // pivot 이후 값 내림차순으로 정렬하기
            Arrays.sort(integerArr, pivot + 1, N, Comparator.reverseOrder());

            StringBuilder sb = new StringBuilder();
            for(int num : integerArr){
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString());
        }

        else{
            System.out.println(-1);
        }



    }
}
