import java.util.*;

public class BaekJoon11725 {
    static LinkedList<Integer> adj[];
    static boolean visited[];
    static int boss[];

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        visited = new boolean[n+1];
        adj = new LinkedList[n+1];
        boss = new int[n+1];
        for(int i=0; i<n+1; i++) adj[i] = new LinkedList<>();

        int a, b;
        for(int i=0; i<n-1; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            adj[a].add(b);
            adj[b].add(a);
        }

        //이제 2번부터 부모 노드를 출력
        dfs(1, 1);

        for(int i=2; i<n+1; i++) System.out.println(boss[i]);
    }
    
    static void dfs(int recent, int i){
        boss[i] = recent;

        for(int now : adj[i]){
            if(visited[now] == false){
                visited[now] = true;
                dfs(i, now);
            }
        }
    }
}
