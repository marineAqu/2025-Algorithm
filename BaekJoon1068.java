import java.io.*;
import java.util.*;

public class BaekJoon1068 {
    static LinkedList<Integer> adj[];
    static int root = 0;
    static int count = 0;
    static int deleteN;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        adj = new LinkedList[n+1]; //인접리스트 - 부모에 자식의 번호를 저장한다.
        for(int i=0; i<=n; i++) adj[i] = new LinkedList<>(); //초기화

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int now;
        //정보 받기
        for(int i=0; i<n; i++){
            now = Integer.parseInt(st.nextToken());

            if(now == -1) {
                root = i; //루트라면 루트 인덱스 저장 후 저장할 것 없으므로 continue
                continue;
            }

            adj[now].add(i); //부모에게 자식 번호를 저장
        }

        //지울 것 저장
        deleteN = Integer.parseInt(br.readLine());
        adj[deleteN].clear();

        dfs(root);

        System.out.print(count);
    }

    static void dfs(int now) {
        //사라진 노드라면 이 사라진 노드를 포함해서 서브트리는 검사하지 않는다
        if(now == deleteN) return;

        //리프노드
        if(adj[now].size() == 0){
            count++;
        }

        //부모 입장에선 자식이 안 지워지기때문에 만약 하나 남은 자식이 지워진다면 리프노드가 된다.
        else if(adj[now].size() == 1){
            if (adj[now].get(0) == deleteN) count++;
        }

        //트리 구조이기때문에 굳이 visited 검사 필요 X
        for(int next : adj[now]){
            dfs(next);
        }
    }
}
