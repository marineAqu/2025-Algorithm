import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//비용의 최솟값
//시간 0.5초라 백트래킹같은 게 아닌데
//집 수 1000
// 1 2 3
// 2 1 3

//나는 내 이전, 내 이후와 동일하지 않으면 됨
//즉 1 2 1 식은 가능
//그러니까 3개를 묶음으로 잡으면 종류가 3개이거나 2개이거나
//1 2 1 2
//1 2 1 3
//이렇게 가능해진다

//그러니까 난 내 이전과만 겹치지 않으면 됨
//DP문제인가..................
//dp를 [i][3]으로 잡아서 하면 되지않을까

public class BaekJoon1149 {
    static int n, info[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        info = new int[n+1][3];

        int minCost = Integer.MAX_VALUE;

        int dp[][] = new int[n+1][3];
        //빨 / 초 / 파
        //색이 연속되면 안되고, 내 전과 내 후 집 색이 같아서는 안 된다.
        // 칠하는 비용을 구한다.

        //입력 받기
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = info[1][0];
        dp[1][1] = info[1][1];
        dp[1][2] = info[1][2];

        for(int i=2; i<=n; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + info[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + info[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + info[i][2];
        }

        minCost = Math.min(dp[n][0], dp[n][1]);
        minCost = Math.min(minCost, dp[n][2]);

        System.out.println(minCost);

    }
}
