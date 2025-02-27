import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1937 {
    static int dp[][];
    static int map[][];
    static int n;
    static int max_value = 0;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        StringTokenizer st;

        //저장
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int t=0; t<n; t++){
                map[i][t] = Integer.parseInt(st.nextToken());
            }
        }

        //계산
        dp = new int[n][n];

        for(int i=0; i<n; i++){
            for(int t=0; t<n; t++){
                if(dp[i][t] == 0) dfs(i, t, 0);
            }
        }

        System.out.println(max_value + 1); //자기자신 칸수도 포함하기
    }

    static int dfs(int y, int x, int count){
        if(x+1 < n && map[y][x+1] > map[y][x]){
            if(dp[y][x+1] != 0) count = Math.max(count, dp[y][x+1] + 1);

            else{
                count = Math.max(count, dfs(y, x+1, 0) + 1);
            }
        }

        if(y+1 < n && map[y+1][x] > map[y][x]){
            if(dp[y+1][x] != 0) count = Math.max(count, dp[y+1][x] + 1);

            else{
                count = Math.max(count, dfs(y+1, x, 0) + 1);
            }
        }

        if(x-1 >= 0 && map[y][x-1] > map[y][x]){
            if(dp[y][x-1] != 0) count = Math.max(count, dp[y][x-1] + 1);

            else{
                count = Math.max(count, dfs(y, x-1, 0) + 1);
            }
        }

        if(y-1 >= 0 && map[y-1][x] > map[y][x]){
            if(dp[y-1][x] != 0) count = Math.max(count, dp[y-1][x] + 1);

            else{
                count = Math.max(count, dfs(y-1, x, 0) + 1);
            }
        }

        dp[y][x] = Math.max(dp[y][x], count);
        max_value = Math.max(max_value, dp[y][x]);

        return count;
    }
}
