import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int R;
    private static int C;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2,N);

        recursion(size, 0, 0, 0);
        System.out.println(result);

    }

    private static void recursion(int size, int order, int rowStart, int colStart){
        int newSize = size / 2;

        if(size == 2){
            if(R < rowStart + newSize && C < colStart + newSize){
                result = order;
            }
            // 두 번째
            else if(R < rowStart + newSize && C >= colStart + newSize){
                result = order + 1;
            }
            // 세 번째
            else if(R >= rowStart + newSize && C < colStart + newSize){
                result = order + 2;
            }
            // 네 번째
            else if(R >= rowStart + newSize && C >= colStart + newSize){
                result = order + 3;
            }
            return;
        }

        // 첫 번째에 해당되는가?
        if(R < rowStart + newSize && C < colStart + newSize){
            recursion(newSize, order, rowStart, colStart);
        }
        // 두 번째
        else if(R < rowStart + newSize && C >= colStart + newSize){
            recursion(newSize, order + newSize * newSize, rowStart, colStart + newSize);
        }
        // 세 번째
        else if(R >= rowStart + newSize && C < colStart + newSize){
            recursion(newSize, order +  newSize * newSize * 2, rowStart + newSize, colStart);
        }
        // 네 번째
        else if(R >= rowStart + newSize && C >= colStart + newSize){
            recursion(newSize, order + newSize * newSize * 3, rowStart + newSize, colStart + newSize);
        }
    }
}