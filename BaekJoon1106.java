import java.io.*;
import java.util.*;

public class BaekJoon1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken()); //최소 늘려야하는 고객 수
        int n = Integer.parseInt(st.nextToken()); //도시 수

        int info[][] = new int[n][2];
        int dp[] = new int[c+1]; //인덱스는 고객 수
        Arrays.fill(dp, 2000001);

        int r;

        //입력
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            info[i][0] = Integer.parseInt(st.nextToken()); //비용
            info[i][1] = Integer.parseInt(st.nextToken()); //얻을 수 있는 고객

            //배수 형태 저장
            r = 1;
            while(info[i][1] * r <= c){
                dp[info[i][1] * r] = Math.min(dp[info[i][1] * r], info[i][0] * r);
                r++;
            }

            //넘치는 경우까지 저장
            dp[c] = Math.min(dp[c], info[i][0] * r);
        }

        //조합 형태 저장
        for(int i=0; i<n; i++) {      
            //각 도시에 대해서 dp에 있는 거랑 더해서  
            
            for(r = 1; r<=c; r++){
                if(r + info[i][1] > c) {
                    dp[c] = Math.min(dp[c], dp[r] + info[i][0]);
                }
                else dp[r + info[i][1]] = Math.min(dp[r + info[i][1]], dp[r] + info[i][0]);
            }
        }



        System.out.print(dp[c]);


        //근데 info[1] * 10 + info[2] * 2 이런 식의 조합도 구해야한다는 게 문제
        //배수 형태 저장하지 않고, 1배수 값만 dp에 저장
        //그리고 info에 대해서 for문 돌려서 모든 dp에 들려서 해당 dp값 + 현재 info값 더해서
        //dp[info[i] + dp[r]] = Math.min() 해볼까
        //20 * 1000 = 2000이려나
        //근데 c를 넘어버리면... 그러면 dp[c]에다가 Math.min으로 저장하자


        /* 배수로도 DP에 저장해야하고, 조합으로도 저장해야한다.
        예를 들면 3의 배수 + 2의 배수로 손님이 11일 때 드는 비용 같은 거

        또 넘치는 것에 대해서도 염두에두기. 12일때 최솟값이 3이고 11일때 최솟값이 4인데
        c가 11이라면 4가 아니라 3이 되어야 한다.
        
        
        1. 그럼 일단 c이하의 배수 형태를 모두 dp에 저장해두고
        2. 그다음부터 조합을 실행한다.
        */

    }
}
