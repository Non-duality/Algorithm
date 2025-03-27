import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String S;
    private static boolean possible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        String T = br.readLine();

        DFS(T);

        if(possible) System.out.println(1);
        else System.out.println(0);
    }

    private static void DFS(String current){

        if(possible) return;

        if(current.length() == S.length()){
            if(current.equals(S)){
                possible = true;
            }
            return;
        }

        if(current.length() < S.length()){
            return;
        }

        if(current.endsWith("A")){
            String newStr = current.substring(0, current.length() -1);
            DFS(newStr);
        }

        if(current.startsWith("B")){
            String remaining = current.substring(1);
            String reversed = new StringBuilder(remaining).reverse().toString();
            DFS(reversed);
        }

    }
}