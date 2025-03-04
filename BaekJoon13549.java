import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//주의사항: n이 꼭 m보다 작지 않다. m < n일 수 있다
//          우선순위 큐를 사용하지 않으면 시간초과 발생

public class BaekJoon13549 {
    static int dp[];
    static int m;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[200001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        queue.add(n);

        if(n > m) dp[m] = n- m;
        else dpMethod();

        System.out.print(dp[m]);
    }

    public static void dpMethod(){
        while (!queue.isEmpty()) {
            int i = queue.poll();

            if(i + 1 < m+m+1 && dp[i+1] > dp[i] + 1) {
                dp[i+1] = dp[i] + 1;
                queue.add(i+1);
            }
            if(i - 1 > 0 && dp[i-1] > dp[i] + 1) {
                dp[i-1] = dp[i] + 1;
                queue.add(i-1);
            }
            if(i*2 < m+m+1 && dp[i*2] > dp[i]) {
                dp[i*2] = dp[i];
                queue.add(i*2);
            }
        }
    }
}
