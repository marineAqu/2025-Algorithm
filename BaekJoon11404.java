import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int dist[][] = new int[n+1][n+1];
        //초기화
        for(int i=1; i<=n; i++){
            for(int k=1; k<=n; k++){
                if(i == k) continue;
                dist[i][k] = 10000001;
            }
        }

        //a b 사이 노선이 하나가 아닐 수 있음에 유의
        int a, b, c;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
        }

        //이제 계산
        for(int i=1; i<=n; i++){
            for(int k=1; k<=n; k++){
                for(int u=1; u<=n; u++){
                    dist[k][u] = Math.min(dist[k][u], dist[k][i] + dist[i][u]);
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int k=1; k<=n; k++){
                if(dist[i][k] == 10000001) System.out.print("0 ");
                else System.out.print(dist[i][k]+" ");
            }
            System.out.println();
        }
    }
}
