import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 웅덩이 정보 갯수
        int L = Integer.parseInt(st.nextToken()); // 널빤지 길이

        // 웅덩이 정보 pq에 집어 넣기 (첫 웅덩이 시작위치 순으로 집어 넣기 위해)
        Queue<Pool> pq = new PriorityQueue<>();

        int start, end;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            pq.offer(new Pool(start, end));
        }

        int count = 0;
        int lastPos = 0;
        while(!pq.isEmpty()){
            Pool cntPool = pq.poll();

            if(cntPool.end < lastPos){
                continue;
            }

            if(cntPool.start > lastPos){
                lastPos = cntPool.start;
            }

            int remain = (cntPool.end - lastPos) % L;
            count += (cntPool.end - lastPos) / L;
            lastPos = cntPool.end;
            if(remain != 0){
                count ++;
                lastPos += L - remain;
            }

        }

        System.out.println(count);

    }
}

class Pool implements Comparable<Pool> {
    int start;
    int end;

    Pool(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Pool o) {
        if(this.start == o.start){
            return o.end - this.start;
        }
        return this.start - o.start;
    }
}