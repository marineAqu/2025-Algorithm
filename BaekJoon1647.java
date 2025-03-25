import java.io.*;
import java.util.*;

class Edge{
    int a, b, cost;
    Edge(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.cost = c;
    }
}

public class BaekJoon1647 {
    static int boss[];
    public static void main(String[] args) throws IOException {
        PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //2~100,000
        int m = Integer.parseInt(st.nextToken()); //1~1,000,000

        boss = new int[n+1];
        for(int i=1; i<=n; i++) boss[i] = i;

        int answer = 0;
        int lastValue = 0;

        //마을 내에는 모두가 연결되어 있어야한다.
        //마을은 1개 이상의 집이 있어야한다.

        //유지비가 최소가 되도록 끊어야한다.
        //마을 내에서도 끊을 수 있다.

        //1. 일단 cost가 높은 건 끊을 수 있는 건 최대한 끊는다 -> 하나의 노드에 두개까지의 간선만 허용하도록

        //queue에만 추가해뒀다가 숫자가 작은 것부터 연결하면서 숫자가 큰 건 최대한 연결하지 않도록 한다
        int a, b, c;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken()); 
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            queue.add(new Edge(a, b, c));
        }

        //연결해야만 하는 것만 연결한다
        Edge now;
        while (!queue.isEmpty()) {
            now = queue.poll();

            if(find(now.a) == find(now.b)) continue;

            else {
                union(now.a, now.b);
                answer += now.cost;
                lastValue = now.cost;
            }
        }

        //이제 두개로 도시를 분할
        System.out.println(answer - lastValue);

        //2. 이제 가장 큰 하나를 끊어버린다

        //길의 유지비를 최소로하는거니까 최단경로 같은 거랑은 관련 없을듯
        //그냥 비용이 큰 길은 최대한 지워서 사이클이 2개가 될 때까지???

        //유니온파인드인가
        //우선순위큐로 ,,,,,,,, 검사하고 
    }

    static int find(int n){
        if(boss[n] == n) return n;
        else return boss[n] = find(boss[n]);
    }

    static void union(int a, int b){
        if(boss[b] != b) boss[find(a)] = find(b);
        else boss[find(b)] = find(a);
    }
}
