import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class node3{
    int x, y;
    node3(int x, int y){
        this.x = x;
        this.y = y;
    }
}

//보완할 점: 적록색약이 아닌 사람 먼저 계산한 뒤, 모든 G를 R로 바꾸고 동일 함수로 계산하면 된다.

public class BaekJoon10026 {
    static Queue<node3> queue = new LinkedList<>();
    static boolean visited[][];
    static int n;
    static int count = 0;
    static int rgEqualcount = 0;
    static String[] line;

    public static void main(String args[]) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        line = new String[n];
        visited = new boolean[n][n];

        //입력
        for(int i=0; i<n; i++){
            line[i] = br.readLine();
        }

        //그냥 visited랑 같이 쓰고 내가 R이면 인접한 모든 R을 검사한다음 종료해야할것같다
        //그다음에 또 bfs에서 큐에서 꺼내서 아직 visited가 false이면 얘로 또 모든인접한거 확인하고

        bfs(0, 0);

        queue.clear();
        visited = new boolean[n][n];

        bfsForGB(0, 0);
        System.out.print(count+" "+rgEqualcount);

    }

    // 아래, 오른쪽으로만 가면 안된다... 예제1번 B를 보면 왼쪽에 있는 걸 체크를 못함
    static void dfs(int x, int y){
        visited[y][x] = true;

        //아래로
        if(y + 1 < n && visited[y+1][x] == false){
            if(line[y+1].charAt(x) != line[y].charAt(x)){
                queue.add(new node3(x, y+1));
            }

            else dfs(x, y+1);
        }

        //위로
        if(y - 1 >= 0 && visited[y-1][x] == false){
            if(line[y-1].charAt(x) != line[y].charAt(x)){
                queue.add(new node3(x, y-1));
            }

            else dfs(x, y-1);
        }

        //오른쪽으로
        if(x + 1 < n && visited[y][x+1] == false){
            if(line[y].charAt(x+1) != line[y].charAt(x)){
                queue.add(new node3(x+1, y));
            }

            else dfs(x+1, y);
        }

        //왼쪽으로
        if(x - 1 >= 0 && visited[y][x-1] == false){
            if(line[y].charAt(x-1) != line[y].charAt(x)){
                queue.add(new node3(x-1, y));
            }

            else dfs(x-1, y);
        }
    }

    static void bfs(int x, int y){
        queue.add(new node3(x, y));
        
        while (!queue.isEmpty()) {
            node3 now = queue.poll();

            if(visited[now.y][now.x] == false) {
                dfs(now.x, now.y);
                count++;
            }
        }
    }

    static void dfsForGB(int x, int y){
        visited[y][x] = true;

        //아래로
        if(y + 1 < n && visited[y+1][x] == false){
            if(Math.abs(line[y+1].charAt(x) - line[y].charAt(x)) != 11 && Math.abs(line[y+1].charAt(x) - line[y].charAt(x)) != 0){
                queue.add(new node3(x, y+1));
            }

            else dfsForGB(x, y+1);
        }

        //위로
        if(y - 1 >= 0 && visited[y-1][x] == false){
            if(Math.abs(line[y-1].charAt(x) - line[y].charAt(x)) != 11 && Math.abs(line[y-1].charAt(x) - line[y].charAt(x)) != 0){
                queue.add(new node3(x, y-1));
            }

            else dfsForGB(x, y-1);
        }

        //오른쪽으로
        if(x + 1 < n && visited[y][x+1] == false){
            if(Math.abs(line[y].charAt(x+1) - line[y].charAt(x)) != 11 && Math.abs(line[y].charAt(x+1) - line[y].charAt(x)) != 0){
                queue.add(new node3(x+1, y));
            }

            else dfsForGB(x+1, y);
        }

        //왼쪽으로
        if(x - 1 >= 0 && visited[y][x-1] == false){
            if(Math.abs(line[y].charAt(x-1) - line[y].charAt(x)) != 11 && Math.abs(line[y].charAt(x-1) - line[y].charAt(x)) != 0){
                queue.add(new node3(x-1, y));
            }

            else dfsForGB(x-1, y);
        }
    }

    static void bfsForGB(int x, int y){
        queue.add(new node3(x, y));
        
        while (!queue.isEmpty()) {
            node3 now = queue.poll();

            if(visited[now.y][now.x] == false) {
                dfsForGB(now.x, now.y);
                rgEqualcount++;
            }
        }
    }
    
}
