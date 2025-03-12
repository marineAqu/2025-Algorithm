import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon2096 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        //DP같은데 메모리 제한때문에 한꺼번에 하지 말고 한번 돌리고 그다음에 한번 돌리기
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int map[][] = new int[n][3];
        int dp[][] = new int[n][3]; //0은 max, 1은 min

        //256mb 메모리제한 - int가 4byte니까 64
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        
        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];
        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];
        

        for(int i=1; i<n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + map[i][0];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = Math.max(dp[i-1][2], dp[i][1]) + map[i][1];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) + map[i][2];
        }

        dp[n-1][2] = Math.max(dp[n-1][2], dp[n-1][0]);
        System.out.print(Math.max(dp[n-1][2], dp[n-1][1]) + " ");

        for(int i=1; i<n; i++) {
            dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = Math.min(dp[i][1], dp[i-1][2]) + map[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][2];
        }

        dp[n-1][2] = Math.min(dp[n-1][2], dp[n-1][0]);
        System.out.print(Math.min(dp[n-1][2], dp[n-1][1]));
    }
}
