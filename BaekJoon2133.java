import java.io.*;

public class BaekJoon2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1~ 30

        // 홀수일 때는 -- 같이 배치할 수 없다.
        //홀수일 때는 1*1 크기가 항상 남아서 배치를 할 수가 없다.
        // = 홀수는 그냥 0
        if(n%2 == 1){
            System.out.println("0");
            return;
        }

        long dp[] = new long[31];
        dp[0] = 1;
        dp[2] = 3;

        //dp[2] = 3;
        //dp[4] = 11; //3*3+2 = 11
        //dp[6] = 41; -> 27 + 12 + 2 (3^3 + 2*6 + 2)
        //dp[8] = 81 + 4(3*4타일셋 2개씩 조합) + 2*(9+9+9)(3*4타일셋 1개에 3*2타일셋 2개(2,0/1,1/0,2))
        //            + 2*(3+3)(3*6타일셋에 3*2 타일셋 조합) + 2(3*8 타일셋)
        //          81 + 4 + 54 + 12 + 2 = 81+58+14 = 139+14 = 153

        //ll  __   __
        //__  ll   ==
        //3*2를 만드는 경우는 이렇게 3가지 경우가 존재.
        
        //3*4를 만들려면 힌트와 같이 2가지 경우가 존재할 수 있다
        // -> 3*6을 만들 때 3*2에다가 이 3*4를 합치는 경우의 수를 더해야한다.
        //      *3으로는 뒤에 더하는 것만 계산되는데 앞에 붙이는 것도 생각해야함
        //3*6을 만드려면 마찬가지로 +2가지 경우가 존재한다

        //각 i를 3*2를 연속해 붙여서 만드는 방법 개수: 3^(i/2)

        //각 dp에 3*2타일만으로 조합하는 경우 말고 다르게 조합하는 법만 저장해두기.

        for(int i=4; i<=n; i+=2){
            dp[i] = dp[i-2] * 3;
            for(int r=i-4; r>=0; r-=2){
                dp[i] += dp[r] * 2;
            }
        }

        System.out.println(dp[n]);
    }
}
