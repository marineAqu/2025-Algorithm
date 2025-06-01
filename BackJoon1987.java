import java.util.*;
import java.lang.*;
import java.io.*;

class BackJoon1987 {
    static String[] map;
    static int maxCount = 0, r, c;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static boolean alp[] = new boolean[26];
    static boolean visited[][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new String[r];
        visited = new boolean[r][c];

        for(int i=0; i<r; i++) map[i] = br.readLine();

        dfs(0, 0, 1);

        System.out.print(maxCount);
    }

    static void dfs(int y, int x, int count){
        maxCount = Math.max(maxCount, count);
        alp[(int)map[y].charAt(x) - (int)'A'] = true;
        
        for(int i=0; i<4; i++){
            if(y+dy[i] < 0 || y+dy[i] >= r || x+dx[i] < 0 || x+dx[i] >= c || visited[y+dy[i]][x+dx[i]]) continue;
            if(alp[(int)map[y+dy[i]].charAt(x+dx[i]) - (int)'A']) continue;

            dfs(y+dy[i], x+dx[i], count+1);
        }

        alp[(int)map[y].charAt(x) - (int)'A'] = false;
    }
}
