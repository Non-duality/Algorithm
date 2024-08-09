import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M, V;
    private static List[] list;
    private static StringBuilder sb;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        int from, to;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(list[i]);
        }

        sb = new StringBuilder();
        visited = new boolean[N + 1];
        visited[V] = true;
        sb.append(V).append(" ");
        DFS(V, 0);

        sb.append("\n");

        visited = new boolean[N + 1];
        BFS();

        System.out.println(sb.toString());
    }

    private static void DFS(int ver, int cnt){

        if(cnt == N){
            return;
        }

        for(int i = 0; i < list[ver].size(); i++){
            int next = (int)list[ver].get(i);

            if(visited[next]) continue;

            visited[next] = true;
            sb.append(next).append(" ");
            DFS(next, cnt + 1);

        }
    }

    private static void BFS(){
        Queue<Integer> q = new ArrayDeque<>();

        visited[V] = true;
        sb.append(V).append(" ");
        q.offer(V);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i = 0; i < list[cur].size(); i++){
                int next = (int)list[cur].get(i);

                if(visited[next]) continue;

                visited[next] = true;
                sb.append(next).append(" ");
                q.offer(next);
            }
        }
    }

}