import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class XY{
    int x, y;
    XY(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BaekJoon2206 {

    static Queue<XY> queue = new LinkedList<>();
    static int visited[][][];
    static String map[];
    static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new String[n];
        visited = new int[n][m][2];

        for(int i=0; i<n; i++) map[i] = br.readLine();
        for(int i=0; i<n; i++) 
            for(int r=0; r<m; r++) {
                visited[i][r][0] = 1000001;
                visited[i][r][1] = 1000001;
            }

        visited[0][0][0] = 1;
        dfs();

        //출력
        if(visited[n-1][m-1][0] == 1000001 && visited[n-1][m-1][1] == 1000001) System.out.print(-1);
        else System.out.print(Math.min(visited[n-1][m-1][0], visited[n-1][m-1][1]));
    }

    static void dfs() {
        queue.add(new XY(0, 0));

        while (!queue.isEmpty()) {
            XY now = queue.poll();

            //1. 벽 안 뚫고
            if(now.x + 1 < m && map[now.y].charAt(now.x + 1) == '0' && visited[now.y][now.x+1][0] > visited[now.y][now.x][0] + 1){
                visited[now.y][now.x+1][0] = visited[now.y][now.x][0] + 1;
                queue.add(new XY(now.x+1, now.y));
            }

            if(now.y + 1 < n && map[now.y + 1].charAt(now.x) == '0' && visited[now.y + 1][now.x][0] > visited[now.y][now.x][0] + 1){
                visited[now.y + 1][now.x][0] = visited[now.y][now.x][0] + 1;
                queue.add(new XY(now.x, now.y + 1));
            }

            if(now.x - 1 > -1 && map[now.y].charAt(now.x - 1) == '0' && visited[now.y][now.x-1][0] > visited[now.y][now.x][0] + 1){
                visited[now.y][now.x-1][0] = visited[now.y][now.x][0] + 1;
                queue.add(new XY(now.x-1, now.y));
            }

            if(now.y - 1 > -1 && map[now.y - 1].charAt(now.x) == '0' && visited[now.y - 1][now.x][0] > visited[now.y][now.x][0] + 1){
                visited[now.y - 1][now.x][0] = visited[now.y][now.x][0] + 1;
                queue.add(new XY(now.x, now.y - 1));
            }

            //2. 벽 뚫고
            if(now.x + 1 < m && map[now.y].charAt(now.x + 1) == '0' && visited[now.y][now.x+1][1] > visited[now.y][now.x][1] + 1){
                visited[now.y][now.x+1][1] = visited[now.y][now.x][1] + 1;
                queue.add(new XY(now.x+1, now.y));
            }

            if(now.y + 1 < n && map[now.y + 1].charAt(now.x) == '0' && visited[now.y + 1][now.x][1] > visited[now.y][now.x][1] + 1){
                visited[now.y + 1][now.x][1] = visited[now.y][now.x][1] + 1;
                queue.add(new XY(now.x, now.y + 1));
            }

            if(now.x - 1 > -1 && map[now.y].charAt(now.x - 1) == '0' && visited[now.y][now.x-1][1] > visited[now.y][now.x][1] + 1){
                visited[now.y][now.x-1][1] = visited[now.y][now.x][1] + 1;
                queue.add(new XY(now.x-1, now.y));
            }

            if(now.y - 1 > -1 && map[now.y - 1].charAt(now.x) == '0' && visited[now.y - 1][now.x][1] > visited[now.y][now.x][1] + 1){
                visited[now.y - 1][now.x][1] = visited[now.y][now.x][1] + 1;
                queue.add(new XY(now.x, now.y - 1));
            }

            //3. 지금 벽 뚫기
            if(now.x + 1 < m && map[now.y].charAt(now.x + 1) == '1' && visited[now.y][now.x+1][1] > visited[now.y][now.x][0] + 1){
                visited[now.y][now.x+1][1] = visited[now.y][now.x][0] + 1;
                queue.add(new XY(now.x+1, now.y));
            }

            if(now.y + 1 < n && map[now.y + 1].charAt(now.x) == '1' && visited[now.y + 1][now.x][1] > visited[now.y][now.x][0] + 1){
                visited[now.y + 1][now.x][1] = visited[now.y][now.x][0] + 1;
                queue.add(new XY(now.x, now.y + 1));
            }

            if(now.x - 1 > -1 && map[now.y].charAt(now.x - 1) == '1' && visited[now.y][now.x-1][1] > visited[now.y][now.x][0] + 1){
                visited[now.y][now.x-1][1] = visited[now.y][now.x][0] + 1;
                queue.add(new XY(now.x-1, now.y));
            }

            if(now.y - 1 > -1 && map[now.y - 1].charAt(now.x) == '1' && visited[now.y - 1][now.x][1] > visited[now.y][now.x][0] + 1){
                visited[now.y - 1][now.x][1] = visited[now.y][now.x][0] + 1;
                queue.add(new XY(now.x, now.y - 1));
            }
        }
    }
}
