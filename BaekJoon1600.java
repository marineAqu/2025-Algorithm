import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Next {
    int x, y;

    Next(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BaekJoon1600 {
    static int map[][], w, h, k;
    static int minCount = Integer.MAX_VALUE - 1;
    static PriorityQueue<Next> queue = new PriorityQueue<>((o1, o2) -> (o1.x+o1.y) - (o2.x+o2.y));
    static int visited[][][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new int[h][w][k+1]; // 마지막은 k 사용 횟수

        // map
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());

            for (int q = 0; q < w; q++) {
                map[i][q] = Integer.parseInt(st.nextToken());
                for(int e=0; e<=k; e++) visited[i][q][e] = Integer.MAX_VALUE - 1;
            }
        }

        visited[0][0][0] = 0;

        queue.add(new Next(0, 0));
        while (!queue.isEmpty()) {
            Next next = queue.poll();

            for(int i=0; i<=k; i++) dfs(next.x, next.y, i);
        }

        for(int i=0; i<=k; i++){
            minCount = Math.min(minCount, visited[h-1][w-1][i]);
        }

        // 인접한 한 칸으로 가거나, 말처럼(+2칸, +1칸) k번 움직이거나
        if (minCount == Integer.MAX_VALUE - 1)
            System.out.print(-1);
        else
            System.out.print(minCount);
    }


    public static void dfs(int x, int y, int hc) {
            if (hc < k) {
                if (x + 2 < w && y + 1 < h && map[y + 1][x + 2] == 0 && visited[y+1][x+2][hc+1] > visited[y][x][hc] + 1) {
                    visited[y+1][x+2][hc+1] = visited[y][x][hc] + 1;
                    queue.add(new Next(x+2, y+1));
                }

                if (x + 1 < w && y + 2 < h && map[y + 2][x + 1] == 0 && visited[y+2][x+1][hc+1] > visited[y][x][hc] + 1) {
                    visited[y+2][x+1][hc+1] = visited[y][x][hc] + 1;
                    queue.add(new Next(x+1, y+2));
                }

                if (x - 1 >= 0 && y + 2 < h && map[y + 2][x - 1] == 0 && visited[y+2][x-1][hc+1] > visited[y][x][hc] + 1) {
                    visited[y+2][x-1][hc+1] = visited[y][x][hc] + 1;
                    queue.add(new Next(x-1, y+2));
                }

                if (x - 2 >= 0 && y + 1 < h && map[y + 1][x - 2] == 0 && visited[y+1][x-2][hc+1] > visited[y][x][hc] + 1) {
                    visited[y+1][x-2][hc+1] = visited[y][x][hc] + 1;
                    queue.add(new Next(x-2, y+1));
                }

                if (x - 2 >= 0 && y - 1 >= 0 && map[y - 1][x - 2] == 0 && visited[y-1][x-2][hc+1] > visited[y][x][hc] + 1) {
                    visited[y-1][x-2][hc+1] = visited[y][x][hc] + 1;
                    queue.add(new Next(x-2, y-1));
                }

                if (x - 1 >= 0 && y - 2 >= 0 && map[y - 2][x - 1] == 0 && visited[y-2][x-1][hc+1] > visited[y][x][hc] + 1) {
                    visited[y-2][x-1][hc+1] = visited[y][x][hc] + 1;
                    queue.add(new Next(x-1, y-2));
                }

                if (x + 1 < w && y - 2 >= 0 && map[y - 2][x + 1] == 0 && visited[y-2][x+1][hc+1] > visited[y][x][hc] + 1) {
                    visited[y-2][x+1][hc+1] = visited[y][x][hc] + 1;
                    queue.add(new Next(x+1, y-2));
                }

                if (x + 2 < w && y - 1 >= 0 && map[y - 1][x + 2] == 0 && visited[y-1][x+2][hc+1] > visited[y][x][hc] + 1) {
                    visited[y-1][x+2][hc+1] = visited[y][x][hc] + 1;
                    queue.add(new Next(x+2, y-1));
                }
            }

            if (x - 1 >= 0 && map[y][x - 1] == 0 && visited[y][x-1][hc] > visited[y][x][hc] + 1) {
                visited[y][x-1][hc] = visited[y][x][hc] + 1;
                queue.add(new Next(x-1, y));
            }

            if (y - 1 >= 0 && map[y - 1][x] == 0 && visited[y-1][x][hc] > visited[y][x][hc] + 1) {
                visited[y-1][x][hc] = visited[y][x][hc] + 1;
                queue.add(new Next(x, y-1));
            }

            if (x + 1 < w && map[y][x + 1] == 0 && visited[y][x+1][hc] > visited[y][x][hc] + 1) {
                visited[y][x+1][hc] = visited[y][x][hc] + 1;
                queue.add(new Next(x+1, y));
            }

            if (y + 1 < h && map[y + 1][x] == 0 && visited[y+1][x][hc] > visited[y][x][hc] + 1) {
                visited[y+1][x][hc] = visited[y][x][hc] + 1;
                queue.add(new Next(x, y+1));
            }
    }
}
