import java.util.*;

public class Main {

    public static int minClassroomsRequired(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort the intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Use a priority queue to track the minimum end time of overlapping intervals
        PriorityQueue<Integer> endTimePQ = new PriorityQueue<>();

        // Add the end time of the first interval
        endTimePQ.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // If the current interval starts after the earliest end time, reuse that room
            if (intervals[i][0] >= endTimePQ.peek()) {
                endTimePQ.poll();
            }

            // Add the end time of the current interval
            endTimePQ.add(intervals[i][1]);
        }

        // The size of the priority queue is the number of rooms needed
        return endTimePQ.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        System.out.println(minClassroomsRequired(intervals));
        sc.close();
    }
}