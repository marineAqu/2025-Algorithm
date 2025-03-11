import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int map[][] = new int[n][n];
        int dp[][] = new int[n][n];

        StringTokenizer st;

        //PriorityQueue<XY> queue = new PriorityQueue<>((o1, o2) -> {if(o1.y == o2.y){return o1.x - o2.x;} else return o1.y - o2.y;});

        //값 입력
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int t=0; t<i+1; t++){
                map[i][t] = Integer.parseInt(st.nextToken());
            }
        }

        //queue.add(new XY(0, 0));
        dp[0][0] = map[0][0];

        for(int i=1; i<n; i++){
            for(int t=0; t<i+1; t++){
                if(t == i) dp[i][t] = dp[i-1][t-1] + map[i][t];
                else if(t == 0) dp[i][t] = dp[i-1][t] + map[i][t];
                else dp[i][t] = Math.max(dp[i-1][t-1], dp[i-1][t]) + map[i][t];
            }
        }

        //내가 내 다음단계를 계산하는 게 아니라 내가 내 위를 확인하고 계산하도록 해서 메모리초과 해결,,, 될까
        /*
        while (!queue.isEmpty()) {
            XY now = queue.poll();

            if(now.y == n-1) continue;

            dp[now.y+1][now.x] = Math.max(dp[now.y+1][now.x], dp[now.y][now.x] + map[now.y+1][now.x]);
            dp[now.y+1][now.x+1] = Math.max(dp[now.y+1][now.x+1], dp[now.y][now.x] + map[now.y+1][now.x+1]);

            queue.add(new XY(now.x, now.y + 1));
            queue.add(new XY(now.x + 1, now.y + 1));
        }
        */

        int maxV = 0;
        for(int i=0; i<n; i++) maxV = Math.max(maxV, dp[n-1][i]);

        System.out.println(maxV);
    }
}
