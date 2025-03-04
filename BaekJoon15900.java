import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon15900 {
    static LinkedList<Integer> adj[];
    static int cost[];
    static PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

    public static void main(String[] args) throws IOException {
        //마지막 게임말을 내가 제거하면 이긴다 & 내가 후공
        //즉 각 리프노드의 루트까지의 거리를 구해야한다

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long count = 0;
        cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        adj = new LinkedList[n+1];
        for(int i=0; i<n+1; i++) adj[i] = new LinkedList<Integer>();

        //루트는 1번
        //각 노드가 1번까지의 거리를 구해야하므로 다익스트라

        //그래프 정보 받기
        //총 리프노드까지의 거리 합은 홀수여야 YES
        int a, b;

        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        //리프노드: 연결된 간선이 하나뿐 (이때 루트를 리프노드로 취급하면 안된다)

        queue.add(1);
        cost[1] = 0;
        
        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int next : adj[now]) {
                if(cost[next] > cost[now] + 1){
                    cost[next] = cost[now] + 1;
                    queue.add(next);
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(adj[i].size() == 1) count += cost[i];
        }

        if(count % 2 == 0) System.out.print("No");
        else System.out.print("Yes");
    }
}