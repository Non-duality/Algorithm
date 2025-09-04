import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static long[] fact;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        fact = new long[N + 1];
        fact[0] = 1;
        for(int i = 1; i <= N; i++) fact[i] = fact[i - 1] * i;

        st = new StringTokenizer(br.readLine());
        int mode = Integer.parseInt(st.nextToken());

        if(mode == 1){
            long k = Long.parseLong(st.nextToken());
            solveMode1(N,k);
        }

        else{
            int[] perm = new int[N];
            for(int i = 0; i < N; i++){
                perm[i] = Integer.parseInt(st.nextToken());
            }
            solveModel2(N, perm);
        }
    }

    private static void solveMode1(int N, long k){
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= N; i++) numbers.add(i);

        k--;
        StringBuilder sb = new StringBuilder();
        for(int i = N; i >= 1; i--){
            long blockSize = fact[i-1];
            int idx = (int)(k / blockSize);
            sb.append(numbers.get(idx)).append(" ");
            numbers.remove(idx);
            k %= blockSize;
        }

        System.out.println(sb.toString());
    }

    private static void solveModel2(int N, int[] perm){
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= N; i++) numbers.add(i);

        long k = 1;
        for(int i = 0; i < N; i++){
            int val = perm[i];
            int idx = numbers.indexOf(val);
            k += idx * fact[N - 1 - i];
            numbers.remove(idx);
        }

        System.out.println(k);
    }
}
