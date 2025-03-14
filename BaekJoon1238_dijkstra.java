import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge{
    int a, c;
    Edge(int a, int c){
        this.a = a;
        this.c = c;
    }
}

public class BaekJoon1238_dijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int a, b, c;
        Queue<Edge> queue = new LinkedList<>();

        LinkedList<Edge> adj[] = new LinkedList[n+1];
        LinkedList<Edge> adjre[] = new LinkedList[n+1];

        int distance[] = new int[n+1];
        int distancere[] = new int[n+1];
        
        for(int i=1; i<=n; i++){
            adj[i] = new LinkedList<>();
            adjre[i] = new LinkedList<>();

            distance[i] = 10000001;
            distancere[i] = 10000001;
        }

        int maxVal = 0;
        distance[x] = 0;
        distancere[x] = 0;


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            adj[a].add(new Edge(b, c));
            adjre[b].add(new Edge(a, c));
        }


        queue.add(new Edge(x, 0));
        //계산
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            for(Edge now : adj[edge.a]){
                if(distance[now.a] > distance[edge.a] + now.c){
                    distance[now.a] = distance[edge.a] + now.c;
                    queue.add(new Edge(now.a, distance[now.a]));
                }
            }
        }

        queue.add(new Edge(x, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();

            for(Edge now : adjre[edge.a]){
                if(distancere[now.a] > distancere[edge.a] + now.c){
                    distancere[now.a] = distancere[edge.a] + now.c;
                    queue.add(new Edge(now.a, distancere[now.a]));
                }
            }
        }

        for(int i=1; i<=n; i++) 
            maxVal = Math.max(maxVal, distance[i] + distancere[i]);


        System.out.print(maxVal);

    }
}
