import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;


class Node{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BaekJoon14502 {
    
    static int map[][];
    static int max_safe_space = 0;
    static int base_val;
    static boolean visited[][];
    static int n, m;
    static int count;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        base_val = n*m - 3; //기본 0의 개수 (벽 3개를 뺀)
        LinkedList<Node> virus = new LinkedList<Node>();

        //map 만들기
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int k=0; k<m; k++){
                map[i][k] = Integer.parseInt(st.nextToken());
                if(map[i][k] != 0) base_val--;
                if(map[i][k] == 2) virus.add(new Node(k, i));
            }
        }

        //브루트포스/시뮬 문제인가........... 걍 벽 세개를 세우는 모든 조합을 계산?,,,,,,
        //맵의 최대크기 64. 조합 수: 64x63x62 = 249,984

        //바이러스 좌표를 링크드리스트에 모두 저장, 모든 조합마다 바이러스를 꺼내 막혀있기는 한지 확인하기


        //x, y 전부 +1해주면 안되고 한번씩 +1해주어야 한다. 또 겹치면안된다
        //(0,0) (0,1) (0,2) -> (0,1)(0,2)(0,3) -> (0, 2)(0,3)(1,0)

        for(int i=0; i<n * m - 2; i++){
            for(int q=i+1; q<n * m - 1; q++){
                for(int v=q+1; v<n * m; v++){

                    if(map[i / m][i % m] != 0) continue;
                    if(map[q / m][q % m] != 0) continue;
                    if(map[v / m][v % m] != 0) continue;
                                
                    for(int u=0; u<n; u++) Arrays.fill(visited[u], false);

                    map[i / m][i % m] = 1;
                    map[q / m][q % m] = 1;
                    map[v / m][v % m] = 1;

                    //계산
                    count = 0;
                    for(Node now : virus) dfs(now.x, now.y);
                    max_safe_space = Math.max(max_safe_space, base_val - count);

                    //복구
                    map[i / m][i % m] = 0;
                    map[q / m][q % m] = 0;
                    map[v / m][v % m] = 0;
                }
            }
        }
    
        //미리 벽의 개수와 바이러스의 개수를 세어두고, n*m에서 뺀다
        //모든 조합에 대하여 각각 바이러스가 퍼진 뒤 바이러스가 점령한 count를 세고, 이 값을 전체에서 빼 안전구역을 센다.

        System.out.println(max_safe_space);
    }

    //visited....................... 
    static void dfs(int x, int y){
        if(x+1 < m && map[y][x+1] == 0 && visited[y][x+1] == false){
            count++;
            visited[y][x+1] = true;
            dfs(x+1, y);
        }

        if(y+1 < n && map[y+1][x] == 0 && visited[y+1][x] == false){
            count++;
            visited[y+1][x] = true;
            dfs(x, y+1);
        }

        if(x-1 >= 0 && map[y][x-1] == 0 && visited[y][x-1] == false){
            count++;
            visited[y][x-1] = true;
            dfs(x-1, y);
        }

        if(y-1 >= 0 && map[y-1][x] == 0 && visited[y-1][x] == false){
            count++;
            visited[y-1][x] = true;
            dfs(x, y-1);
        }
    }
}
