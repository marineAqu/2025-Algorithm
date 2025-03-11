import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge3{
    int start, end, cost;
    Edge3(int start, int end,int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

// 플로이드-워셜로 풀어야 하는 문제인데 크기가 작아서 그런지 다익스트라로도 풀렸다.
// 이하 다익스트라로 풀이한 코드

public class BaekJoon2660 {
    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    static int distance[][];
    static LinkedList<Integer> adj[];

    public static void main(String[] args) throws IOException {
        //즉 최단경로 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int minValue = Integer.MAX_VALUE;
        adj = new LinkedList[n+1];
        for(int i=1; i<=n; i++) adj[i] = new LinkedList<>();
        distance = new int[n+1][n+2]; //n+1은 합산 저장

        //배열 Max로 초기화
        for(int i=1; i<=n; i++){
            for(int r=1; r<=n; r++) {
                if(r == i) continue;
                distance[i][r] = Integer.MAX_VALUE;
            }
        }

        int a, b;
        
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        //입력
        while(a != -1) {
            //다음 줄 입력
            adj[a].add(b);
            adj[b].add(a);

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            bfs(i);

            //이제 합산 계산
            for(int r=1; r<=n; r++) {
                distance[i][n+1] = Math.max(distance[i][n+1], distance[i][r]);
            }

            minValue = Math.min(minValue, distance[i][n+1]);
        }

        PriorityQueue<Integer> list = new PriorityQueue<>();

        for(int i=1; i<=n; i++){
            if(distance[i][n+1] == minValue){
                list.add(i);
            }
        }

        //가장 작은 점수와 인원, 각 번호 출력
        System.out.println(minValue+" "+list.size());
        while (!list.isEmpty()) {
            System.out.print(list.poll() + " ");
        }

        
    }

    static void bfs(int root){
        queue.add(root);

        while (!queue.isEmpty()) {
            int q = queue.poll();

            //내가 원래 가지고 있던 거리 vs q 거쳐서 나한테 도달한 거리
            //업데이트가 되면 큐에 넣는다

            for(int now : adj[q]) {
                if(distance[root][now] >= distance[root][q] + 1){
                    distance[root][now] = distance[root][q] + 1;
                    distance[now][root] = distance[root][now];

                    queue.add(now);
                }
            }
        }
    }
}

