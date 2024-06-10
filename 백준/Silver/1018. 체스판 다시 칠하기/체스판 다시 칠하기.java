import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static char[][] map;
    private static int N, M;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int r = 0; r <= (N - 8); r++){
            for(int c = 0; c <= (M-8); c++){
                count(r, c);
            }
        }

        System.out.println(result);
    }

    private static void count(int r, int c) {
        String[] board = {"WBWBWBWB", "BWBWBWBW"};

        int whiteCount = 0;

        for(int i = 0; i < 8; i++){
            int row = r + i;
                for(int j = 0; j < 8; j++){
                    int col = c + j;

                    if(map[row][col] != board[row%2].charAt(j)){
                        whiteCount ++;
                    }
                }
        }

        int minVal = Math.min(whiteCount, 64-whiteCount);
        result = Math.min(result, minVal);
    }
}