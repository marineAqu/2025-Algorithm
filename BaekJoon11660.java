import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 해당 위치까지의 사각형 모양의 합을 DP에 저장

public class BaekJoon11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int dp[][] = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int t=0; t<n; t++){
                if (t == 0) {
                    dp[i][t] = Integer.parseInt(st.nextToken());
                }
                else dp[i][t] = dp[i][t-1] + Integer.parseInt(st.nextToken());
            }
        }

        // 직사각형 모양으로 저장
        for(int i=1; i<n; i++){
            for(int t=0; t<n; t++){
                dp[i][t] += dp[i-1][t];
            }
        }

        int x1, x2, y1, y2;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            
            y1 = Integer.parseInt(st.nextToken());
            x1 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());


            if(x1 == 1 || y1 == 1) {
                if(x1 == 1 && y1 == 1) System.out.println(dp[y2 - 1][x2 - 1]);
                else if (x1 == 1) System.out.println(dp[y2 - 1][x2 - 1] - dp[y1 - 2][x2 - 1]);
                else System.out.println(dp[y2 - 1][x2 - 1] - dp[y2 - 1][x1 - 2]);
            }
            
            else System.out.println(dp[y2 - 1][x2 - 1] + dp[y1 - 2][x1 - 2] - dp[y1 - 2][x2 - 1] - dp[y2 - 1][x1 - 2]);
        }
    }
}
