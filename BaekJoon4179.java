import java.io.*;
import java.util.*;

class Fire{
    int y, x, time;

    Fire(int y, int x, int time){
        this.y = y;
        this.x = x;
        this.time = time;
    }
}

public class BaekJoon4179 {
    static PriorityQueue<Fire> queue = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
    static PriorityQueue<Fire> pqueue = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
    static int fireVisited[][], visited[][], r, c;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;
        String line;
        fireVisited = new int[r][c]; //-1은 지나갈 수 없는 공간, 숫자는 해당 분일 때 불이 여기에 번짐
        visited = new int[r][c];
        for(int i=0; i<r; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
            Arrays.fill(fireVisited[i], Integer.MAX_VALUE);
        }

        for(int i=0; i<r; i++){
            line = br.readLine();
            for(int w=0; w<c; w++) {
                if(line.charAt(w) == '#') {
                    fireVisited[i][w] = -1;
                    visited[i][w] = -1;
                }
                else if(line.charAt(w) == 'F') queue.add(new Fire(i, w, 0));
                else if(line.charAt(w) == 'J') pqueue.add(new Fire(i, w, 0));
            }
        }

        fireBFS(); //불 번지는 시간 체크해두기
        personBFS();

        //탈출 가능하면 가장 빠른 탈출 시간 출력
        //불도 함께 확산함에 유의해야한다.
        //그러면 visited에 불 확산 경로를 미리 작성해두자 (2분일 때 이 자리에 불이 번진다면 2 적기 같은 식)
        
        for(int w=0; w<c; w++) if(visited[0][w] >= 0) answer = Math.min(answer, visited[0][w]);
        for(int i=1; i<r-1; i++){
            if(visited[i][0] >= 0) answer = Math.min(answer, visited[i][0]);
            if(visited[i][c-1] >= 0) answer = Math.min(answer, visited[i][c-1]);
        }
        for(int w=0; w<c; w++) if(visited[r-1][w] >= 0) answer = Math.min(answer, visited[r-1][w]);

        if(answer == Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
        else System.out.println(answer+1);
    }

    //불 확산 표시
    static void fireBFS(){
        while (!queue.isEmpty()) {
            Fire now = queue.poll();
            if(fireVisited[now.y][now.x] <= now.time) continue;
            fireVisited[now.y][now.x] = now.time;

            for(int i=0; i<4; i++){
                if(now.y+dy[i] < 0 || now.y+dy[i] >= r || now.x+dx[i] < 0 || now.x+dx[i] >= c || fireVisited[now.y+dy[i]][now.x+dx[i]] < now.time + 1) continue;
    
                queue.add(new Fire(now.y+dy[i], now.x+dx[i], now.time+1));
            }
        }
    }

    //2,000,000 
    static void personBFS(){
        while (!pqueue.isEmpty()) {
            Fire now = pqueue.poll();
            if(visited[now.y][now.x] <= now.time) continue;
            visited[now.y][now.x] = now.time;

            for(int i=0; i<4; i++){
                if(now.y+dy[i] < 0 || now.y+dy[i] >= r || now.x+dx[i] < 0 || now.x+dx[i] >= c || 
                    fireVisited[now.y+dy[i]][now.x+dx[i]] <= now.time+1 || visited[now.y+dy[i]][now.x+dx[i]] <= now.time+1) continue;
    
                pqueue.add(new Fire(now.y+dy[i], now.x+dx[i], now.time+1));
            }  
        }
    }
}