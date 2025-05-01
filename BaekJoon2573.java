import java.io.*;
import java.util.*;

class Point {
    int x, y;

    Point(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

public class BaekJoon2573 {
    static Queue<Point> queue = new LinkedList<>();
    static int n, m, answer = 0, map[][], count = 0, time = 0, around[][];
    static LinkedList<Point> list = new LinkedList<>();
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        around = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int r = 0; r < m; r++) {
                map[i][r] = Integer.parseInt(st.nextToken());
                if (map[i][r] != 0)
                    list.add(new Point(i, r));
            }
        }

        while (true) {
            for(int i=0; i<n; i++) Arrays.fill(visited[i], false);

            count = 0;
            countArea();

            //영역이 2개라면 정지
            if(count >= 2) break;

            //영역이 2개 이하가 된 경우
            else if(count == 0) {
                System.out.print("0");
                System.exit(0);
            }

            bfsCalc();
            time++;
        }

        System.out.print(time);

        // 계산
        // 하나씩 계산하는 게 아니라 동시에 줄어야한다. (옆에 게 먼저 없어지는 바람에 -2해야할게 -3되어버릴까봐)
        // around에 0인 개수 저장해두고 빼기. 또 map udate하기
        // 그다음에 around 업데이트 및 영역 확인하기
    }

    //영역 몇개인지 체크(BFS)
    static void countArea() {
        for (int i =0; i<n; i++) {
            for (int r=0; r<m; r++) {
                if (!visited[i][r] && map[i][r] != 0) {
                    visited[i][r] = true;
                    count++;
                    
                    checkAround(new Point(i, r));

                    while (!queue.isEmpty()) {
                        checkAround(queue.poll());
                    }
                }
            }
        }
    }

    //해당 빙하 주변에 물이 몇 면 있는지 확인하고 저장
    static void checkAround(Point now) {
        int c = 0;
        for (int i = 0; i<4; i++) {
            if (now.y + dy[i] < 0 || now.y + dy[i] >= n || now.x + dx[i] < 0 || 
            now.x + dx[i] >= m || visited[now.y + dy[i]][now.x + dx[i]]) continue;
                
            if(map[now.y + dy[i]][now.x + dx[i]] == 0) c++;
            else {
                visited[now.y + dy[i]][now.x + dx[i]] = true;
                queue.add(new Point(now.y + dy[i], now.x + dx[i]));
            }
        }

        around[now.y][now.x] = c;
    }

    static void bfsCalc() {
        for (Point now : list) {
            map[now.y][now.x] -= around[now.y][now.x];
            if (map[now.y][now.x] < 0) map[now.y][now.x] = 0;
        }
    }
}
