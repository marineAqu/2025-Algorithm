import java.io.*;
import java.util.*;

//1,500,000이 1000개 있을 수 있으니까
//1,500,000,000
public class BaekJoon15486 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][2];
        long dp[] = new long[n+1];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        for(int i=n-1; i>=0; i--){
            //날짜가 모자라 상담을 진행할 수 없는 경우
            if(arr[i][0] + i > n) dp[i] = dp[i+1];

            else{
                dp[i] = Math.max(dp[i+arr[i][0]]+arr[i][1], dp[i+1]);
            }
        }

        System.out.print(dp[0]);
    }
}
