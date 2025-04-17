import java.io.*;
import java.util.*;

class Answer{
    int a1, a2, sum;

    Answer(int a1, int a2, int sum){
        this.a1 = a1;
        this.a2 = a2;
        this.sum = sum;
    }
}

public class BaekJoon21278 {
    static int n, map[][];
    static Answer answer;
    static Queue<Answer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int r=1; r<=n; r++){
                if(i == r) continue;
                map[i][r] = 100000;
            }
        }

        answer = new Answer(-1, -1, Integer.MAX_VALUE);

        int a, b;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
            //adj[a].add(b);
            //adj[b].add(a);
        }

        //시간제한 1초, 건물은 최대 100개에 도로는 최대 5000개

        //조합이 여러개라면 작은 쪽을 출력하도록 되어있으므로 뒤에서부터 완전탐색
        //플로이드워셜로 미리 가는 길을 알 순 없나??

        for(int i=1; i<=n; i++){
            for(int r=1; r<=n; r++){
                for(int u=1; u<=n; u++){
                    map[r][u] = Math.min(map[r][u], map[r][i] + map[i][u]);
                }
            }
        }

        //4 4
        for(int i=n-1; i>0; i--){
            for(int r=n; r>i; r--){
                dfs(i, r);
            }
        }

        System.out.println(Math.min(answer.a2, answer.a1) + " " + Math.max(answer.a2, answer.a1) + " " + answer.sum);
    }
    

    //계산
    static void dfs(int k1, int k2){
        int sum = 0;
        //계산
        for(int i=1; i<=n; i++){
            if(map[i][k1] < map[i][k2]){
                sum += map[i][k1] * 2;
            }

            else{
                sum += map[i][k2] * 2;
            }
        }

        if(answer.sum >= sum){
            answer = new Answer(k1, k2, sum);
        }
    }
}
