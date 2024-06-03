import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] pokemonArr = new String[N];
        Map<String, Integer> pokemonMap = new HashMap<>();

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            pokemonArr[i] = temp;
            pokemonMap.put(temp, i);
        }

        for(int i = 0; i < M; i++){
            String temp = br.readLine();
            if(temp.chars().allMatch(Character::isDigit)){
                int num = Integer.parseInt(temp);
                sb.append(pokemonArr[num - 1]).append("\n");
            }
            else{
                sb.append(pokemonMap.get(temp) + 1).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}