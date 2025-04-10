import java.io.*;
import java.util.*;
public class BaekJoon9466 {
    static int arr[] = new int[100001];
    static int visited[] = new int[100001];

    static int index, start, count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int n;
        

        for(int i=0; i<tc; i++){
            Arrays.fill(visited, 0);
            n = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine());
            
            count = n;
            index = 1;

            for(int k=1; k<=n; k++){
                arr[k] = Integer.parseInt(st.nextToken());
            }

            //계산
            for(int k=1; k<=n; k++){
                if(visited[k] == 0){
                    dfs(k);
                    index++;
                }
            }

            System.out.println(count);
        }
    }
    
    //원형인걸 알수있는 방법이 뭐가 있을까
    //처음으로 visited가 true인 곳으로 돌아왔는데 시작한 지점이 아닌 경우

    //현재 visited 번호랑 일치할 경우, 해당 부분부터 나까지가 사이클. 그 외에는 사이클이 아님
    //그럼 now를 저장해뒀다가 now에서부터 다시 dfs 돌려서 사이클 존재한다고 저장
    
    static void dfs(int now){
        if(visited[now] == index) {
            visited[now] = index;
            start = now;
            cal(now);
            
            return;
        }

        if(visited[now] != 0) return;

        visited[now] = index;

        dfs(arr[now]);
    }

    static void cal(int now){
        count--;

        if(arr[now] == start) {
            return;
        }

        cal(arr[now]);
    }
}
