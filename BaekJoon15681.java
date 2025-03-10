import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BaekJoon15681 {
    static LinkedList<Integer> adj[];
    static int count[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); //노드 수
        int r = Integer.parseInt(st.nextToken()); //루트
        int q = Integer.parseInt(st.nextToken()); //쿼리 수

        count = new int[n+1];
        adj = new LinkedList[n+1];
        visited = new boolean[n+1];
        Arrays.fill(count, 1);

        for(int i=1; i<=n; i++) adj[i] = new LinkedList<Integer>();

        int u, v;
        //간선 정보
        for(int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        count[r] = dfs(r);

        for(int i=0; i<q; i++) {
            u = Integer.parseInt(br.readLine());
            sb.append(count[u]).append("\n");
        }

        System.out.print(sb);
    }

    static int dfs(int root){
        visited[root] = true;

        for(int now : adj[root]){
            if(visited[now] == false) count[root] += dfs(now);
        }

        return count[root];
    }
}
