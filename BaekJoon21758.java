import java.util.*;
import java.io.*;

public class BaekJoon21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int map[] = new int[n];
        int dp[] = new int[n];
        int maxVal = 0;
        int cal;

        //input + 누적합
        map[0] = Integer.parseInt(st.nextToken());
        dp[0] = map[0];

        for(int i=1; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
            dp[i] = map[i] + dp[i-1];
        }

        //!!! 누적합은 길이가 길어야 한다는 것을 기억하자.
        //1. 벌통을 가장 왼쪽에 두고, 꿀벌 하나는 가장 오른쪽에 두며 하나의 꿀벌을 조정
        //2. 벌통을 가장 오른쪽에 두고, 꿀벌 하나는 가장 왼쪽에 두며 하나의 꿀벌을 조정
        //3. 꿀벌을 양쪽 끝에 두고 벌통을 그 사이 지점에 위치시키는 경우
        
        //1번.
        cal = dp[n-1] - map[n-1];
        for(int i=1; i<n-1; i++){
            maxVal = Math.max(maxVal, cal + (dp[i] - map[i]) - map[i]);
        }

        //2번.
        cal = dp[n-1] - map[0];
        for(int i=1; i<n-1; i++){
            maxVal = Math.max(maxVal, cal + (dp[n-1] - dp[i]) - map[i]);
        }

        //3번.
        cal = dp[n-2] - map[0];
        for(int i=1; i<n-1; i++){
            maxVal = Math.max(maxVal, cal + map[i]);
        }

        System.out.print(maxVal);

    }
}
