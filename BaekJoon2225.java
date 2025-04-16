import java.io.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2225 {
    static int count;
    //static long memory[] = new long[201];

    /* 
    static long nCr(int n, int r){
        if( r > 39 || n-r > 39 || n > 40 ) return 0;
        return (((memory[n] / memory[r]) % 1000000000) / memory[n-r]) % 1000000000;
    }
*/
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long sum = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //0부터 n까지 정수 k개를 더하기. 순서다르면 다른 것, 한개의 수 여러개 가능
        
        int dp[][] = new int[n+1][k+1];
        
        dp[1][1] = 1;
        for(int i=2; i<=k; i++) dp[1][i] = i;

        for(int i=2; i<n+1; i++){
            for(int r=1; r<k+1; r++){
                dp[i][r] = (dp[i-1][r] + dp[i][r-1]) % 1000000000;
            }
        }

        System.out.println(dp[n][k]);

        //잘못된 점화식 (시간초과)
        /* 
        memory[1] = 1;
        for(int i=2; i<40; i++){
            memory[i] = (memory[i-1] * i) % 1000000000;
        }

        for(int i=1; i<k+1; i++) dp[i][1] = i;
        for(int i=2; i<n+1; i++){
            //dp[k][k] 계산하기
            //0과 n을 사용하지 않고 1~n-1을 사용해 조합 만든다

            count = 0;
            dfs(n, i, 0);
            dp[i][i] = count;
            
            //빈칸을 0으로 채운다고 생각하고 채운다
            if(k > i) sum += (dp[i][i] * (int) nCr(k, i)) % 1000000000; //(r - k)의 조합을 곱하면되나??
                                    //4자리중에 2자리를 차지하는 조합  = 4! / (4-2)! 2! = 6 맞는듯
        
        }

        System.out.println(sum);
*/
    }

    /* 
    static void dfs(int n, int depth, int sum){
        if(sum > n) return;

        if(depth == 0) {
            if(sum == n) count++;
            count %= 1000000000;
            return;
        }

        for(int i=1; i<n; i++){
            dfs(n, depth - 1, sum + i);
        }
    }
        */
}
