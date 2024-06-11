import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] arr;
    private static int N;
    private static boolean[] visited;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0,0);
        System.out.println(result);
    }

    private static void combi(int cnt, int start) {

        if(cnt == N / 2){
            int[] teamA = new int[N/2];
            int[] teamB = new int[N/2];
            int cntA = 0;
            int cntB = 0;

            for(int i = 0; i < N; i++){
                if(visited[i]){
                    teamA[cntA] = i;
                    cntA++;
                }
                else{
                    teamB[cntB] = i;
                    cntB++;
                }
            }

            int sumA = 0;
            int sumB = 0;

            for(int i = 0; i < N / 2; i++){
                for(int j = 0; j < N / 2; j++){
                    sumA += arr[teamA[i]][teamA[j]];
                    sumB += arr[teamB[i]][teamB[j]];
                }
            }

            int diff = Math.abs(sumA-sumB);
            result = Math.min(result, diff);
            return;
        }

        for(int i = start; i < N; i++){
            visited[i] = true;
            combi(cnt + 1, i + 1);
            visited[i] = false;
        }
    }
}