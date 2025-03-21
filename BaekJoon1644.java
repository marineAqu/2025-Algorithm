import java.util.*;
import java.io.*;

public class BaekJoon1644 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int dpsize = 1;

        //먼저 소수를 모두 구한다
        int arr[] = new int[n+1];
        long dp[] = new long[2000000];
        dp[0] = 0; //전체를 더하는 경우를 위해 0 포함

        //합성수를 체크 겸 누적합 저장
        for(int i=2; i<n+1; i++){
            if(arr[i] == 1) continue;

            //소수라면 누적합 저장
            dp[dpsize] = dp[dpsize-1] + i;
            dpsize++;

            for(int r=2; r*i<n+1; r++){
                    arr[i*r] = 1;
            }
        }


        //만들 수 있는 개수를 저장
        int p1 = dpsize - 2, p2 = dpsize - 1;

        //시간초과 문제 개선 코드
        //상식적으로 p2가 가장 오른쪽 (가장 n보다 작거나 같은 소수 중 근접한 소수)에 있을 때,
        //당연히 모든 소수를 더하면 n보다 클 것이다. 그렇다면 p1을 p2의 한칸 왼쪽에 뒀다가,
        //n보다 작으면 그때 p1을 한칸씩 왼쪽으로 옮겨 sum의 크기가 커지도록 하면 된다.
        // -> 누적합을 구하는 걸 그림으로 그려보면 이해가 쉽다.
        while(p2 > 0){
            if(p1 == -1){
                p2--;
                p1 = p2 - 1;
            }

            else if(dp[p2] - dp[p1] == n) {
                count++;

                p2--;
                p1 = p2 - 1;
            }

            else if(dp[p2] - dp[p1] > n) {
                p2--;
                p1 = p2 - 1;
            }

            else{
                p1--;
            }
        }

        //시간초과 발생 코드
        //p2를 가장 오른쪽에, p1을 가장 왼쪽에 위치
        //누적합이 n보다 작으면 p2를 한칸 왼쪽으로 옮기고 다시 p1을 가장 왼쪽에 위치
        //누적합이 n보다 크면 p1을 한칸 오른쪽으로 위치
        // -> 필요없는 연산 수가 너무 많음

        //소수의 개수가 m이라면 m + m-1 + m-2 + ... 1
        //즉 (소수의 개수)*(소수의 개수-1) /2 만큼 연산을 실행한다.
        //10,000,000 까지 소수 개수가 664579이므로 ............. 
        /* 
        int p1 = 0, p2 = dpsize - 1;
        while(p2 != 0){
            if(dp[p2] - dp[p1] == n) {
                count++;

                p2--;
                p1 = 0;
            }

            else if(dp[p2] - dp[p1] > n) p1++;

            else{
                p2--;
                p1 = 0;
            }
        }
*/
        System.out.print(count);
    }
}
