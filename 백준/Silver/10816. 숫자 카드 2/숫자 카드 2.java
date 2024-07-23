import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[] arr;
    private static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        map = new HashMap<>();
        for(int i = 0; i < N; i++){
            int number = Integer.parseInt(st.nextToken());
            if(map.containsKey(number)){
                int cnt = map.get(number);
                cnt ++;
                map.put(number, cnt);
            }else {
                map.put(number, 1);
            }
            arr[i] = number;
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int result = binarySearch(Integer.parseInt(st.nextToken()));
            sb.append(result).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int binarySearch(int target){
        int result = 0;

        int start = 0;
        int end = N-1;
        int mid;

        while(start <= end){
            mid = (start + end) / 2;

            if(target < arr[mid]){
                end = mid - 1;
            } else if(target > arr[mid]) {
                start = mid + 1;
            } else if(target == arr[mid]){
                result = map.get(target);
                break;
            }
        }

        return result;
    }
}