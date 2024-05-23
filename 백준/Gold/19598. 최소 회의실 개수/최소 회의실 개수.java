import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        int start, end;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            arr[i][0] = start;
            arr[i][1] = end;
        }

        Arrays.sort(arr, Comparator.comparingInt(value -> value[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(arr[0][1]);
        for(int i = 1; i < N; i++){
            if(pq.peek() <= arr[i][0]){
                pq.poll();
            }
            pq.offer(arr[i][1]);
        }

        System.out.println(pq.size());
    }
}