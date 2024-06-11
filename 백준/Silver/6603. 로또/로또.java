import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int K;
    private static int[] arr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while(true) {
            st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());
            if(K == 0){
                break;
            }

            arr = new int[K];
            visited = new boolean[K];
            for(int i = 0; i < K; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.setLength(0);
            combination(0, 0);

            System.out.println();
        }


    }

    private static void combination(int cnt, int start) {
        if(cnt == 6) {
            for(int i = 0; i < K; i++){
                if(visited[i]){
                    sb.append(arr[i]).append(" ");
                }
            }
            System.out.println(sb.toString());
            sb.setLength(0);
            return;
        }

        for(int i = start; i < K; i++) {
            visited[i] = true;
            combination(cnt + 1, i + 1);
            visited[i] = false;
        }

    }
}