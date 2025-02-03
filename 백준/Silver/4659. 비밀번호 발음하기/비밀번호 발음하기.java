import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String pass = " is acceptable.";
        String block = " is not acceptable.";
        String str = "";
        while(!(str = br.readLine()).equals("end")){
            int vow = 0;
            int cons = 0;
            boolean acceptable = false;

            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);

                if("aeiou".contains(ch+"")){
                    acceptable = true;
                    vow++;
                    cons = 0;

                    if(vow > 2){
                        acceptable = false;
                        break;
                    }
                }
                else{
                    vow = 0;
                    cons++;
                    if(cons > 2){
                        acceptable = false;
                        break;
                    }
                }


                if(i != 0){
                    char prev = str.charAt(i - 1);
                    if(prev == ch){
                        if(!"eo".contains(ch+"")) {
                            acceptable = false;
                            break;
                        }
                    }
                }

            }

            sb.append("<").append(str).append(">");
            if(acceptable) sb.append(pass);
            else sb.append(block);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}