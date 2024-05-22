import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        List<String> list = new ArrayList<>();
        int length = input.length();
        String tempX = "";
        String tempP = "";
        for(int i = 0; i < length; i++){
            String temp = String.valueOf(input.charAt(i));

            if(temp.equals("X")){
                if(!tempP.equals("")){
                    list.add(tempP);
                    tempP = "";
                }
                tempX += temp;
                if(i == length - 1){
                    list.add(tempX);
                }

            }
            else if(temp.equals(".")){
                if(!tempX.equals("")){
                    list.add(tempX);
                    tempX = "";
                }
                tempP += temp;
                if(i == length - 1){
                    list.add(tempP);
                }
            }

        }

        int result = 0;
        String strResult = "";
        length = list.size();
        for(int i = 0; i < length; i++){
            String temp = list.get(i);

            if(temp.contains("X")){
                if(temp.length() % 2 == 0){
                    int val = temp.length() / 4;
                    if(val > 0){
                        for(int j = 0; j < val; j++){
                            strResult += "AAAA";
                        }
                        if(!(temp.length() % 4 == 0)){
                            strResult += "BB";
                        }
                    }
                    else{
                        strResult += "BB";
                    }

                }
                else{
                    result = -1;
                    break;
                }

            }
            else if(temp.contains(".")){
                strResult += temp;
            }
        }

        if(result == -1){
            System.out.println(result);
        }
        else{
            System.out.println(strResult);
        }

    }

}