import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int dp[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        int count;

        //계산
        for(int i=1; i<n; i++){
            count = 1;

            for(int r=0; r<i; r++){
                if(arr[r] < arr[i]){
                    count = Math.max(count, dp[r] + 1);
                }
            }

            dp[i] = count;
        }

        int maxVal = 0;
        for(int i=0; i<n; i++){
            maxVal = Math.max(maxVal, dp[i]);
        }

        System.out.print(maxVal);
    }
}
