import java.io.*;
import java.util.*;

public class BaekJoon18430 {
    static int arr[][];
    static int visitedMap[][], dp[][][];
    static int n, m;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visitedMap = new int[n][m];
        dp = new int[n][m][4];
        arr = new int[n][m];

        //input
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int r=0; r<m; r++){
                arr[i][r] = Integer.parseInt(st.nextToken());
            }
        }

        for(int y=0; y<n; y++){
            for(int x=0; x<m; x++){
            //0
            if(x - 1 >= 0 && y + 1 < n) dp[y][x][0] = arr[y+1][x] + arr[y][x-1] + arr[y][x] * 2;
            
            //1
            if(x - 1 >= 0 && y - 1 >= 0) dp[y][x][1] = arr[y-1][x] + arr[y][x-1] + arr[y][x] * 2;

            //2
            if(x + 1 < m && y - 1 >= 0) dp[y][x][2] = arr[y][x + 1] + arr[y-1][x] + arr[y][x] * 2;
            
            //3
            if(x + 1 < m && y + 1 < n) dp[y][x][3] = arr[y][x + 1] + arr[y+1][x] + arr[y][x] * 2;
        }}

        backTrack(0, 0 , 0);

        System.out.println(answer);
    }

    static void backTrack(int x, int y, int sum) {
        //패스하는 경우
        if(x+1 < m) backTrack(x+1, y, sum);
        else if(y+1 < n) backTrack(0, y+1, sum);

        //0
        if(x - 1 >= 0 && y + 1 < n && visitedMap[y][x] == 0 && visitedMap[y+1][x] == 0 && visitedMap[y][x-1] == 0) {
            visitedMap[y][x] = 2;
            visitedMap[y+1][x] = 1;
            visitedMap[y][x-1] = 1;

            if(x+1 < m) backTrack(x+1, y, sum+dp[y][x][0]);
            else if(y+1 < n) backTrack(0, y+1, sum+dp[y][x][0]);

            answer = Math.max(answer, sum+dp[y][x][0]);

            visitedMap[y][x] = 0;
            visitedMap[y+1][x] = 0;
            visitedMap[y][x-1] = 0;
        }

        //1
        if(x - 1 >= 0 && y - 1 >= 0 && visitedMap[y][x] == 0 && visitedMap[y-1][x] == 0 && visitedMap[y][x-1] == 0) {
            visitedMap[y][x] = 2;
            visitedMap[y-1][x] = 1;
            visitedMap[y][x-1] = 1;

            if(x+1 < m) backTrack(x+1, y, sum+dp[y][x][1]);
            else if(y+1 < n) backTrack(0, y+1, sum+dp[y][x][1]);

            answer = Math.max(answer, sum+dp[y][x][1]);

            visitedMap[y][x] = 0;
            visitedMap[y-1][x] = 0;
            visitedMap[y][x-1] = 0;
        }

        //2
        if(x + 1 < m && y - 1 >= 0 && visitedMap[y][x] == 0 && visitedMap[y-1][x] == 0 && visitedMap[y][x+1] == 0) {
            visitedMap[y][x] = 2;
            visitedMap[y-1][x] = 1;
            visitedMap[y][x+1] = 1;

            if(x+1 < m) backTrack(x+1, y, sum+dp[y][x][2]);
            else if(y+1 < n) backTrack(0, y+1, sum+dp[y][x][2]);

            answer = Math.max(answer, sum+dp[y][x][2]);

            visitedMap[y][x] = 0;
            visitedMap[y-1][x] = 0;
            visitedMap[y][x+1] = 0;
        }

        //3
        if(x + 1 < m && y + 1 < n && visitedMap[y][x] == 0 && visitedMap[y+1][x] == 0 && visitedMap[y][x+1] == 0) {
            visitedMap[y][x] = 2;
            visitedMap[y+1][x] = 1;
            visitedMap[y][x+1] = 1;

            if(x+1 < m) backTrack(x+1, y, sum+dp[y][x][3]);
            else if(y+1 < n) backTrack(0, y+1, sum+dp[y][x][3]);

            answer = Math.max(answer, sum+dp[y][x][3]);

            visitedMap[y][x] = 0;
            visitedMap[y+1][x] = 0;
            visitedMap[y][x+1] = 0;
        }

        answer = Math.max(answer, sum);
    }
}
