import java.util.*;
import java.io.*;

public class BaekJoon17404 {
    public static void main(String[] args) throws IOException{
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][3];
        int dp[][] = new int[n][3];

        //입력
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = 1000002;
        dp[0][2] = 1000002;

        //계산
        for(int i=1; i<n; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }

        int answer = Math.min(dp[n-1][1], dp[n-1][2]);

        dp[0][0] = 1000002;
        dp[0][1] = arr[0][1];
        dp[0][2] = 1000002;

        //계산
        for(int i=1; i<n; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }

        answer = Math.min(answer, dp[n-1][0]);
        answer = Math.min(answer, dp[n-1][2]);

        dp[0][0] = 1000002;
        dp[0][1] = 1000002;
        dp[0][2] = arr[0][2];

        //계산
        for(int i=1; i<n; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }

        answer = Math.min(answer, dp[n-1][0]);
        answer = Math.min(answer, dp[n-1][1]);
        //마지막 계산

        System.out.print(answer);
    }
}
