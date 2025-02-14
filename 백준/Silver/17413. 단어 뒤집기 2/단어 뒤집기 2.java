import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        StringBuilder resultBuilder = new StringBuilder();
        StringBuilder wordBuilder = new StringBuilder();

        boolean tag = false;
        for(int i = 0; i < sentence.length(); i++){
            char cur = sentence.charAt(i);

            if(cur == '<'){
                if(wordBuilder.length() > 0){ // 이전 단어(태그 밖)가 있었다면 뒤집어서 결과에 추가
                    resultBuilder.append(reverseWord(wordBuilder.toString()));
                    wordBuilder.setLength(0); // 초기화
                }
                tag = true;
                resultBuilder.append(cur);
            } else if(cur == '>'){
                tag = false;
                resultBuilder.append(cur);
            } else if(cur == ' '){
                if(tag) resultBuilder.append(cur);
                else{
                    if(wordBuilder.length() > 0){
                        resultBuilder.append(reverseWord(wordBuilder.toString())).append(cur);
                        wordBuilder.setLength(0);
                    }else resultBuilder.append(cur);
                }
            } else{
                if(tag) resultBuilder.append(cur);
                else wordBuilder.append(cur);
            }
        }
        if(wordBuilder.length() > 0) resultBuilder.append(reverseWord(wordBuilder.toString()));
        System.out.println(resultBuilder.toString());
    }

    private static String reverseWord(String word){
        return new StringBuilder(word).reverse().toString();
    }
}