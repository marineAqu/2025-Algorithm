import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int dp[] = new int[n];
        int maxVal = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp[0] = 1;
        for(int i=1; i<n; i++){
            for(int r=0; r<i; r++){
                if(arr[r] > arr[i]) dp[i] = Math.max(dp[i], dp[r]);
            }

            dp[i]++;
            maxVal = Math.max(dp[i], maxVal);
        }

        System.out.println(maxVal);
    }
}
