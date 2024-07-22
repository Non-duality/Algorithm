import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] visited = new int[N + 1];
        Arrays.fill(visited, -1);
        Queue<Integer> queue = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int x = Integer.parseInt(st.nextToken());
            visited[x] = 0;
            queue.add(x);
        }

        int maxDist = 0;
        int n = Integer.toBinaryString(N).length();

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i = 0; i < n; i++) {
                int nx = x ^ (1 << i);
                if (nx > N || visited[nx] != -1) {
                    continue;
                }
                visited[nx] = visited[x] + 1;
                queue.add(nx);
                maxDist = Math.max(maxDist, visited[nx]);
            }
        }

        System.out.println(maxDist);
    }
}