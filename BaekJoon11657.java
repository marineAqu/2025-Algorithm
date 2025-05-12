import java.io.*;
import java.util.*;

class Edge{
    int start, dist, cost;

    Edge(int start, int dist, int cost){
        this.start = start;
        this.dist = dist;
        this.cost = cost;
    }
}

public class BaekJoon11657 {
    public static void main(String[] args) throws IOException {
        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(1, 1, 0));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s;

        LinkedList<Edge> adj = new LinkedList<>();
        long distance[] = new long[n+1];
        Arrays.fill(distance, 5000001);
        distance[1] = 0;

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
        
            s = Integer.parseInt(st.nextToken());
            adj.add(new Edge(s, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        //1번 도시에서 출발해서 어떤 도시로 가는 과정에서 시간을 무한히 돌릴 수 있는가 (음수사이클 찾기)
        for(int i=1; i<n; i++) {
            for(Edge next : adj){
                if(distance[next.start] != 5000001 && distance[next.dist] > distance[next.start] + next.cost){
                    distance[next.dist] = distance[next.start] + next.cost;
                }
            }
        }

        //한번 더 사이클 돌려서 확인
        for(int i=1; i<n; i++) {
            for(Edge next : adj){
                if(distance[next.start] != 5000001 && distance[next.dist] > distance[next.start] + next.cost){
                    System.out.println("-1");
                    return;
                }
            }
        }

        for(int i=2; i<=n; i++) {
            if(distance[i] == 5000001) System.out.println("-1");
            else System.out.println(distance[i]);
        }
    }
}
