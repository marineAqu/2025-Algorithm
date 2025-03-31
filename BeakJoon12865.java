import java.io.*;
import java.util.*;

public class BeakJoon12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n+1][2];
        int dp[][] = new int[k+1][n+1];

        //input
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //무게
            arr[i][1] = Integer.parseInt(st.nextToken()); //가치
        }

        for(int i=0; i<=k; i++){ //무게
            for(int r=1; r<=n; r++){ //각 물건
                if(i - arr[r][0] < 0){
                    dp[i][r] = dp[i][r-1];
                }

                else{
                    dp[i][r] = Math.max(dp[i][r-1], dp[i-arr[r][0]][r-1] + arr[r][1]);
                }
            }
        }

        System.out.println(dp[k][n]);
    }
}
