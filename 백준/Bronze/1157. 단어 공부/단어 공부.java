import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		temp = temp.toUpperCase();
		
		int[] arr = new int[91];
		for(int i = 0; i < temp.length(); i++) {
			arr[temp.charAt(i)] += 1;
		}
		int max = -1;
		int cnt = 0;
		int idx = -1;
		for(int i = 65; i < 91; i++) {
			if(max < arr[i]) {
				max = arr[i];
				idx = i;
			}
		}
		
		char result = (char)idx;
		for(int i = 65; i < 91; i++) {
			if(i == idx) {
				continue;
			}
			if(max == arr[i]) {
				result = '?';
				break;
			}
		}
		
		System.out.println(result);
		
	}

}
