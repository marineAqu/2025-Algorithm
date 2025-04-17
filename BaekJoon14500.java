import java.io.*;
import java.util.*;

public class BaekJoon14500 {
    static int n, m, map[][];
    static boolean visited[][];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        //입력
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int r=0; r<m; r++){
                map[i][r] = Integer.parseInt(st.nextToken());
            }
        }

        //수행
        for(int i=0; i<n; i++){
            for(int r=0; r<m; r++){
                visited[i][r] = true;
                dfs(r, i, 0, map[i][r]);
                visited[i][r] = false;
            }
        }

        //4*4*4*4*500*500 = 64,000,000 -> 6천만
        //ㅗ,ㅜ 구하는 거 500,000정도
        //시간초과는 안 나겠다

        //각 도형은 4방향으로 돌릴 수 있음
        //n, m 최대 500에 2초
        //250,000인데
        //4개가 붙어있어야한다

        int temp;
        for(int i=0; i<n; i++){
            for(int r=0; r<m-2; r++){
                temp = map[i][r] + map[i][r+1] + map[i][r+2];
                if(i>0) answer = Math.max(answer, temp + map[i-1][r+1]);
                if(i<n-1) answer = Math.max(answer, temp + map[i+1][r+1]);
            }
        }

        for(int i=0; i<n-2; i++){
            for(int r=0; r<m; r++){
                temp = map[i][r] + map[i+1][r] + map[i+2][r];
                if(r>0) answer = Math.max(answer, temp + map[i+1][r-1]);
                if(r<m-1) answer = Math.max(answer, temp + map[i+1][r+1]);
            }
        }

        System.out.println(answer);
    }

    //ㅜ, ㅗ 모양은 dfs가 아니라 bfs 여야만 가능하다. 쭉 이어진 게 아니라서
    //ㅜ, ㅗ 는 별도로 계산하자
    static void dfs(int x, int y, int count, int sum){
        if(count == 3){
            answer = Math.max(answer, sum);            
            return;
        }

        if(x+1 < m && !visited[y][x+1]){
            visited[y][x+1] = true;
            dfs(x+1, y, count+1, sum + map[y][x+1]);
            visited[y][x+1] = false;
        }

        if(x-1 >= 0 && !visited[y][x-1]){
            visited[y][x-1] = true;
            dfs(x-1, y, count+1, sum + map[y][x-1]);
            visited[y][x-1] = false;
        }

        if(y+1 < n && !visited[y+1][x]){
            visited[y+1][x] = true;
            dfs(x, y+1, count+1, sum + map[y+1][x]);
            visited[y+1][x] = false;
        }

        if(y-1 >= 0 && !visited[y-1][x]){
            visited[y-1][x] = true;
            dfs(x, y-1, count+1, sum + map[y-1][x]);
            visited[y-1][x] = false;
        }
    }
}
