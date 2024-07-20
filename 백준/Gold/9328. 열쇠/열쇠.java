import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int H, W;
    private static String[][] map;
    private static int[] haveKey;
    private static List<int[]> startList;
    private static List<int[]> tempDoorList;

    private static String doors = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String keys = "abcdefghijklmnopqrstuvwxyz";

    private static boolean[][] visited;
    private static boolean[][] check;
    private static ListIterator<int[]> iterator;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = { 0, 0,-1, 1};

    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            // 빌딩 정보 담기
            map = new String[H][W];
            String temp;
            for(int i = 0; i < H; i++){
                temp = br.readLine();
                map[i] = temp.split("");
            }

            haveKey = new int[26];
            Arrays.fill(haveKey, -1);

            // 가지고 있는 키 정보 담기
            temp = br.readLine();
            if(!temp.equals("0")){
                int size = temp.length();
                for(int i = 0; i < size; i++){
                    char key = temp.charAt(i);
                    haveKey[key - 'a'] = 1;
                }
            }

            // 출발지 위치 정보 담기
            startList = new ArrayList<>();
            tempDoorList = new ArrayList<>();
            check = new boolean[H][W];
            count = 0;
            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    // 가장자리에 출발지가 있는지 확인
                    if(i == 0 || i == H - 1 || j == 0 || j == W - 1){

                        // 벽일 경우
                        if(map[i][j].equals("*")){
                            continue;
                        }

                        // 빈 공간일 경우
                        else if(map[i][j].equals(".")){
                            startList.add(new int[] {i, j});
                        }

                        // 문일 경우
                        else if(doors.contains(map[i][j])){
                            // 키가 있는지 확인
                            String key = map[i][j].toLowerCase();
                            if(haveKey[key.charAt(0) - 'a'] == 1){
                                startList.add(new int[] {i, j});
                            } else{
                                tempDoorList.add(new int[] {i, j});
                            }
                        }

                        // 키일 경우
                        else if(keys.contains(map[i][j])){
                            //키 획득 후 출발 위치 추가
                            haveKey[map[i][j].charAt(0) - 'a'] = 1;
                            startList.add(new int[] {i, j});

                            Iterator<int[]> iterator2 = tempDoorList.iterator();
                            while(iterator2.hasNext()){
                                int[] pos = iterator2.next();
                                String door = map[pos[0]][pos[1]];

                                if(door.toLowerCase().equals(map[i][j])){
                                    startList.add(new int[] {pos[0], pos[1]});
                                    iterator2.remove();
                                }
                            }

                        }

                        // 문서일 경우
                        else if(map[i][j].equals("$")){
                            count ++;
                            check[i][j] = true;
                            startList.add(new int[] {i, j});
                        }

                    }

                }
            }

            // 출발지로 부터 문서 획득 시작
            iterator = startList.listIterator();
            visited = new boolean[H][W];
            while(iterator.hasNext()){
                int[] cur = iterator.next();
                getDocument(cur);
            }
            System.out.println(count);
        }
    }

    private static void getDocument(int[] start){

        Queue<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {start[0], start[1]});
        visited[start[0]][start[1]] = true;

        while(!dq.isEmpty()){
            int[] cur = dq.poll();

            for(int d = 0; d < 4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                // 범위를 벗어나거나 방문한 곳인 경우
                if(nr < 0 || nr >= H || nc < 0 || nc >= W || visited[nr][nc]){
                    continue;
                }

                // 벽일 경우
                if(map[nr][nc].equals("*")){
                    continue;
                }

                // 문일 경우
                if(doors.contains(map[nr][nc])){
                    // 키가 있는지 확인
                    String key = map[nr][nc].toLowerCase();
                    if(haveKey[key.charAt(0) - 'a'] == 1){
                        visited[nr][nc] = true;
                        dq.offer(new int[] {nr, nc});
                        continue;
                    }
                    else {
                        tempDoorList.add(new int[] {nr, nc});
                        continue;
                    }
                }

                // 키일 경우
                if(keys.contains(map[nr][nc])){

                    // 획득한 키라면
                    if(check[nr][nc]){
                        visited[nr][nc] = true;
                        dq.offer(new int[] {nr, nc});
                        continue;
                    }
                    // 획득하지 않은 키라면
                    else{
                        // 키 획득
                        haveKey[map[nr][nc].charAt(0) - 'a'] = 1;

                        Iterator<int[]> iterator2 = tempDoorList.iterator();
                        while(iterator2.hasNext()){
                            int[] pos = iterator2.next();
                            String door = map[pos[0]][pos[1]];

                            if(door.toLowerCase().equals(map[nr][nc])){
                                startList.add(new int[] {pos[0], pos[1], 0});
                                iterator = startList.listIterator();
                                iterator2.remove();
                            }
                        }

                        visited = new boolean[H][W];
                        check[nr][nc] = true;
                        visited[nr][nc] = true;
                        dq.offer(new int[] {nr, nc});
                        continue;
                    }

                }

                // 문서일 경우
                if(map[nr][nc].equals("$")){

                    // 획득한 문서라면
                    if(check[nr][nc]){
                        visited[nr][nc] = true;
                        dq.offer(new int[] {nr, nc});
                        continue;
                    }
                    // 획득하지 않은 문서라면
                    else{
                        count ++;
                        check[nr][nc] = true;
                        visited[nr][nc] = true;
                        dq.offer(new int[] {nr, nc});
                        continue;
                    }
                }

                visited[nr][nc] = true;
                dq.offer(new int[] {nr, nc });

            }
        }
    }
}