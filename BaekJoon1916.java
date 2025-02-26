import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

class Edge{
    int a, b, cost;

    Edge(int a, int b, int cost){
        this.a = a;
        this.b = b;
        this.cost = cost;
    }
}

//다익스트라는 우선순위 큐로 이미 최단거리가 저장되기 때문에 한번 방문한 곳은 재방문할 필요가 없다.
//따라서 visited로 이미 방문한 곳은 스킵해야 시간초과가 나지 않는다.
// **다익스트라 시간초과에 있어 우선순위큐, visited 사용 꼭 기억하기

public class BaekJoon1916 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> queue = new PriorityQueue<Edge>((o1, o2) -> o1.cost - o2.cost);
        LinkedList<Edge> adj[] = new LinkedList[n+1];
        for(int i=0; i<=n; i++) adj[i] = new LinkedList<Edge>();

        boolean[] visited = new boolean[n+1];
        int cost_info[] = new int[n+1];
        Arrays.fill(cost_info, Integer.MAX_VALUE);

        //출발점과 도착점이 지정되어있다
        //다익스트라 문제
        int a, b, cost;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            adj[a].add(new Edge(a, b, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startNum = Integer.parseInt(st.nextToken());
        int endNum = Integer.parseInt(st.nextToken());

        queue.add(new Edge(startNum, startNum, 0));
        Edge e;
        cost_info[startNum] = 0;

        while (!queue.isEmpty()) {
            e = queue.poll();

            if(visited[e.a] == true) continue;
            visited[e.a] = true;

            for(Edge now : adj[e.a]){
                if(cost_info[now.b] > e.cost + now.cost){
                    cost_info[now.b] = e.cost + now.cost;
                    queue.add(new Edge(now.b, now.b, cost_info[now.b]));
                }
            }
        }

        System.out.println(cost_info[endNum]);
    }
}
