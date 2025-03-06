import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        int dp[] = new int[k+1];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            //dp[arr[i]] = 1;
        }

        //정렬
        Arrays.sort(arr);

        //원래 작성했던 로직 :
        //지금 값에 동전 하나를 더했을 때 k보다 작거나 같으면
        //그 값을 만들 수 있는 경우의 수에 내 경우의 수를 더한다

        
        //for(int i=0; i<=k; i++) {
            //for(int t=0; t<n; t++) {
            //    if(arr[t] >= i && i + arr[t] <= k) dp[i + arr[t]] += dp[i];
            //}

            //   1 + 3 + 4 (8)     +6
            // = 1 + 3 + 6 (10)    +4 이런식으로 같은 조합 중복 발생
        //}

        //수정한 로직
        //t를 만들 수 있는 가짓수 = t를 내 동전값 제외한 값만큼 만들 수 있는 가짓수
        for(int i=0; i<n; i++){
            if(arr[i] <= k) dp[arr[i]]++;
            for(int t=0; t<=k; t++){
                if(t - arr[i] >= 0 && t <= k) dp[t] = dp[t] + dp[t - arr[i]];
            }
        }

        System.out.println(dp[k]);
    }
}