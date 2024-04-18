import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[100001];
        long result = 0;

        int front = 0;
        int back = -1;

        // 순차적으로 수열을 탐색
        while(front < N){

            // 새로운 수, 배열의 범위를 넘지 않으면
            while(back + 1 < N && cnt[arr[back + 1]] == 0){
                // 뒤로 이동
                back++;
                cnt[arr[back]] += 1;
            }

            result += back - front + 1;

            cnt[arr[front]] -= 1;
            front++;
        }

        System.out.println(result);


    }
}