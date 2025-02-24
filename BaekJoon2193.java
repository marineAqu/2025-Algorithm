import java.util.Scanner;

public class BaekJoon2193 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long dp[][] = new long[91][2]; // [0]은 0으로 끝나는 것, [1]은 1로 끝나는 것
        dp[1][0] = 0;
        dp[1][1] = 1;

        dp[2][0] = 1;
        dp[2][1] = 0;

        for(int i=3; i<n+1; i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1];

            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[n][0] + dp[n][1]);
    }
}
