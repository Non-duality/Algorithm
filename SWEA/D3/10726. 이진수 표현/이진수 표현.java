import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int temp = M & ( (1 << N) - 1);
			
			sb.append("#").append(t).append(" ");
			if(temp == ((1 << N) - 1)) {
				sb.append("ON").append("\n");
			}else {
				sb.append("OFF").append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}