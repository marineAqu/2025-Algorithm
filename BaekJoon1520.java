import java.io.*;
import java.util.*;

class Point{
    int x, y, val;
    Point(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

public class BaekJoon1520 {
    public static void main(String args[]) throws IOException {
        PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> o2.val - o1.val);

        //내리막을 통해서만 가는 경우의 개수

        //그럼 a에서 c로 갈 때, a에서 b로 가는 개수 * b에서 c로 가는 개수를 구하면 a에서 c로 가는 개수.
        //근데 빙빙 도는 경우는 존재할 수 없다. 더 낮은 지점으로만 이동하니까 (같은거 ㄴ)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nextx[] = {0, 0, -1, 1};
        int nexty[] = {1, -1, 0, 0};

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int map[][] = new int[m][n];
        long dp[][] = new long[m][n];
        boolean visited[][] = new boolean[m][n];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            for(int r=0; r<n; r++){
                map[i][r] = Integer.parseInt(st.nextToken());
            }
        }

        queue.add(new Point(0, 0, map[0][0]));

        //큐 정렬은 오름차로

        Point now;
        dp[0][0] = 1;

        while(!queue.isEmpty()){
            now = queue.poll();
            
            if(visited[now.y][now.x]) continue;
            visited[now.y][now.x] = true;
            for(int i=0; i<4; i++){
                if(now.x+nextx[i] < 0 || now.x+nextx[i] >= n ||
                    now.y+nexty[i] < 0 || now.y+nexty[i] >= m) continue;

                if(map[now.y+nexty[i]][now.x+nextx[i]] < map[now.y][now.x]){
                    dp[now.y+nexty[i]][now.x+nextx[i]] += dp[now.y][now.x];
                    queue.add(new Point(now.x+nextx[i], now.y+nexty[i], map[now.y+nexty[i]][now.x+nextx[i]]));
                }
            }
        }

        System.out.print(dp[m-1][n-1]);
    }
}

//나보다 큰 애들 계산이 이미 다 끝나있어야함