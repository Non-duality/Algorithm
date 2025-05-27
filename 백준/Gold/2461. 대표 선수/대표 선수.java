import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static class Student {
        int ablity;
        int number;

        public Student(int ablity, int number){
            this.ablity = ablity;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학급 수
        int M = Integer.parseInt(st.nextToken()); // 학생 수

        Student[] list = new Student[N*M];

        int idx = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                list[idx] = new Student(Integer.parseInt(st.nextToken()), i);
                idx ++;
            }
        }

        Arrays.sort(list, ((o1, o2) -> o1.ablity - o2.ablity));

        int left = 0, right = 0;
        int[] classCount = new int[N];
        int count = 0;
        int min = Integer.MAX_VALUE;

        while(right < idx){
            Student cur = list[right];

            if(classCount[cur.number] == 0){
                count++;
            }
            classCount[cur.number]++;

            while(count == N){
                int diff = list[right].ablity - list[left].ablity;
                min = Math.min(min, diff);

                classCount[list[left].number] --;
                if(classCount[list[left].number] == 0){
                    count --;
                }

                left++;
            }
            right++;
        }

        System.out.println(min);
    }
}