import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static Integer[] uniqueArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[N];
        int[] arr2 = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] = arr[i];
        }
        Arrays.sort(arr);
        LinkedHashSet<Integer> lhSet = new LinkedHashSet<>(Arrays.asList(arr));

        uniqueArr = lhSet.toArray(new Integer[0]);

        for(int i = 0; i < N; i++){
            sb.append(lessThanTarget(arr2[i])).append(" ");
        }

        System.out.println(sb);
    }

    private static int lessThanTarget(int target){
        int result = 0;

        int start = 0;
        int end = uniqueArr.length;
        int mid;

        while(start <= end){
            mid = (start + end) / 2;

            if(target < uniqueArr[mid]){
                end = mid - 1;
            } else if (target > uniqueArr[mid]) {
                start = mid + 1;
            } else if (target == uniqueArr[mid]) {
                result = mid;
                break;
            }
        }

        return result;
    }
}