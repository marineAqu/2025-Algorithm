import java.io.*;
import java.util.*;

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Node{
    int a, b, distance;

    Node(int a, int b, int distance){
        this.a = a;
        this.b = b;
        this.distance = distance;
    }
}

public class BaekJoon17472 {
    static int n, m, map[][], count = 2, bridge[][], answer = 0;
    static boolean visited[][];
    static int boss[];
    static PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
    static LinkedList<Point> island = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        bridge = new int[8][8];
        visited = new boolean[n][m];
        boss = new int[8];
        for(int i=2; i<8; i++) boss[i] = i;
        
        //input
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int r=0; r<m; r++) map[i][r] = Integer.parseInt(st.nextToken());
        }

        //1. 섬의 개수를 파악하고 인덱스로 바꾸기. (섬 1번, 2번...)
        for(int i=0; i<n; i++){
            for(int r=0; r<m; r++) {
                if(map[i][r] == 1) {
                    dfs(r, i);
                    island.add(new Point(r, i));
                    count++;
                }
            }
        }

        //2. 각 섬끼리 연결할 수 있는지, 가능하다면 비용은 얼마인지 체크. (교차 가능)
        //그래프 형태로 만들고

        //최소신장트리 만들기 문제다

        int temp = 2;
        for(Point now : island) {
            dfsBridge(now.x, now.y, temp++);
        }

        //이제 최소신장트리 만들기
        Node now;
        while (!queue.isEmpty()) {
            now = queue.poll();
            //System.out.println("while문: "+now.a +", "+now.b+", "+now.distance);

            if(now.distance < 2) continue;

            if(find(now.a) != find(now.b)){
                union(now.a, now.b);
                answer += now.distance;
            }
        }

        for(int i=3; i<count; i++){
            if(find(i) != find(2)) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(answer);
    }

    static void union(int a, int b){
        boss[find(a)] = find(boss[b]);
    }

    static int find(int a){
        if(boss[a] == a) return a;
        else return boss[a] = find(boss[a]);
    }

    //비용 계산
    static void addBridge(int x, int y, int index){
        //위쪽
        for(int i=y-1; i>=0; i--){
            if(map[i][x] == index) break;

            if(map[i][x] != 0){
                queue.add(new Node(index, map[i][x], y - 1 - i));
                break;
            }
        }

        //아래쪽
        for(int i=y+1; i<n; i++){
            if(map[i][x] == index) break;

            if(map[i][x] != 0){
                queue.add(new Node(index, map[i][x], i - (y+1)));
                break;
            }
        }

        //왼쪽
        for(int i=x-1; i>=0; i--){
            if(map[y][i] == index) break;

            if(map[y][i] != 0){
                queue.add(new Node(index, map[y][i], x - 1 - i));
                break;
            }
        }

        //오른쪽
        for(int i=x+1; i<m; i++){
            if(map[y][i] == index) break;

            if(map[y][i] != 0){
                queue.add(new Node(index, map[y][i], i - (x+1)));
                break;
            }
        }
    }

    static void dfsBridge(int x, int y, int index){
        visited[y][x] = true;
        addBridge(x, y, index);

        if(x+1 < m && !visited[y][x+1] && map[y][x+1] == index){
            dfsBridge(x+1, y, index);
        }

        if(x-1 >= 0 && !visited[y][x-1] && map[y][x-1] == index){
            dfsBridge(x-1, y, index);
        }

        if(y+1 < n && !visited[y+1][x] && map[y+1][x] == index){
            dfsBridge(x, y+1, index);
        }

        if(y-1 >= 0 && !visited[y-1][x] && map[y-1][x] == index){
            dfsBridge(x, y-1, index);
        }
    }

    //영역 파악하기
    static void dfs(int x, int y){
        map[y][x] = count;

        if(x+1 < m && map[y][x+1] == 1){
            dfs(x+1, y);
        }

        if(x-1 >= 0 && map[y][x-1] == 1){
            dfs(x-1, y);
        }

        if(y+1 < n && map[y+1][x] == 1){
            dfs(x, y+1);
        }

        if(y-1 >= 0 && map[y-1][x] == 1){
            dfs(x, y-1);
        }
    }
}
