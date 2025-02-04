import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        String word = "";
        for(int i = 0; i < N; i++){
            word = br.readLine();
            if(word.length() >= M){
                map.put(word, map.getOrDefault(word, 1) + 1);
            }
        }

        List<String> words = new ArrayList<>(map.keySet());

        words.sort((a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);

            if(freqA != freqB) return freqB - freqA;
            if(a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for(String temp : words){
            sb.append(temp).append("\n");
        }
        System.out.println(sb.toString());

    }
}