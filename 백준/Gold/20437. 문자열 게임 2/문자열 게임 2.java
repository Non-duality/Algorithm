import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 구해야 하는 것
        // 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이
        // 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이
        for (int i = 0; i < N; i++) {
            String sentence = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                sb.append("1 1\n");
                continue;
            }

            // 문자별 등장 위치 저장
            List<List<Integer>> pos = new ArrayList<>(26);
            for (int j = 0; j < 26; j++) {
                pos.add(new ArrayList<>());
            }
            for (int j = 0; j < sentence.length(); j++) {
                char c = sentence.charAt(j);
                pos.get(c - 'a').add(j);
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = -1;

            // 각 문자에 대해 처리
            for (int j = 0; j < 26; j++) {
                List<Integer> list = pos.get(j);
                if (list.size() < K) continue;

                // 슬라이딩 윈도우로 K개 포함 구간 찾기
                for (int m = 0; m <= list.size() - K; m++) {
                    int start = list.get(m);
                    int end = list.get(m + K - 1);
                    int len = end - start + 1;

                    // 최소 길이 갱신
                    minLen = Math.min(minLen, len);

                    // 최대 길이 갱신 (첫 번째와 마지막 문자가 같은 경우)
                    if (sentence.charAt(start) == sentence.charAt(end)) {
                        maxLen = Math.max(maxLen, len);
                    }
                }
            }

            if (minLen == Integer.MAX_VALUE || maxLen == -1) {
                sb.append("-1\n");
            } else {
                sb.append(minLen).append(" ").append(maxLen).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}