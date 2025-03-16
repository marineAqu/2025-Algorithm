import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        //3으로 나누거나, 2로 나누거나, 1을 뺄 수 있다
        //이렇게 1로 만들어야 한다.
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int dp[][] = new int[n+1][2];
        for(int i=4; i<=n; i++) dp[i][0] = Integer.MAX_VALUE;

        dp[1][0] = 0;
        dp[1][1] = 1;
        if(n >= 2) {
            dp[2][0] = 1;
            dp[2][1] = 1;
        }
        if(n >= 3) {
            dp[3][0] = 1;
            dp[3][1] = 1;
        }
        
        for(int i=1; i<n; i++){
            if(dp[i+1][0] > dp[i][0] + 1){
                dp[i+1][0] = dp[i][0] + 1;
                dp[i+1][1] = i;
            }

            if(i*2 <= n && dp[i*2][0] > dp[i][0] + 1){
                dp[i*2][0] = dp[i][0] + 1;
                dp[i*2][1] = i;
            }

            if(i*3 <= n && dp[i*3][0] > dp[i][0] + 1){
                dp[i*3][0] = dp[i][0] + 1;
                dp[i*3][1] = i;
            }
        }

        System.out.println(dp[n][0]);

        int now = n;
        
        if(n != 1) System.out.print(n + " ");
        while(dp[now][1] != 1){
            System.out.print(dp[now][1]+" ");
            now = dp[now][1];
        }
        System.out.print("1");
        
    }
}
