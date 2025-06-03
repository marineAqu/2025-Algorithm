import java.util.*;

import java.io.*;

class Point{
    int y, x;
    Point(int y, int x){
        this.y = y;
        this.x = x;
    }
}

class BaekJoon21736{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        String map[] = new String[n];
        boolean visited[][] = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            map[i] = br.readLine();

            if(!queue.isEmpty()) continue;
            for(int r=0; r<m; r++){
                if(map[i].charAt(r) == 'I') queue.add(new Point(i, r));
            }
        }

        Point now;
        while(!queue.isEmpty()){
            now = queue.poll();

            if(visited[now.y][now.x]) continue;
            visited[now.y][now.x] = true;
            if(map[now.y].charAt(now.x) == 'P') count++;

            for(int i=0; i<4; i++){
                if(dx[i]+now.x < 0 || dx[i]+now.x >= m || dy[i]+now.y < 0 || dy[i]+now.y >= n || visited[now.y+dy[i]][now.x+dx[i]]) continue;

                if(map[now.y+dy[i]].charAt(dx[i]+now.x) == 'X') continue;
                else queue.add(new Point(now.y+dy[i], dx[i]+now.x));
            }
        }

        if(count == 0) System.out.println("TT");
        else System.out.println(count);
    }
}