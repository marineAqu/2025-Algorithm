import java.util.Scanner;

public class BaekJoon9095{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int dp[] = new int[12];
        int now;

        dp[1] = 1;
        dp[2] = 2; // 1+1, 2 //2개
        dp[3] = 4; // 1+1+1, 1+2, 2+1, 3 //4개
        dp[4] = 7; // 1+1+1+1, 2+2, 2+1+1, 1+2+1, 1+1+2, 3+1, 1+3
                    //dp[3]의 것들에 1을 더하고, dp[2]의 것들에 2를 더하며, dp[1]의 것에 3을 더한다.
                    //dp[2]에 +1+1을 고려하지 않는다. 이미 dp[3]에 고려되어 있음
        
        for(int i=5; i<12; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int i=0; i<t; i++){
            now = sc.nextInt();

            System.out.println(dp[now]);
        }
    }
}