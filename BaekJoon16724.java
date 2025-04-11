import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon16724 {
    static int n, m;
    static String[] maps;
    static int visited[][];
    static int cycleNum = 1;
    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maps = new String[n];
        visited = new int[n][m];

        for(int i=0; i<n; i++) maps[i] = br.readLine();

        //사이클의 개수를 찾으면 되는 문제같은데

        for(int i=0; i<n; i++){
            for(int r=0; r<m; r++){
                if(visited[i][r] == 0){
                    dfs(i, r);

                    cycleNum++;
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int y, int x){
        if(visited[y][x] != 0){
            //사이클이 맞음
            if(visited[y][x] == cycleNum){
                count++;
            }

            //사이클이 아님
            return;
        }

        visited[y][x] = cycleNum;

        if(maps[y].charAt(x) == 'R' && x+1 < m){
            dfs(y, x+1);
        }

        else if(maps[y].charAt(x) == 'D' && y+1 < n){
            dfs(y+1, x);
        }

        else if(maps[y].charAt(x) == 'L' && x-1 >= 0){
            dfs(y, x-1);
        }

        else if(maps[y].charAt(x) == 'U' && y-1 >= 0){
            dfs(y-1, x);
        }
    }
}
