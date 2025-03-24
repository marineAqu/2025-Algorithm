import java.io.*;
import java.util.*;

public class BaekJoon2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        //위상정렬이고 만족하지 못하는 경우 (사이클이 존재하는 경우)가 있을 수 있다
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        LinkedList<Integer> adj[] = new LinkedList[n+1];
        for(int i=0; i<n+1; i++) adj[i] = new LinkedList<>();
        int weight[] = new int[n+1];
        
        int t, a, b;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            t = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());

            for(int r=1; r<t; r++) {
                b = Integer.parseInt(st.nextToken());
                if(!adj[a].contains(b)){ //기존에 없으면
                    adj[a].add(b); //부모에다 자식을 연결
                    weight[b]++; //내 앞에 반드시 있어야 하는 부모의 개수
                }
                
                a = b;
            }
        }

        //일단 종속(부모)가 없는 것부터 큐에 집어넣기
        for(int i=1; i<n+1; i++){
            if(weight[i] == 0) queue.add(i);
        }

        int now;
        while (!queue.isEmpty()) {
            now = queue.poll();

            weight[now]--;
            count++;
            sb.append(now).append("\n");
            
            for(int next : adj[now]) {
                if(--weight[next] == 0) queue.add(next);
            }
        }

        //사이클이 존재하는 경우: 
        if(count != n) System.out.print(0);
        //아닌 경우
        else System.out.print(sb);
    }
}
