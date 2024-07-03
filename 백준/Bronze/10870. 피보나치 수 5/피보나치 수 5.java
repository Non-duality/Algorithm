import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static long[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new long[N+2];
		arr[0] = 0;
		arr[1] = 1;
		
		long result = 0;
		if(N == 0) {
			result = 0;
		}
		// 짝수 일 때
		else if(N % 2 == 0) {
			result = fibo(N/2) * fibo(N/2) + 2 * fibo(N/2) * fibo((N/2)-1);
		}
		
		// 홀수 일 때
		else if (N % 2 == 1){
			result = fibo((N-1) / 2 + 1) * fibo((N-1) / 2 + 1) + fibo((N-1) / 2) * fibo((N-1) / 2);
		}
		
		System.out.println(result);
	}
	
	static long fibo(int n) {
		
		for(int i = 2; i < n + 1; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		return arr[n];
	}

}
