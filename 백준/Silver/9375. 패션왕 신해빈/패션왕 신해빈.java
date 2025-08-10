import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> clothesMap = new HashMap<>();

            StringTokenizer st = null;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();

                clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for(int count : clothesMap.values()){
                result *= (count + 1);
            }

            result -= 1;

            System.out.println(result);
        }
    }

}
