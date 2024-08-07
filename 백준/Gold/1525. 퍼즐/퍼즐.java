import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static String init = "";
    private static String target = "123456780";
    private static Map<String, Integer> map = new HashMap<>();
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = { 0, 0,-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3; j++){
                init += st.nextToken();
            }
        }

        map.put(init, 0);
        int result = BFS();
        System.out.println(result);
    }

    private static int BFS(){
        Queue<String> q = new ArrayDeque<>();
        q.offer(init);

        while(!q.isEmpty()){
            String current = q.poll();

            int empty = current.indexOf("0");
            int cnt = map.get(current);
            int r = empty % 3;
            int c = empty / 3;

            if(current.equals(target)) return cnt;

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= 3 || nc < 0 || nc >= 3) continue;

                int nPos = nc * 3 + nr;
                char change = current.charAt(nPos);

                String next = current.replace(change, 'c');
                next = next.replace('0', change);
                next = next.replace('c', '0');

                if(!map.containsKey(next)){
                    q.offer(next);
                    map.put(next, cnt + 1);
                }
            }
        }

        return -1;
    }
}