import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.ArrayDeque;

import java.util.Queue;

import java.util.*;

public class Main {

		private static int N;

	private static int[][] map;

	private static List<int[]> posList;

	private static boolean[][] visited;

	private static int[] dr = {-1, 1, 0, 0};

    private static int[] dc = { 0, 0,-1, 1};

    

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		

		N = Integer.parseInt(br.readLine());

		

		map = new int[N][N];

		posList = new ArrayList<>();

		

		for(int i = 0; i < N; i++){

			String temp = br.readLine();

			for(int j = 0; j < N; j++){

				map[i][j] = temp.charAt(j) - '0';

				

				if(map[i][j] == 1){

					posList.add(new int[] {i, j});

				}

			}

		}

		

		visited = new boolean[N][N];

		List<Integer> list = new ArrayList<>();

		

		for(int[] pos : posList){

			int r = pos[0];

			int c = pos[1];

			

			if(visited[r][c]){

				continue;

			}

			

			int size = BFS(r, c);

			list.add(size);

		}

		

		Collections.sort(list);

		

		System.out.println(list.size());

		for(int val : list){

			System.out.println(val);

		}

		

	}

	

	private static int BFS(int r, int c) {

		Queue<int[]> dq = new ArrayDeque<>();

		

		dq.offer(new int[] {r, c});

		visited[r][c] = true;

		

		int size = 1;

		while(!dq.isEmpty()){

			int[] curr = dq.poll();

			

			for(int d = 0; d < 4; d++){

				int nr = curr[0] + dr[d];

				int nc = curr[1] + dc[d];

				

				if(nr < 0 || nr >= N || nc < 0 || nc >= N){

					continue;

				}

				

				if(visited[nr][nc]){

					continue;

				}

				

				if(map[nr][nc] == 0){

					continue;

				}

				

				size ++;

				visited[nr][nc] = true;

				dq.offer(new int[] {nr, nc});

			}

		}

		

		return size;

	}

}