import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] belt = new int[2 * N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2 * N; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] robot = new boolean[N];
        int step = 0;

        while(true){
            step ++;

            // 1. 로봇과 함께 벨트 회전
            int lastDur = belt[2 * N - 1];
            for(int i = 2 * N - 1; i > 0; i--){
                belt[i] = belt[i - 1];
            }
            belt[0] = lastDur;

            for(int i = N - 1; i > 0; i--){
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[N - 1] = false;

            // 2. 로봇 이동
            for(int i = N - 2; i >= 0; i--){
                if(robot[i] && !robot[i + 1] && belt[i + 1] > 0){
                    robot[i] = false;
                    robot[i + 1] = true;
                    belt[i + 1] --;
                }
            }
            robot[N - 1] = false;

            // 3. 0번에 로봇 올리기
            if(belt[0] > 0){
                robot[0] = true;
                belt[0] --;
            }

            // 4. 내구도 0인 칸 개수 세기
            int zeroCnt = 0;
            for(int dur : belt){
                if(dur == 0) zeroCnt ++;
            }
            if(zeroCnt >= K) break;
        }

        System.out.println(step);
    }
}
