import java.util.*;
import java.lang.*;
import java.io.*;

class Point{
    int x, y, distance;

    Point(int x, int y, int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

class BackJoon3055 {
    static int min = Integer.MAX_VALUE;
    static int water[][];
    static boolean visited[][];
    static int r, c;
    static PriorityQueue<Point> wq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
    static PriorityQueue<Point> mq  = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static Point arrive;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        String map;
        visited = new boolean[r][c];
        water = new int[r][c];
        for(int i=0; i<r; i++) Arrays.fill(water[i], -1);

        for(int i=0; i<r; i++){
            map = br.readLine();
            for(int w=0; w<c; w++){
                if(map.charAt(w) == '*') {
                    wq.add(new Point(w, i, 0));
                    water[i][w] = 0;
                }

                //고슴도치 위치
                if(map.charAt(w) == 'S') {
                    mq.add(new Point(w, i, 0));
                    water[i][w] = -2;
                }

                //비버의 굴
                if(map.charAt(w) == 'D') {
                    arrive = new Point(w, i, 0);
                    water[i][w] = -2;
                }

                //돌
                if(map.charAt(w) == 'X') {
                    water[i][w] = 0;
                }
            }
        }

        checkWater();
        
        moveMe();

        if(min == Integer.MAX_VALUE) System.out.print("KAKTUS");
        else System.out.print(min);
    }

    
    public static void moveMe(){
        Point now;

        while(!mq.isEmpty()){
            now = mq.poll();
            
            //도착
            if(now.y == arrive.y && now.x == arrive.x) {
                min = Math.min(min, now.distance);
                return;
            }
            
            //이동
            for(int i=0; i<4; i++){
                if(now.x + dx[i] < 0 || now.x + dx[i] >= c || 
                   now.y + dy[i] < 0 || now.y + dy[i] >= r || 
                   (water[now.y + dy[i]][now.x + dx[i]] <= now.distance + 1 && water[now.y + dy[i]][now.x + dx[i]] >= 0) ||
                   visited[now.y + dy[i]][now.x + dx[i]]
                  ){
                    continue;
                   }

                visited[now.y + dy[i]][now.x + dx[i]] = true;
                mq.add(new Point(now.x + dx[i], now.y + dy[i], now.distance + 1));
            }
        }
    }

    
    public static void checkWater(){
        Point now;
        
        while(!wq.isEmpty()){
            now = wq.poll();
            
            for(int i=0; i<4; i++){
                if(now.x + dx[i] < 0 || now.x + dx[i] >= c || 
                   now.y + dy[i] < 0 || now.y + dy[i] >= r || water[now.y + dy[i]][now.x + dx[i]] != -1){
                    continue;
                }

                water[now.y + dy[i]][now.x + dx[i]] = now.distance + 1;
                wq.add(new Point(now.x + dx[i], now.y + dy[i], now.distance + 1));
            }
        }
    }
}
