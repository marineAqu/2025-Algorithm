import java.io.*;
import java.util.*;

public class BaekJoon2668 {
    
    static int map[];
    static int visited[];
    static int index = 1, start;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //사이클 찾아서 갯수 구하면 되는 문제
        int n = Integer.parseInt(br.readLine());
        map = new int[n+1];
        visited = new int[n+1];

        //입력
        for(int i=1; i<=n; i++){
            map[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=n; i++){
            if(visited[i] == 0) {
                dfs(i);
                index++;
            }
        }

        System.out.println(queue.size());
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        
    }

    static void dfs(int now){
        if(visited[now] == index){
            //사이클 존재함
            start = now;
            cal(now);

            return;
        }

        if(visited[now] != 0) return;

        visited[now] = index;

        dfs(map[now]);
    }

    static void cal(int now){
        queue.add(now);

        if(map[now] == start) return;

        cal(map[now]);
    }
}
