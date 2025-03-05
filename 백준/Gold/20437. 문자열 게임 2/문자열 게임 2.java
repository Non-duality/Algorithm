import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TestCase = Integer.parseInt(br.readLine());

        for(int t = 0; t < TestCase; t++){

            String sentence = br.readLine();
            int K = Integer.parseInt(br.readLine());

            List<List<Integer>> pos = new ArrayList<>(26);
            for(int i = 0; i < 26; i++){
                pos.add(new ArrayList<>());
            }
            for(int i = 0; i < sentence.length(); i++){
                char c = sentence.charAt(i);
                pos.get(c - 'a').add(i);
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = -1;

            for(int i = 0; i < 26; i++){
                List<Integer> list = pos.get(i);
                if(list.size() < K) continue;

                for(int j = 0; j <= list.size() - K; j++){
                    int start = list.get(j);
                    int end = list.get(j + K - 1);
                    int len = end - start + 1;

                    minLen = Math.min(minLen, len);
                    maxLen = Math.max(maxLen, len);
                }
            }

            if(minLen == Integer.MAX_VALUE || maxLen == -1) sb.append(-1).append("\n");
            else sb.append(minLen).append(" ").append(maxLen).append("\n");

        }
        System.out.println(sb.toString());
    }
}