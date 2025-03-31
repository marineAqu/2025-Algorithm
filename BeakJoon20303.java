import java.io.BufferedReader;
import java.io.*;
import java.util.*;

class Info{
    int candy, sound;

    Info(int candy, int sound){
        this.candy = candy;
        this.sound = sound;
    }
}

//시간초과 해결방법: 링크드리스트 쓰지말고 배열로 할까 (최댓값인 n으로 size 잡고)
//get 쓰는 과정에서 시간초과가 날 것 같음... 차라리 poll을 써야하나
//그리고 정렬 해야됨 (사람 크기 오름차로)

//그래프 + 배낭 알고리즘


public class BeakJoon20303 {
    static LinkedList<Integer> adj[];
    static int candy[], soundCount, candyCount;
    static boolean visited[];
    static LinkedList<Info> map = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        adj = new LinkedList[n+1];
        candy = new int[n+1];
        visited = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            adj[i] = new LinkedList<Integer>();
            candy[i] = Integer.parseInt(st.nextToken());
        }

        int a, b;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        //각 그래프를 돌 때 얻는 사탕과 공명 담아두기
        for(int i=1; i<=n; i++) {
            if(visited[i] == false) {
                candyCount = 0;
                soundCount = 0;
                dfs(i);
                map.add(new Info(candyCount, soundCount));
            }
        }

        int size = map.size();
        Info info;

        int arr[][] = new int[size+1][2];

        for(int i=1; i<=size; i++){
            info = map.poll();
            arr[i][0] = info.candy;
            arr[i][1] = info.sound;
        }

        Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]);
        
        //Info를 바탕으로 계산 (DP)
        //! K명이 되어서는 안된다. 최대 K-1명이 되어야 한다.
        int dp[][] = new int[k][size+1];

        for(int i=0; i<k; i++){
            for(int r=1; r<=size; r++){
                if(i - arr[r][1] < 0){
                    dp[i][r] = dp[i][r-1];
                }
                else{
                    dp[i][r] = Math.max(dp[i][r-1], dp[i - arr[r][1]][r-1] + arr[r][0]);
                }
            }
        }

        System.out.println(dp[k-1][size]);

    }

    public static void dfs(int now) {
        candyCount += candy[now];
        soundCount++;

        visited[now] = true;

        for(int next: adj[now]){
            if(visited[next] == false){
                dfs(next);
            }
        }
    }
}
