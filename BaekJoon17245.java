import java.io.*;
import java.util.*;

public class BaekJoon17245 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int map[][] = new int[n][n];

        long total = 0;
        long depth[] = new long[10000001];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int r=0; r<n; r++){
                map[i][r] = Integer.parseInt(st.nextToken());
                total += map[i][r];
                depth[map[i][r]]++;
            }
        }

        long limit = (total+1) / 2; //여기 도달하면 ok

        if(total == 0) {
            System.out.print(0);
            return;
        }

        total = 0;
        for(int i=1; i<10000001; i++){
            total += depth[i];
        }

        //input end
        //절반 이상이 켜지는 데 필요한 시간
        //한칸에는 최대 10000000개...가채워져있을수있다고
        //4면 1, 2, 3, 4에 각각 ++이 필요하다
        //그러면 역으로 가면 되겠다
        //dp형식으로 저장해서 (100000인 것은 1에 +해줘야함, 2는 전체 - depth[0], [1])

        long count = 0;
        long minus_count = 0;

        for(int i=1; i<=10000000; i++){
            count += total - minus_count;
            minus_count += depth[i];

            if(count >= limit) {
                System.out.print(i);
                return;
            }
        }
    }
}
