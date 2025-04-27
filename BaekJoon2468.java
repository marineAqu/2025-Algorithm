import java.util.*;
import java.lang.*;
import java.io.*;

class BaekJoon2468 {
    static int n, map[][];
    static boolean visited[][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int count, maxCount = 1;

        map = new int[n][n];
        visited = new boolean[n][n];

        //input
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int r=0; r<n; r++){
                map[i][r] = Integer.parseInt(st.nextToken());
            }
        }

        //높이는 최대 100
        //n은 최대 100 -> 완전탐색 1회 10,000
        //모든 높이 탐색: 1,000,000 회 시간초과 ㄴ
        
        for(int i=1; i<=100; i++){
            //모든 높이
            count = 0;
            for(int r=0; r<n; r++) Arrays.fill(visited[r], false);
            
            for(int r=0; r<n; r++){
                for(int k=0; k<n; k++){
                    if(!visited[r][k] && map[r][k] > i){
                        count++;
                        dfs(k, r, i);
                    }
                }
            }

            maxCount = Math.max(maxCount, count);
        }

        System.out.print(maxCount);
    }

    static void dfs(int x, int y, int h){
        visited[y][x] = true;
        
        if(x-1 >= 0 && !visited[y][x-1] && map[y][x-1] > h){
            dfs(x-1, y, h);
        }

        if(y-1 >= 0 && !visited[y-1][x] && map[y-1][x] > h){
            dfs(x, y-1, h);
        }

        if(x+1 < n && !visited[y][x+1] && map[y][x+1] > h){
            dfs(x+1, y, h);
        }

        if(y+1 < n && !visited[y+1][x] && map[y+1][x] > h){
            dfs(x, y+1, h);
        }
    }
}
