import java.io.*;
import java.util.*;

public class BaekJoon7579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int app[][] = new int[n+1][2];
        int dp[][] = new int[10001][n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            app[i][0] = Integer.parseInt(st.nextToken()); //차지하고 있는 메모리
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            app[i][1] = Integer.parseInt(st.nextToken()); //cost
        }

        Arrays.sort(app, (o1, o2) -> o1[1] - o2[1]);

        //냅색 알고리즘 응용. 최솟값이므로 역으로 cost에 따른 최대 메모리를 해야하나
        //   -> cost에 따른 최대 메모리를 구하기??
        //각 비용은 최대 100이고 n은 최대 100이므로 최대 10000

        for(int i=0; i<=10000; i++){ //cost
            for(int r=1; r<=n; r++){ //메모리
                if(i - app[r][1] < 0) {
                    dp[i][r] = dp[i][r-1];
                }

                else{
                    dp[i][r] = Math.max(dp[i][r-1], dp[i-app[r][1]][r-1] + app[r][0]);
                }

                //계산
                if(dp[i][r] >= m){
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
