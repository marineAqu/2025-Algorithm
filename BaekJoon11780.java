import java.io.*;
import java.util.*;

public class BaekJoon11780 {
    static int n, map[][], load[][], count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int a, b, c;

        map = new int[n][n];
        load = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int r=0; r<n; r++){
                if(i == r) continue;
                map[i][r] = 300000;
            }
        }

        //시작도시와 도착 도시가 같은 경우는 X
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(map[a-1][b-1] > c){
                map[a-1][b-1] = c;
                load[a-1][b-1] = a-1;
            }
        }

        //최소비용 계산
        for(int i=0; i<n; i++){
            for(int r=0; r<n; r++){
                for(int k=0; k<n; k++){
                    if(map[r][k] > map[r][i] + map[i][k]){
                        map[r][k] = map[r][i] + map[i][k];
                        load[r][k] = i; //r-> k 가기 위해서는 i를 거친다
                    }
                }
            }
        }

        //출력1
        for(int r=0; r<n; r++){
            for(int k=0; k<n; k++){
                if(map[r][k] == 300000) sb.append("0 ");
                else sb.append(map[r][k]+" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        //출력2
        for(int r=0; r<n; r++){
            for(int k=0; k<n; k++){
                //초기화
                sb = new StringBuilder();
                count = 2;

                if(map[r][k] == 300000 || map[r][k] == 0) {
                    System.out.println("0");
                    continue;
                }

                loadBefore(r, k);
                System.out.println(count+" "+(r+1)+" "+sb+(k+1));
            }
        }
    }

    static void loadBefore(int a, int b){
        if(load[a][b] == a) return;
        
        count++;
        loadBefore(a, load[a][b]);
        sb.append((load[a][b]+1)+" ");
        loadBefore(load[a][b], b);
    }
}
