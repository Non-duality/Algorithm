import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int CABBAGE_PRESENT = 1;
    private static final int[] ROW_MOVEMENT = {-1, 1, 0, 0};
    private static final int[] COL_MOVEMENT = {0, 0, -1, 1};

    private static int numberOfRows, numberOfColumns;
    private static int[][] field;
    private static boolean[][] visited;

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int testCases = Integer.parseInt(reader.readLine());

            for (int tc = 0; tc < testCases; tc++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                numberOfColumns = Integer.parseInt(st.nextToken());
                numberOfRows = Integer.parseInt(st.nextToken());
                int numberOfCabbages = Integer.parseInt(st.nextToken());

                field = new int[numberOfRows][numberOfColumns];
                visited = new boolean[numberOfRows][numberOfColumns];

                for (int i = 0; i < numberOfCabbages; i++) {
                    st = new StringTokenizer(reader.readLine());
                    int column = Integer.parseInt(st.nextToken());
                    int row = Integer.parseInt(st.nextToken());
                    field[row][column] = CABBAGE_PRESENT;
                }

                System.out.println(countCabbageGroups());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countCabbageGroups() {
        int result = 0;
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                if (field[row][column] == CABBAGE_PRESENT && !visited[row][column]) {
                    exploreField(row, column);
                    result++;
                }
            }
        }
        return result;
    }

    private static void exploreField(int row, int column) {
        if (visited[row][column]) {
            return;
        }

        visited[row][column] = true;

        for (int direction = 0; direction < 4; direction++) {
            int newRow = row + ROW_MOVEMENT[direction];
            int newColumn = column + COL_MOVEMENT[direction];

            if (isInField(newRow, newColumn) && field[newRow][newColumn] == CABBAGE_PRESENT) {
                exploreField(newRow, newColumn);
            }
        }
    }

    private static boolean isInField(int row, int column) {
        return row >= 0 && row < numberOfRows && column >= 0 && column < numberOfColumns;
    }
}