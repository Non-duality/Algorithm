import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] map;
    private static int minusOne;
    private static int zero;
    private static int one;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        boolean diff = false;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int prev = 0;
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(j == 0) prev = map[i][j];
                else{
                    if(prev != map[i][j]) diff = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(diff){
            recursion(N, 0, 0);
            sb.append(minusOne).append("\n");
            sb.append(zero).append("\n");
            sb.append(one);
        }
        else{
            if(map[0][0] == -1){
                sb.append(1).append("\n");
                sb.append(0).append("\n");
                sb.append(0);
            }
            else if(map[0][0] == 0){
                sb.append(0).append("\n");
                sb.append(1).append("\n");
                sb.append(0);
            }
            else if(map[0][0] == 1){
                sb.append(0).append("\n");
                sb.append(0).append("\n");
                sb.append(1);
            }
        }

        System.out.println(sb.toString());
    }

    private static void recursion(int size, int rowS, int colS){

        if(size == 1){
            if(map[rowS][colS] == -1) minusOne ++;
            else if(map[rowS][colS] == 0) zero ++;
            else if(map[rowS][colS] == 1) one ++;
            return;
        }

        int newSize = size / 3;

        for(int r = rowS; r < rowS + size; r += newSize){
            for(int c = colS; c < colS + size; c += newSize){
                boolean diff = false;
                int prev = map[r][c];
                L:for(int i = r; i < r + newSize; i++){
                    for(int j = c; j < c + newSize; j++){
                        if(map[i][j] != prev){
                            diff = true;
                            break L;
                        }
                    }
                }

                if(diff) {
                    recursion(newSize, r, c);
                }else{
                    if(map[r][c] == -1) minusOne ++;
                    else if(map[r][c] == 0) zero ++;
                    else if(map[r][c] == 1) one ++;
                }
            }
        }
    }
}