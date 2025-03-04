import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1개 -1
1: 1

2개 - 1
2: 1 1

3개 - 2
3: 1 1 1
4: 1 2 1

4개 - 2
5: 1 2 1 1
6: 1 2 2 1

5개 - 3
7: 1 2 2 1 1
8: 1 2 2 2 1
9: 1 2 3 2 1

6개 - 3
10: 1 2 3 2 1 1
11: 1 2 3 2 2 1
12: 1 2 3 3 2 1 // 12

구간합*2 = i 이면 i*2가 정답
그 다음부터는 i*2 + 1
(i+1)*2 = i*2 + 2

7개 - 4
13: 1 2 3 3 2 1 1
14: 1 2 3 3 2 2 1 //3과 4 사이
15: 1 2 3 3 3 2 1 //1~3 합: 6
16: 1 2 3 4 3 2 1 //

1~3: 6
1~4: 10

8개 - 4
17: 1 2 3 4 3 2 1 1 //1~4 합: 10
18: 1 2 3 4 3 2 2 1  // 3와 4 사이: 즉 6과 10 사이
19: 1 2 3 4 3 3 2 1 //1~3 합: 6 (12) 
20: 1 2 3 4 4 3 2 1 //합이 내 절반인 구간합 값을 찾아야한다
//1~4 합: 10
//1~5 합: 15

9개 - 5
21: 1 2 3 4 4 3 2 1 1 //4와 5 사이. 즉 8과 10 사이 = 9
21: 1 2 3 4 4 3 2 2 1
22: 1 2 3 4 4 3 3 2 1
23: 1 2 3 4 4 4 3 2 1
24: 1 2 3 4 5 4 3 2 1
(y-x+1) / 2 의 값 아닌가
갯수 관점이 아니라

구간합 저장해두고
*/

public class BaekJoon1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        int x, y, count = 0;
        //DP로 풀 수 있을까

        long dp[] = new long[70001];
        for(int i=1; i<70001; i++){
            dp[i] = dp[i-1] + i;
        }

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            //dp에서 *2했을 때 나와 일치하거나, 그 사이 값을 찾아야 한다
            
            for(int k=1; k<70001; k++){
                // 1 2 2 1 같은 경우
                if(dp[k] * 2 == y-x) {
                    count = k*2;
                    break;
                }

                //1 2 3 2 1 같은 경우
                if(dp[k] * 2 - k == y-x){
                    count = k*2 - 1;
                    break;
                }

                if(dp[k] * 2 - k > y-x){
                    count = k*2 - 1;
                    break;
                }

                if(dp[k] * 2 > y-x){
                    count = k*2;
                    break;
                }
                
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
