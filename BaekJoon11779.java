import java.io.*;
import java.util.*;

class Edge{
    int s, e, cost;

    Edge(int s, int e, int cost){
        this.s = s;
        this.e = e;
        this.cost = cost;
    }
}

public class BaekJoon11779 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>((o1, o2) -> o1.cost - o2.cost);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); //도시 최대 1000
        int m = Integer.parseInt(br.readLine()); //버스 최대 100,000
        int a, b, c;

        int distance[][] = new int[n+1][2]; //[0]은 a에서 i까지 거리, [1]은 바로 직전 거친 곳
        LinkedList<Edge> adj[] = new LinkedList[n+1];
        for(int i=0; i<=n; i++) adj[i] = new LinkedList<>();
        for(int i=0; i<=n; i++) distance[i][0] = 100000001;

        //입력
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            adj[a].add(new Edge(a, b, c));
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); //시작
        b = Integer.parseInt(st.nextToken()); //끝

        queue.add(new Edge(a, a, 0));
        distance[a][0] = 0;
        distance[a][1] = a;
        
        Edge now;
        while (!queue.isEmpty()) {
            now = queue.poll();

            if(now.cost > distance[now.e][0]) continue; //시간초과 대비

            for(Edge next : adj[now.e]){
                if(distance[next.e][0] > now.cost + next.cost){
                    queue.add(new Edge(next.e, next.e, now.cost + next.cost));
                    distance[next.e][0] = now.cost + next.cost;
                    distance[next.e][1] = next.s;
                }
            }
        }

        //최단거리
        System.out.println(distance[b][0]);
        c = b;
        int count = 1;

        StringBuilder sb = new StringBuilder();

        //가는 길
        while (c != a) {
            sb.insert(0, (c+" ")); 
            c = distance[c][1];   
            count++;
        }

        System.out.println(count);
        System.out.print(a+" "+sb);
    }
}
