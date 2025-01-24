import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> map = new TreeMap<>();
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				char temp = st.nextToken().charAt(0);

				if (temp == 'I') {
					int num = Integer.parseInt(st.nextToken());
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else {
					if (map.size() == 0)
						continue;
					int type = Integer.parseInt(st.nextToken());
					int num;
					if (type == 1) { // 최댓값 삭제
						num = map.lastKey();
					} else { // 최솟값 삭제
						num = map.firstKey();
					}
					if (map.put(num, map.get(num) - 1) == 1) {
						map.remove(num);
					}
				}
			}
			
            if (map.size()==0) {
	            System.out.println("EMPTY");
	        } else {
	        	System.out.println(map.lastKey()+ " " + map.firstKey());
	        }

		}
		

		}

	}


