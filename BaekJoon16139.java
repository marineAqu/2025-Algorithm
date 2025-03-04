import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int dp[][] = new int[s.length()][26];

        char a;
        int l, r;

        dp[0][s.charAt(0) - 'a'] = 1;
        
        //DP 계산
        for(int i=1; i<s.length(); i++) {
            for(int t=0; t<26; t++){
                dp[i][t] = dp[i-1][t];
            }

            dp[i][s.charAt(i) - 'a']++;
        }

        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());

            a = st.nextToken().charAt(0);
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            if(l == 0) sb.append(dp[r][a - 'a']).append("\n");
            else sb.append(dp[r][a - 'a'] - dp[l-1][a - 'a']).append("\n");
        }

        System.out.print(sb);
    }
}
