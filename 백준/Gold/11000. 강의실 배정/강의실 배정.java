import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class ClassInfo{
        private int start;
        private int end;

        public ClassInfo(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        List<ClassInfo> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new ClassInfo(start, end));
        }

        list.sort(((o1, o2) -> {
            if(o1.start == o2.start){
                return Integer.compare(o1.end, o2.end);
            }
            else{
                return Integer.compare(o1.start, o2. start);
            }
        }));

        PriorityQueue<Integer> endTimePQ = new PriorityQueue<>();
        endTimePQ.add(list.get(0).end);

        int length = list.size();
        for(int i = 1; i < length; i++){
            if(endTimePQ.peek() <= list.get(i).start){
                endTimePQ.poll();
            }

            endTimePQ.add(list.get(i).end);
        }

        System.out.println(endTimePQ.size());
    }
}