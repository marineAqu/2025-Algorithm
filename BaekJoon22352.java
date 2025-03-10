import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon22352 {
    static int map[][], update[][], n, m, diffNum;
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        update = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int t = 0; t < m; t++) {
                map[i][t] = Integer.parseInt(st.nextToken());
            }

            // 즉 영역 하나 전체가 새로운 값으로 업데이트 되었는지 확인해야 한다
            // 그러면 영역별 대표값 하나씩을 리스트에 저장해두고, 업데이트맵에서 다른 부분 좌표 저장해두고
        }

        int x = -1, y = -1;
        // 업데이트 맵
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int t = 0; t < m; t++) {
                update[i][t] = map[i][t] - Integer.parseInt(st.nextToken());

                if (x == -1 && update[i][t] != 0) {
                    x = t;
                    y = i;
                    diffNum = update[i][t];
                }
            }
        }

        // update[i][t] != 0인 곳을 탐색하기.
        // update에서 업데이트된 값이 모두 같아야하고
        // + 하나의 영역이어야하며 (영역중 덜 칠하거나 더 칠해지면 안됨)
        // 다른 먼 영역 중 업데이트된 영역이 있으면 안 된다.

        // dfs로 하나의 영역이 맞는지 검사. 방문한 곳은 update[i][t] = 0 해주고,
        // 마지막으로 update 전체검사하며 0이 아닌 곳 있으면 NO

        // diffNum... 으로 체크하면 원래 2->1로 변하는게맞는데 3->2로 바뀐 경우도 O라고 체크하게됨
        // 덜칠한 경우 체크가 안된다 어떻게 체크해야할까.... -> update로 dfs하지말고 map으로

        if (x == -1) {
            System.out.println("YES");
            return;
        }

        update[y][x] = 0;
        visited[y][x] = true;
        dfs(y, x);

        for (int i = 0; i < n; i++) {
            for (int t = 0; t < m; t++) {
                if (update[i][t] != 0) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }

    static void dfs(int y, int x) {
        if (x - 1 >= 0 && map[y][x - 1] == map[y][x] && visited[y][x-1] == false) {
            visited[y][x-1] = true;

            if (update[y][x - 1] == diffNum) {
                update[y][x - 1] = 0;
                dfs(y, x - 1);
            }

            else {
                System.out.println("NO");
                System.exit(0);
            }
        }

        if (y - 1 >= 0 && map[y - 1][x] == map[y][x] && visited[y-1][x] == false) {
            visited[y-1][x] = true;

            if (update[y - 1][x] == diffNum) {
                update[y - 1][x] = 0;
                dfs(y - 1, x);
            }

            else {
                System.out.println("NO");
                System.exit(0);
            }
        }

        if (x + 1 < m && map[y][x + 1] == map[y][x] && visited[y][x+1] == false) {
            visited[y][x+1] = true;

            if (update[y][x + 1] == diffNum) {
                update[y][x + 1] = 0;
                dfs(y, x + 1);
            }

            else {
                System.out.println("NO");
                System.exit(0);
            }
        }

        if (y + 1 < n && map[y + 1][x] == map[y][x] && visited[y+1][x] == false) {
            visited[y+1][x] = true;

            if (update[y + 1][x] == diffNum) {
                update[y + 1][x] = 0;
                dfs(y + 1, x);
            }

            else {
                System.out.println("NO");
                System.exit(0);
            }
        }
    }
}
