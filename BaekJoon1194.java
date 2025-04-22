import java.io.*;
import java.util.*;

class Node{
    int x, y, count, key;
    Node(int x, int y, int count, int key){
        this.x = x;
        this.y = y;
        this.count = count;
        this.key = key;
    }
}

public class BaekJoon1194 {
    static String[] map;
    static boolean [][][] visited;
    static int n, m;
    static int answer = Integer.MAX_VALUE;
    static Queue<Node> queue = new LinkedList<>();
    static int temp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new String[n];
        visited = new boolean[n][m][65]; //열쇠 없이, A열쇠 가지고, B열쇠 가지고
                                    //그런데 A B 열쇠를 동시에 가져야만 통과할 수 있는 곳도 있고

        //input
        for(int i=0; i<n; i++){
            map[i] = br.readLine();
            for(int r=0; r<m; r++){
                //if(map[i].charAt(r) == '0') start = new Point(r, i);
                if(map[i].charAt(r) == '0') queue.add(new Node(r, i, 0, 0));
            }
        }

        //미로 탈출하는 데 드는 이동횟수의 최솟값
        //n, m 은 각각 50보다 같거나 작다

        //완전탐색으로 하면
        //일단 전체 맵을 방문하는 것은 2500
        //4^2500 ??? 
        //시작지점은 하나, 도착지점은 여러개일 수 있다

        //그냥 진짜 모든 경우를 계산해야 할 것같은데 무한루프로 같은 자리를 도는 경우를 어떻게 제거하나
        //이미 방문한 곳을 또 방문했다고 return할 순 없고, 
        //나한테 변한 게 없는데 (열쇠를 추가로 얻지 못했는데) 같은 자리를 방문한 경우에는 return해야

        //dfs(start.x, start.y, 0, false, false, false, false, false, false);
        bfs();

        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    static void bfs(){
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            
            if(map[now.y].charAt(now.x) == '1') {
                answer = Math.min(answer, now.count);
                continue;
            }

            if(map[now.y].charAt(now.x) == '#') continue;

            //문인 경우
            if((int)map[now.y].charAt(now.x) > 64 && (int)map[now.y].charAt(now.x) < 97) {
                //문인 경우
                temp = (int)Math.pow(2, ((int)map[now.y].charAt(now.x)) - 'A');
                if((temp & now.key) != temp){
                    continue;
                }
            }

            //열쇠인 경우 (해당 열쇠가 없었던 경우에만 추가)
            if((int)map[now.y].charAt(now.x) > 96){
                temp = (int) Math.pow(2, ((int)map[now.y].charAt(now.x)) - 'a');
                
                if((temp & now.key) != temp) now.key += temp;
            }

            //열쇠 상태변화 없이 방문한 곳을 또 방문했다면 return
            if(visited[now.y][now.x][now.key]) continue;
            visited[now.y][now.x][now.key] = true;

            //이동하기
            //상
            if(now.y-1 >= 0){
                queue.add(new Node(now.x, now.y-1, now.count+1, now.key));
            }
    
            //하
            if(now.y+1 < n){
                queue.add(new Node(now.x, now.y+1, now.count+1, now.key));
            }
    
            //왼
            if(now.x-1 >= 0){
                queue.add(new Node(now.x-1, now.y, now.count+1, now.key));
            }
    
            //오
            if(now.x+1 < m){
                queue.add(new Node(now.x+1, now.y, now.count+1, now.key));
            }
        }    
    }
}
