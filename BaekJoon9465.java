import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//처음엔 DP를 1차원배열로 선언해서 계산하고, 이전에 윗줄의 스티커를 사용했는지 아랫줄 스티커를 사용했는지는 별도 변수에 저장했으나 
//  DP를 2차원 배열로 선언하고 계산해야 한다. 위처럼 계산하면 돌아가 전전 열에서 뗄 스티커를 교체하는 경우를 계산할 수 없음

public class BaekJoon9465 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        int n;
        int arr[][];
        int dp[][];

        for(int i=0; i<testCase; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            arr = new int[2][n];
            dp = new int[n+2][2];

            //값 받기
            for(int j=0; j<2; j++){
                st = new StringTokenizer(br.readLine());

                for(int z=0; z<n; z++){
                    arr[j][z] = Integer.parseInt(st.nextToken());
                }
            }

            //계산
            for(int z=2; z<n+2; z++){
                dp[z][0] = Math.max(Math.max(dp[z-2][0], dp[z-2][1]), dp[z-1][1]) + arr[0][z-2];
                dp[z][1] = Math.max(Math.max(dp[z-2][0], dp[z-2][1]), dp[z-1][0]) + arr[1][z-2];

                // -> 전전것을 먹는 경우에는 같은 라인이 아니더라도 괜찮다. 즉 Math.max(dp[z-2][0], dp[z-2][1])
            }

            System.out.println(Math.max(dp[n+1][0], dp[n+1][1]));

        }
    }
}
