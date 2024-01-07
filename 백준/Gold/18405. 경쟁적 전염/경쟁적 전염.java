import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Virus implements Comparable<Virus> {
		
		int num; // 바이러스 번호
		int r, c; // 좌표
		
		public Virus(int num, int r, int c) {
			this.num = num;
			this.r = r;
			this.c = c;
		}

		public int compareTo(Virus o) {
			return this.num - o.num;
		}
		
	}
	
	
	static int N, K; // 시험관의 크기, 바이러스의 종류
	static int S, X, Y; // 초, 위치x, 위치 y
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = { 0, 0,-1, 1}; 
	static PriorityQueue<Virus> pq;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 시험관 정보 입력
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 바이러스를 우선순위 큐에 집어넣기
				if(map[i][j] != 0) {
					pq.offer(new Virus(map[i][j], i, j));
				}
			}
		}
		
		
		// 시간, 좌표 값
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		BFS();
		System.out.println(map[X-1][Y-1]);
		
	}

	static void BFS() {
		Queue<Virus> tq = new ArrayDeque<>();
		int nr, nc;
		Virus cntVirus;
		
		for(int i = 0 ; i < S; i++) {
			// 바이러스 대기열 채워넣기
			while(!tq.isEmpty()) {
				pq.offer(tq.poll());
			}
			
			// 바이러스 퍼뜨리기
			while(!pq.isEmpty()) {
				
				cntVirus = pq.poll();
				for(int d = 0; d < 4; d++) {
					nr = cntVirus.r + dr[d]; 
					nc = cntVirus.c + dc[d];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
						continue;
					}
					
					if(map[nr][nc] != 0) {
						continue;
					}
					
					map[nr][nc] = cntVirus.num;
					tq.offer(new Virus(cntVirus.num, nr, nc));
				}
			}
			
		}
		
	}
	
}