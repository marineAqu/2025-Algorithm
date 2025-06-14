import java.util.*;
import java.lang.*;
import java.io.*;

class BackJoon1189 {
    static int r, c, k;
    static int count = 0;
    static boolean visited[][];
    static char map[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException{
        //n번째로 작은 줄어드는 수 출력하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new char[r][c];
        visited = new boolean[r][c];

        String line;
        for(int i=0; i<r; i++){
            line = br.readLine();
            
            for(int q=0; q<c; q++){
                map[i][q] = line.charAt(q);
            }
        }

        dfs(r-1, 0, 1);

        //거리가 k인 가짓수

        System.out.print(count);
    }

    //백트래킹
    static void dfs(int y, int x, int distance){
        
        if(distance > k) return;
        
        if(y == 0 && x == c-1){
            if(distance == k) count++;
            return;
        }
        
        visited[y][x] = true;

        for(int i=0; i<4; i++){
            if(y+dy[i] < 0 || y+dy[i] >= r || x+dx[i] < 0 || x+dx[i] >= c
               || visited[y+dy[i]][x+dx[i]] || map[y+dy[i]][x+dx[i]] == 'T')
                continue;

            dfs(y+dy[i], x+dx[i], distance+1);
        }

        visited[y][x] = false;
    }
}
