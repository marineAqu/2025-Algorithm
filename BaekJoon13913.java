import java.io.*;
import java.util.*;

public class BaekJoon13913 {
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        if(k == n){
            System.out.println(0);
            System.out.print(k);
            return;
        }

        else if(n > k){
            System.out.println(n - k);
            for(int i=n; i>=k; i--) System.out.print(i+" ");
            return;
        }

        queue.add(n);
        
        int now;
        int dp[] = new int[2 * k];
        Arrays.fill(dp, 300000);
        dp[n] = 0;
        int load[] = new int[2*k];

        while (!queue.isEmpty()) {
            now = queue.poll();
            
            if(now+1 < 2*k && dp[now+1] > dp[now] + 1){
                dp[now+1] = dp[now] + 1;
                queue.add(now+1);
                load[now+1] = now;
            }

            if(now-1 >= 0 && dp[now-1] > dp[now] + 1){
                dp[now-1] = dp[now] + 1;
                queue.add(now-1);
                load[now-1] = now;
            }

            if(now*2 < 2*k && dp[now*2] > dp[now] + 1){
                dp[now*2] = dp[now] + 1;
                queue.add(now*2);
                load[now*2] = now;
            }
        }

        System.out.println(dp[k]);
        now = k;
        StringBuilder sb = new StringBuilder();
         
        while(now != n){
            sb.insert(0, now+" ");
            now = load[now];
        }
        sb.insert(0, n+" ");
        System.out.print(sb);;
    }
}
