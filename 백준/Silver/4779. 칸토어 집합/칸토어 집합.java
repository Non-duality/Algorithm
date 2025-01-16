import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] pow3 = new int[13];
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        // 거듭 제곱 값 미리 만들기
        pow3[0] = 1;
        for(int i = 1; i < 13; i++){
            pow3[i] = pow3[i - 1] * 3;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            int N = Integer.parseInt(str);

            sb = new StringBuilder();
            for(int i = 0; i < pow3[N]; i++){
                sb.append("-");
            }

            recursion(0, pow3[N]);

            System.out.println(sb.toString());
        }
    }

    private static void recursion(int start, int size){
        if(size == 1) return;

        int newSize = size / 3;

        for(int i = start + newSize; i < start + 2 * newSize; i++){
            sb.setCharAt(i, ' ');
        }

        recursion(start, newSize);
        recursion(start + 2 * newSize, newSize);
    }
}