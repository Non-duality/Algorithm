import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, K;
    private static int[] dist = {-1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K){
            System.out.println(0);
        }else{
            int result = findSister();
            System.out.println(result);
        }

    }

    private static int findSister(){

        Queue<Integer> dq = new ArrayDeque<>();
        int[][] visited = new int[2][500001];
        Arrays.fill(visited[0], -1);
        Arrays.fill(visited[1], -1);

        dq.offer(N);
        visited[0][N] = 0;

        int result = -1;
        int step = 0, time = 0;
        while(!dq.isEmpty()){
            step ++;
            time ++;
            K += step;

            if(K > 500000){
                break;
            }

            if(visited[time % 2][K] != -1){
                result = time;
                break;
            }


            int size = dq.size();
            for(int i = 0; i < size; i++){
                int cur= dq.poll();

                for(int d = 0; d < 3; d++){
                    int next;
                    if (d == 2) {
                        next = cur * 2;
                    } else {
                        next = cur + dist[d];
                    }

                    if(next < 0 || next > 500000){
                        continue;
                    }

                    if(next == K){
                        result = time;
                        return result;
                    }

                    if(visited[time % 2][next] != -1){
                        continue;
                    }

                    visited[time % 2][next] = time;
                    dq.offer(next);

                }

            }

        }

        return result;
    }
}