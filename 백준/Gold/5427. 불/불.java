import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int W, H, time;
	static char[][] map;
	static boolean check;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = { 0, 0,-1, 1};
	static Queue<int[]> hq;
	static Queue<int[]> fq;
	// 벽에는 불이 붙지 않는다.
	// 불, 상근이 동 서 남 북 1초
	// 상근이는 불이 옮겨진 칸 or 이제 불이 붙으려는 칸으로 이동 불가
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			
			hq = new ArrayDeque<>();
			fq = new ArrayDeque<>();
			
			for(int i = 0; i < H; i++) {
				String temp = br.readLine();
				for(int j = 0; j < W; j++) {
					map[i][j] = temp.charAt(j);
					
					if(map[i][j] == '@') {
						hq.offer(new int[] {i, j});
					}
					
					else if(map[i][j] == '*') {
						fq.offer(new int[] {i, j});
					}
				}
			}
			
			time = 0;
			check = true;
			while(check) {
				time ++;
				fire();
				human();
				if(hq.isEmpty() && fq.isEmpty()) {
					break;
				}
			}
			
			if(!check) {
				sb.append(time).append("\n");
			}
			
			else {
				sb.append("IMPOSSIBLE").append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	
	static void fire() {
		Queue<int[]> temp = new ArrayDeque<>();

		while (!fq.isEmpty()) {
			int[] current = fq.poll();
			int r = current[0];
			int c = current[1];

			int nr, nc;
			for (int d = 0; d < 4; d++) {
				nr = r + dr[d];
				nc = c + dc[d];

				if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
					continue;
				}

				if (map[nr][nc] == '#') {
					continue;
				}

				if (map[nr][nc] == '*') {
					continue;
				}

				temp.offer(new int[] { nr, nc });
				map[nr][nc] = '*';
			}
		}

		while (!temp.isEmpty()) {
			fq.offer(temp.poll());
		}
	}


	static void human() {
		Queue<int[]> temp = new ArrayDeque<>();

		while (!hq.isEmpty()) {
			int[] current = hq.poll();
			int r = current[0];
			int c = current[1];

			int nr, nc;
			for (int d = 0; d < 4; d++) {
				nr = r + dr[d];
				nc = c + dc[d];

				if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
					check = false;
					continue;
				}

				if (map[nr][nc] == '#') {
					continue;
				}

				if (map[nr][nc] == '*') {
					continue;
				}

				if (map[nr][nc] == '@') {
					continue;
				}

				temp.offer(new int[] { nr, nc });
				map[nr][nc] = '@';
			}
		}

		while (!temp.isEmpty()) {
			hq.offer(temp.poll());
		}
	}

}
