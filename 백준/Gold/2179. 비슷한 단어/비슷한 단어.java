import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class WordInfo implements Comparable<WordInfo>{
        int idx;
        String word;

        WordInfo(int idx, String word){
            this.idx = idx;
            this.word = word;
        }

        @Override
        public int compareTo(WordInfo o) {
            int result = Integer.compare(this.idx, o.idx);
            if(result != 0) return result;
            return this.word.compareTo(o.word);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 접두사의 길이가 동일한 애들끼리 다 모은다.
        // -> 어떤 자료형이 적합한가 앞에 인덱스가 있어야 한다. 그리고 그 인덱스를 정렬을 할 수 있어야 한다.
        // 그 후 접두사의 길이가 제일 긴 단어 집합을 정렬한다.(입력된 순서를 기준으로)
        // 그 다음 동일한 접두사를 두쌍을 찾는다.

        List<WordInfo> words = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String word = br.readLine();
            words.add(new WordInfo(i, word));
        }
        Collections.sort(words, ((o1, o2) -> o1.word.compareTo(o2.word)));

        TreeMap<Integer, TreeSet<WordInfo>> map = new TreeMap<>(((o1, o2) -> o2 - o1));
        for(int i = 0; i < N - 1; i++){
            String first = words.get(i).word;
            int firstIdx = words.get(i).idx;

            String second = words.get(i + 1).word;
            int secondIdx = words.get(i + 1).idx;

            int cnt = 0;
            int len = Math.min(first.length(), second.length());
            for(int j = 0; j < len; j++){
                if(first.charAt(j) == second.charAt(j)) cnt++;
                else break;
            }

            if (cnt != 0) {
                TreeSet<WordInfo> temp = map.getOrDefault(cnt, new TreeSet<>());
                temp.add(new WordInfo(firstIdx, first));
                temp.add(new WordInfo(secondIdx, second));
                map.put(cnt, temp);
            }
        }

        int key = map.firstKey();
        TreeSet<WordInfo> set = map.get(key);
        Iterator<WordInfo> iterator = set.iterator();
        String result1 = iterator.next().word;
        String result2 = "";

        while(iterator.hasNext()){
            WordInfo nextWord = iterator.next();
            int cnt = 0;
            int len = Math.min(result1.length(), nextWord.word.length());
            for(int i = 0; i < len; i++){
                if(result1.charAt(i) == nextWord.word.charAt(i)) cnt++;
                else break;
            }
            if(cnt == key){
                result2 = nextWord.word;
                break;
            }
        }

        System.out.println(result1);
        System.out.println(result2);
    }

}