import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge2{
    int son, cost;
    Edge2(int son, int cost){
        this.son = son;
        this.cost = cost;
    }
}

//반례(숫자가 작을수록 루트에 가까움을 보장하지 않음. 2가 3의 자식일 수 있음.) :
//4
//1 3 1
//2 4 1
//3 2 1

// -> 코드 수정. n에서 1까지 dp를 갱신하는 대신 dfs 방식으로 갱신.

public class BaekJoon1967 {

    static LinkedList<Edge2> adj[];
    static int dp[];
    static PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
    static int maxVal = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        adj = new LinkedList[n+1];
        dp = new int[n+1];
        for(int i=0; i<n+1; i++) adj[i] = new LinkedList<Edge2>();

        //각 분기점마다 구해야할 것 같은데

        int a, b, cost; //부모 노드의 번호가 작은 것부터, 부모노드가 같으면 자식노드 번호가 작은 것부터.
        StringTokenizer st;

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            
            adj[a].add(new Edge2(b, cost));
        }

        //이제 계산

        //트리의 지름이 되는 두 노드는 부모 - 자식일 수도 있다

        /*
        for(int i=n; i>=1; i--) {
            //tempcal = 0;
            queue.clear();
            queue.add(0);

            if(adj[i].size() == 0) continue;

            //2개 이상인 경우 : 가장 멀리 있는 두 개의 노드를 찾아야 한다

            for(Edge2 now : adj[i]){
                dp[i] = Math.max(dp[i], dp[now.son] + now.cost);
                queue.add(dp[now.son] + now.cost);
                //tempcal += dp[now.son] + now.cost;
            }

            tempcal = queue.poll() + queue.poll();

            maxVal = Math.max(maxVal, tempcal);
        } */

        dfs(1);

        System.out.println(maxVal);
    }

    static void dfs(int i){
        int tempcal = 0;
        int max1 = 0, max2 = 0;

        if(adj[i].size() == 0) return;

        //queue.clear();
        //queue.add(0);

        for(Edge2 now : adj[i]){
            if(dp[now.son] == 0) dfs(now.son);

            dp[i] = Math.max(dp[i], dp[now.son] + now.cost);

            if(dp[now.son] + now.cost > max1) {
                max2 = max1;
                max1 = dp[now.son] + now.cost;
            }
            else if(dp[now.son] + now.cost > max2) {
                max2 = dp[now.son] + now.cost;
            }
        }

        //상위 2개의 값이 필요
        tempcal = max1 + max2;

        maxVal = Math.max(maxVal, tempcal);
    }
}