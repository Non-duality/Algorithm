import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		HashMap<Integer, Integer> map = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		int sum;
		int cnt = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {

				sum = arr[i] + arr[j];

				if (map.containsKey(sum)) {
					// 0이 3개 이상일 경우
					if (sum == 0 && map.get(sum) >= 3) {
						cnt += map.get(sum);
						map.remove(sum);
						continue;
					}
					else if(sum == 0 && arr[i] != 0 && arr[j] != 0) {
						cnt += map.get(sum);
						map.remove(sum);
						continue;
					}
					else if(sum == 0 && map.get(sum) < 3){
						continue;
					}
					
					// 하나가 0일 때
					if (sum != 0 && (arr[i] == 0 || arr[j] == 0) && map.get(sum) >= 2) {
						cnt += map.get(sum);
						map.remove(sum);
						continue;
					} 
					else if(sum != 0 && (arr[i] == 0 || arr[j] == 0) && map.get(sum) < 2) {
						continue;
					}

					cnt += map.get(sum);
					map.remove(sum);

				}
			}
		}

		System.out.println(cnt);

	}
}
