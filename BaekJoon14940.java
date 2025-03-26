import java.io.*;
import java.util.*;

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BaekJoon14940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int map[][] = new int[n][m];
        int distance[][] = new int[n][m];
        for(int i=0; i<n; i++) for(int r=0; r<m; r++) distance[i][r] = 1000001;
        Queue<Point> queue = new LinkedList<>();

        //입력
        //0은 갈 수 없음, 1은 갈 수 있음
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int r=0; r<m; r++){
                map[i][r] = Integer.parseInt(st.nextToken());
                if(map[i][r] == 2){
                    queue.add(new Point(r, i));
                    distance[i][r] = 0;
                }
            }
        }

        //모든 지점에서 한 곳으로 가는 거리니까 다익스트라가 맞을 것 같다

        

        Point now;
        while(!queue.isEmpty()){
            now = queue.poll();

            if(now.x+1 < m && map[now.y][now.x + 1] == 1){
                if(distance[now.y][now.x + 1] > distance[now.y][now.x] + 1){
                    distance[now.y][now.x + 1] = distance[now.y][now.x] + 1;
                    queue.add(new Point(now.x + 1, now.y));
                }
            }

            if(now.y+1 < n && map[now.y + 1][now.x] == 1){
                if(distance[now.y + 1][now.x] > distance[now.y][now.x] + 1){
                    distance[now.y + 1][now.x] = distance[now.y][now.x] + 1;
                    queue.add(new Point(now.x, now.y + 1));
                }
            }

            if(now.x-1 >= 0 && map[now.y][now.x - 1] == 1){
                if(distance[now.y][now.x - 1] > distance[now.y][now.x] + 1){
                    distance[now.y][now.x - 1] = distance[now.y][now.x] + 1;
                    queue.add(new Point(now.x - 1, now.y));
                }
            }

            if(now.y-1 >= 0 && map[now.y - 1][now.x] == 1){
                if(distance[now.y - 1][now.x] > distance[now.y][now.x] + 1){
                    distance[now.y - 1][now.x] = distance[now.y][now.x] + 1;
                    queue.add(new Point(now.x, now.y - 1));
                }
            }
        }

        //출력
        for(int i=0; i<n; i++){
            for(int r=0; r<m; r++){
                if(map[i][r] == 0) System.out.print("0 ");
                else if(distance[i][r] == 1000001) System.out.print("-1 ");
                else System.out.print(distance[i][r]+" ");
            }
            System.out.println();
        }
    }
}
