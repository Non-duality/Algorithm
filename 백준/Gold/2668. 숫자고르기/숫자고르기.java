import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static int N;
    private static int target;
    private static int[] arr;
    private static boolean[] visited;
    private static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[N + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            target = i;
            DFS(i);
            visited[i] = false;
        }

        // 결과 출력
        Collections.sort(result);
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }

    private static void DFS(int start) {
        if(arr[start] == target){
            result.add(target);
        }

        if(!visited[arr[start]]){
            visited[arr[start]] = true;
            DFS(arr[start]);
            visited[arr[start]] = false;
        }
    }
}