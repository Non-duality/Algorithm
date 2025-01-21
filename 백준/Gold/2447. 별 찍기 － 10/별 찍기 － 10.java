import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new String[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = "*";
            }
        }

        recursion(N, 0, 0);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void recursion(int size, int rowS, int colS){

        if(size == 3){
            map[rowS + 1][colS + 1] = " ";
            return;
        }


        int newSize = size / 3;

        for(int r = rowS; r < rowS + size; r += newSize){
            for(int c = colS; c < colS + size; c += newSize){
                if(r == (rowS + newSize) && c == (colS + newSize)){
                    for(int i = r; i < r + newSize; i++){
                        for(int j = c; j < c + newSize; j++){
                            map[i][j] = " ";
                        }
                    }
                }
                else {
                    recursion(newSize, r, c);
                }
            }
        }

    }
}