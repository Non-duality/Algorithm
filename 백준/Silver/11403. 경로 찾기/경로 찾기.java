import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] arr = null;
    private static int[][] result = null;
    private static boolean[] visited = null;
    private static boolean can = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i  = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
            }
        }

        result = new int[N][N];

        for(int i = 0; i < N; i++){
            visited = new boolean[N];
            for(int j = 0; j < N; j++){
                can = false;
                if(arr[i][j] == 1 && visited[j] == false){
                    DFS(i,j);
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void DFS(int r, int c){

        visited[c] = true;
        result[r][c] = 1;

        for(int i = 0; i < N; i++){
            if(arr[c][i] == 1 && visited[i] == false){
                DFS(r,i);
            }
        }


    }

}