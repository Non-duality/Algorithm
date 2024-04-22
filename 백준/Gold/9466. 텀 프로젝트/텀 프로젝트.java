import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] selectArr;
    private static boolean[] visited;
    private static boolean[] finished;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            selectArr = new int[N + 1];
            for(int i = 1; i <= N; i++){
                selectArr[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            count = 0;

            for(int i = 1; i < N+1; i++){
                DFS(i);
            }

            System.out.println(N - count);

        }

    }

    private static void DFS(int now){

        if(visited[now]){
            return;
        }

        visited[now] = true;
        int next = selectArr[now];

        if(!visited[next]){
            DFS(next);
        }
        else{
            if(!finished[next]){
                count++;
                for(int i = next; i != now; i = selectArr[i]){
                    count++;
                }
            }
        }

        finished[now] = true;
        
    }


}