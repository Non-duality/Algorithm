import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static int N;
    private static int[] roma = {1, 5, 10, 50};
    private static Set<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new HashSet<>();

        comb(0, 0, 0);
        System.out.println(result.size());
    }

    private static void comb(int idx, int cnt, int sum){
        if(N == cnt){
            result.add(sum);
            return;
        }

        for(int i = idx; i < 4; i++){
            comb(i,cnt + 1, sum + roma[i]);
        }
    }
}
