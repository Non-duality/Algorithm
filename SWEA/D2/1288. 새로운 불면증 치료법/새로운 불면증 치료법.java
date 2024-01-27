import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			
			String N = br.readLine();
			int initNum = Integer.parseInt(N);
			int nextNum = 0;
			int visit = 0;
			int count = 0;
			while( !(visit == (1<<10)-1) ) {
				
				for(int i = 0; i < N.length(); i++) {
					visit = visit | (1 << (N.charAt(i) - '0'));
				}
				
				int Nnum = Integer.parseInt(N);
				nextNum += initNum;
				N = nextNum + "";
				count ++;
				
			}
			
			sb.append("#").append(t).append(" ").append(nextNum - initNum).append("\n");
			
		}
		
		System.out.println(sb.toString());
	}

}