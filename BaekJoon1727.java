import java.io.*;
import java.util.*;

public class BaekJoon1727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long sum = 0;

        int male[] = new int[n];
        int female[] = new int[m];

        int dp[][] = new int[n][m];

        //입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) male[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) female[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(male); Arrays.sort(female);

        //남자 수와 여자 수가 같다면 정렬 후 순서대로 커플로 만드는 것이 최솟값이다.
        //남자 수와 여자 수가 다를 때는 이를 응용해 계산한다.
        //수가 다를 때는 i번째 사람이 짝을 맺었을 수도, 그렇지 않았을 수도 있다.
        //짝을 맺었다면 이성 중 마지막 번호인 사람일 것이다. 이를 이용해 DP로 풀이

        for(int i=0; i<n; i++){
            for(int r=0; r<m; r++){
                if(i == r) {
                    if(i == 0) dp[i][r] = Math.abs(male[i] - female[r]);
                    else dp[i][r] = dp[i-1][r-1] + Math.abs(male[i] - female[r]);
                }
                else if(i > r) {
                    if(r == 0) dp[i][r] = Math.min(dp[i-1][r], Math.abs(male[i] - female[r]));
                    else dp[i][r] = Math.min(dp[i-1][r], dp[i-1][r-1] + Math.abs(male[i] - female[r]));
                }
                else {
                    if(i == 0) dp[i][r] = Math.min(dp[i][r-1], Math.abs(male[i] - female[r]));
                    else dp[i][r] = Math.min(dp[i][r-1], dp[i-1][r-1] + Math.abs(male[i] - female[r]));
                }
            }
        }

        System.out.print(dp[n-1][m-1]);
    }
}
