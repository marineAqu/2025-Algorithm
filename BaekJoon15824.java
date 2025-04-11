import java.io.*;
import java.util.*;

public class BaekJoon15824 {
    static long pow2[] = new long[300001];

    public static void main(String[] args) throws IOException{
        //주헌고통지수 = 최댓값 - 최솟값
        //모든 조합의 주헌고통지수 합

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        long arr[] = new long[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        pow2[0] = 1;
        pow2[1] = 2;
        pow2[2] = 4;

        for(int i=3; i<n+1; i++){
            pow2[i] = (pow2[i-1] * 2) % 1000000007;
        }

        Arrays.sort(arr);

        long dp[] = new long[n+1];

        dp[1] = 1;
        if(n > 1) dp[2] = 3;

        //범위가 넘을 것 같으니 이것도 1000000007
        for(int i=3; i<n+1; i++) {
            //dp[i] = (dp[i-1] + (int)Math.pow(2, i-1)) % 1000000007;
            dp[i] = (dp[i-1] + pow2[i-1]) % 1000000007;
        }

        //2의 300,000제곱 당연히 범위 넘을텐데

        //n은 최대 300000
        //조합의 합을 1000000007로 나눠줘야한다

        //일단 몇개의 조합이 나오느냐: 300000! / 2! (299998)! = 150000 * 299999
        // 2개씩만 조합해도 450000000000 


        //진짜 모든 조합을 구해야한다 (2개씩 조합, 3개씩 조합 등)

        //그니까 각 조합에서 중간값은 고려할필요가없음
        //나는 나보다 큰 값만 고려하면 됨 (나보다 작은 애는 걔 입장에서 조합별 가장 큰 애를 고려할테니까)
        
        //각 조합에서 2개의 조합 ~ n개의 조합을 고려할건데
        //각 숫자별로 나보다 큰 것을 링크드리스트로하면 메모리초과가 나겠지

        //배열을 정렬하고
        //2개 단위로 더하고 ~ k개 단위로 더하기

        //연산횟수 300000 + ... + 1이니까
        //n(n-1)/2 
        //이것도 시간초과다
        //n회돌면서 *n해주면되지않을까?? 범위니까

        long temp;

        long maxCount, minCount, diff;

        for(int i=0; i<n; i++){
            maxCount = pow2[i];
            minCount = pow2[n - 1 - i];
            diff = (maxCount - minCount + 1000000007) % 1000000007; // 음수 방지
            sum = (sum + arr[i] * diff) % 1000000007;
        }
        
        /* 
        //뺄셈
        for(int i=0; i<n-1; i++) {
            temp = (arr[i] % 1000000007) * dp[n - (i+1)];

            temp %= 1000000007;

            sum = (sum - temp) % 1000000007;
        }

        //덧셈
        for(int i=1; i<n; i++) {
            temp = (arr[i] % 1000000007) * dp[i];

            temp %= 1000000007;

            sum = (sum + temp) % 1000000007;
        }
        */

        System.out.print(sum);
    }
}