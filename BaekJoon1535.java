import java.util.*;
import java.io.*;

public class BaekJoon1535 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n+1][2]; //[0] 체력, [1] 기쁨

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) arr[i][0] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) arr[i][1] = Integer.parseInt(st.nextToken());

        //이제 계산
        int dp[][] = new int[100][n+1];

        //체력 오름차순
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        
        //[0] 체력, [1] 기쁨
        for(int i=0; i<100; i++) { //i는 가진 체력
            for(int r=1; r<=n; r++) { //r은 사람 번호
                if(i-arr[r][0] >= 0) 
                    dp[i][r] = Math.max(dp[i-arr[r][0]][r-1] + arr[r][1], dp[i][r-1]); 
                else 
                    dp[i][r] = dp[i][r-1];
            }
        }

        System.out.println(dp[99][n]);
    }
}