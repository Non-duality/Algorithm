import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> tm = new TreeMap<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String extension = st.nextToken();
            tm.put(extension, tm.getOrDefault(extension, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : tm.entrySet()){
            sb.append(entry.getKey())
                    .append(" ")
                    .append(entry.getValue())
                    .append("\n");
        }
        System.out.println(sb.toString());
    }
}