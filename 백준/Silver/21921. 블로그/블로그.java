import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int tempVisit = 0;
        for(int i = 0; i < X; i++){
            tempVisit += arr[i];
        }

        int maxVisit = tempVisit;
        int count = 1;
        for(int i = X; i < N; i++){
            tempVisit += arr[i] - arr[i - X];

            if(maxVisit == tempVisit){
                count++;
            }

            else if(maxVisit < tempVisit){
                maxVisit = tempVisit;
                count = 1;
            }

        }

        if(maxVisit == 0){
            System.out.println("SAD");
        }
        else{
            System.out.println(maxVisit);
            System.out.println(count);
        }

    }
}