import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] map;
    private static int white, blue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int sum = 0;
        int target = N * N;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }

        if(sum == 0){
            white = 1;
            blue = 0;
        } else if(sum == target){
           white = 0;
           blue = 1;
        } else if(sum != 0 && target != sum){
            white = 0;
            blue = 0;
            recursion(N, 0, 0);
        }

        System.out.println(white);
        System.out.println(blue);
    }

    private static void recursion(int size, int rowStart, int colStart){

        if(size == 1){
            if(map[rowStart][colStart] == 0) white++;
            else blue ++;
            return;
        }

        int newSize = size / 2;

        // 첫 번째
        int sum = 0;
        int target = newSize * newSize;
        for(int r = rowStart; r < rowStart + newSize; r++){
            for(int c = colStart; c < colStart + newSize; c++){
                sum += map[r][c];
            }
        }

        if(sum == 0){
            white ++;
        } else if(target == sum){
            blue ++;
        } else if(sum != 0 && target != sum){
            recursion(newSize, rowStart, colStart);
        }

        // 두 번째
        sum = 0;
        for(int r = rowStart; r < rowStart + newSize; r++){
            for(int c = colStart + newSize; c < colStart + (2 * newSize); c++){
                sum += map[r][c];
            }
        }
        if(sum == 0){
            white ++;
        } else if(target == sum){
            blue ++;
        } else if(sum != 0 && target != sum){
            recursion(newSize, rowStart, colStart + newSize);
        }

        // 세 번째
        sum = 0;
        for(int r = rowStart + newSize; r < rowStart + (2 * newSize); r++){
            for(int c = colStart; c < colStart + newSize; c++){
                sum += map[r][c];
            }
        }
        if(sum == 0){
            white ++;
        } else if(target == sum){
            blue ++;
        } else if(sum != 0 && target != sum){
            recursion(newSize, rowStart + newSize, colStart);
        }

        // 네 번째
        sum = 0;
        for(int r = rowStart + newSize; r < rowStart + (2 * newSize); r++){
            for(int c = colStart + newSize; c < colStart + (2 * newSize); c++){
                sum += map[r][c];
            }
        }
        if(sum == 0){
            white ++;
        } else if(target == sum){
            blue ++;
        } else if(sum != 0 && target != sum){
            recursion(newSize, rowStart + newSize, colStart + newSize);
        }

    }
}