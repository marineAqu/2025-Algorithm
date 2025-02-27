import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon11060 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //미궁 크기

        int arr[] = new int[n];
        int dp[] = new int[n];
        Arrays.fill(dp, 1000000);

        st  = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken()); 

        //적혀있는 수 이하만큼 이동할 수 있음
        dp[0] = 0;
        for(int i=0; i<n; i++) {
            for(int k=1; k<=arr[i]; k++){
                if(i+k < n) dp[i+k] = Math.min(dp[i] + 1, dp[i+k]);
            }
        }

        //최소 점프 수
        if(dp[n-1] == 1000000) System.out.print(-1);
        else System.out.print(dp[n-1]);
    }
}
