import java.io.*;
import java.util.*;

public class BaekJoon1309 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //가로도 세로도 붙어있게 할 순 없다.
        long dp[][] = new long[n+1][3];  //3차배열: 0은 사자를 안 넣은 경우, 1은 넣은 경우

        dp[1][0] = 1; // XX
        dp[1][1] = 1; // OX
        dp[1][2] = 1; // XO

        for(int i=2; i<=n; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }

        System.out.println((dp[n][0]+dp[n][1]+dp[n][2]) % 9901);

        //1일때: 11 01 10 00 4개
        //2일때:  1  3  3  4 -> 1+6+4 = 11개
        //       00 / 11 빼고 모두 / 11빼고 모두 / 모두 
        //3일때: 이런 식으로 하다가 중간에 것이 
    }
}
