import java.util.*;

class Node {
    int x, y, broken, dist;
    Node(int x, int y, int broken, int dist) {
        this.x = x;
        this.y = y;
        this.broken = broken;
        this.dist = dist;
    }
}

public class Main {
    public static int shortestPath(int N, int M, int K, int[][] grid) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        boolean[][][] visited = new boolean[N][M][K + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (node.x == N - 1 && node.y == M - 1) {
                return node.dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (grid[nx][ny] == 0 && !visited[nx][ny][node.broken]) {
                        queue.add(new Node(nx, ny, node.broken, node.dist + 1));
                        visited[nx][ny][node.broken] = true;
                    }
                    
                    if (grid[nx][ny] == 1 && node.broken < K && !visited[nx][ny][node.broken + 1]) {
                        queue.add(new Node(nx, ny, node.broken + 1, node.dist + 1));
                        visited[nx][ny][node.broken + 1] = true;
                    }
                }
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        int[][] grid = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = scanner.next();
            for (int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }
        
        int result = shortestPath(N, M, K, grid);
        System.out.println(result);
    }
}