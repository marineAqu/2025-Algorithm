import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int a, b, c;

        int distance[][] = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int r=1; r<=n; r++){
                if(i == r) continue;
                else distance[i][r] = 10000001;
            }
        }

        int maxVal = 0;


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            distance[a][b] = c;
        }

        //계산
        for(int i=1; i<=n; i++){
            for(int r=1; r<=n; r++){
                for(int e=1; e<=n; e++){
                    distance[r][e] = Math.min(distance[r][e], distance[r][i]+distance[i][e]);
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(distance[i][x] + distance[x][i] > maxVal){
                maxVal = distance[i][x] + distance[x][i];
            }
        }

        System.out.print(maxVal);

    }
}
