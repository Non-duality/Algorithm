import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        String str = "";
        for(int i = 0; i < N; i++){
            str = br.readLine();
            map.put(str, 1);
        }

        List<String> results = new ArrayList<>();
        for(int i = 0; i < M; i++){
            str = br.readLine();
            if(map.containsKey(str)){
                results.add(str);
            }
        }

        Collections.sort(results);
        
        StringBuilder sb = new StringBuilder();
        sb.append(results.size()).append("\n");
        for(String temp : results){
            sb.append(temp).append("\n");
        }
        System.out.println(sb.toString());
    }
}