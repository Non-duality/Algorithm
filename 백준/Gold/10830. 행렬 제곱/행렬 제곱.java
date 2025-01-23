import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B= Long.parseLong(st.nextToken());

        int[][] mat = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = matPow(mat, B);
        for(int[] row : result){
            for(int value : row){
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }

    private static int[][] matPow(int[][] mat, long B){
        int n = mat.length;
        int[][] identity = new int[n][n];
        for(int i = 0; i < n; i++){
            identity[i][i] = 1;
        }

        if(B == 0) return identity;
        else if(B % 2 == 0){
            int[][] halfPow = matPow(mat, B/2);
            return matMult(halfPow, halfPow);
        }else{
            return matMult(mat, matPow(mat, B - 1));
        }
    }

    private static int[][] matMult(int[][] A, int[][] B){
        int n = A.length;
        int[][] result = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % 1000;
                }
            }
        }

        return result;
    }
}