import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge{
    int a,c;
    Edge(int a, int c){
        this.a = a;
        this.c = c;
    }
}

public class BaekJoon1167 {
    static int distance[];
    static boolean visited[];
    static LinkedList<Edge> adj[];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(br.readLine());
        adj = new LinkedList[v+1];
        distance = new int[v+1];
        visited = new boolean[v+1];

        for(int i=1; i<=v; i++) {
            adj[i] = new LinkedList<Edge>();
        }

        StringTokenizer st;
        int a, b, c;


        //가장 먼 두 곳의 거리를 찾자. 
        //한 점에서 BFS로 거리를 업데이트

        //입력
        for(int i=0; i<v; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            while (b != -1) {
                c = Integer.parseInt(st.nextToken());

                adj[a].add(new Edge(b, c));

                b = Integer.parseInt(st.nextToken());
            }
        }

        //실행
        dfs(1);

        for(int i=1; i<=v; i++) if(distance[i] > answer) answer = distance[i];

        System.out.println(answer);
    }


    //한 노드에서 리프 노드들부터 도착해서 계산 후 차근차근 올라온다.
    static void dfs(int i) {
        visited[i] = true;

        int maxNum = 0;
        int maxNum2 = 0;

        for(Edge e : adj[i]){
            if(visited[e.a] == false){
                dfs(e.a);
            }
            else { //내 부모노드라면 continue; (else문이므로)
                continue;
            }

            //자식노드 방문 후 이하 실행
            if(e.c + distance[e.a] > maxNum) {
                maxNum2 = maxNum;
                maxNum = e.c + distance[e.a];
            }

            else if(e.c + distance[e.a] > maxNum2) {
                maxNum2 = e.c + distance[e.a];
            }
        }

        distance[i] = maxNum;
        answer = Math.max(answer, maxNum + maxNum2);
    }
}
