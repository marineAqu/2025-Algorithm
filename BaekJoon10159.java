import java.util.*;
import java.io.*;

public class BaekJoon10159 {
    static int n, m, count;
    static LinkedList<Integer>[] adjUp;
    static LinkedList<Integer>[] adjDown;
    static boolean visited[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean [n+1];

        int a, b;

        adjDown = new LinkedList[n+1];
        adjUp = new LinkedList[n+1];

        for(int i=1; i<=n; i++){
            adjDown[i] = new LinkedList<>();
            adjUp[i] = new LinkedList<>();
        }
        //나보다 큰 것보다 큰 것은 알 수 있고, 나보다 작은 것보다 작은 것도 알 수 있다
        //n은 100개, 그러면 n보다 작고 큰 것을 linkedList로 모두 연결?? 
        //200*100 = 20000개

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            union(a, b);
        }


        for(int i=1; i<n+1; i++){
            count = 1;
            Arrays.fill(visited, false);

            visited[i] = true;
            
            dfs1(i);
            dfs2(i);

            System.out.println(n - count);
        }
    }

    static void dfs1(int now){
        for(int a : adjUp[now]){
            if(!visited[a]){
                visited[a] = true;
                count++;
                dfs1(a);
            }
        }
    }

    static void dfs2(int now){
        for(int a : adjDown[now]){
            if(!visited[a]){
                visited[a] = true;
                count++;
                dfs2(a);
            }
        }
    }

    static void union(int a, int b){
        adjUp[b].add(a);
        adjDown[a].add(b);
    }
}
