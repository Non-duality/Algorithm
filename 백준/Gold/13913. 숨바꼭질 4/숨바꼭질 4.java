import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, K;
    private static int[] dir = {-1, 1};
    private static int[] prev = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int time = BFS();
        System.out.println(time);
        getPath();
    }

    private static int BFS(){
        Queue<Integer> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];

        dq.offer(N);
        visited[N] = true;
        prev[N] = -1;

        int time = 0;
        while(!dq.isEmpty()){
            int size = dq.size();

            for(int i = 0; i < size; i++){
                int cur = dq.poll();
                if(cur == K){
                    return time;
                }

                for(int d = 0; d < 3; d++){
                    int next;

                    if(d==2) next = cur * 2;
                    else next = cur + dir[d];

                    if(next < 0 || next > 100000 || visited[next]){
                        continue;
                    }

                    visited[next] = true;
                    dq.offer(next);
                    prev[next] = cur;
                }
            }
            time ++;
        }

        return -1;
    }

    private static void getPath(){
        List<Integer> path = new ArrayList<>();
        for(int i = K; i != -1; i = prev[i]) {
            path.add(i);
        }
        Collections.reverse(path);

        for(int pos : path){
            System.out.print(pos + " ");
        }
        System.out.println();
    }
}