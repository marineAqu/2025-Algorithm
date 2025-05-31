import java.util.*;
import java.lang.*;
import java.io.*;

class BackJoon11724 {
    static int n, m;
    static boolean visited[];
    static LinkedList<Integer> adj[];
    static Queue<Integer> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        
        n = Integer.parseInt(st.nextToken()); //정점
        m = Integer.parseInt(st.nextToken()); // 간선
        int count = 0;

        visited = new boolean[n+1];
        adj = new LinkedList[n+1];
        for(int i=0; i<=n; i++) adj[i] = new LinkedList<>();
        
        int a, b;

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken()); 

            adj[a].add(b);
            adj[b].add(a);
        }

        //계산
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                queue.add(i);
                bfs();
                count++;
            }
        }

        System.out.print(count);
    }

    static void bfs(){
        int now;
        while(!queue.isEmpty()){
            now = queue.poll();
            
            for(int next : adj[now]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
