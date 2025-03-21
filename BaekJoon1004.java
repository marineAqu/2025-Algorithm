import java.util.*;
import java.io.*;

public class BaekJoon1004{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        int x1, y1, x2, y2, x3, y3; //출발지점과 도착 지점
        int n, r, cal1, cal2;
        int count;

        for(int t=0; t<testcase; t++){
            count = 0;
            st = new StringTokenizer(br.readLine());
            
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            //행성 수
            n = Integer.parseInt(br.readLine());

            //해당 원 안에 출발점이나 도착점이 포함되는지를 확인해야됨. 포함된다면 count++
            //그러면 해당 원의 중심과 출발점, 도착점 사이 (=점과 점 사이 거리)를 구하고 그게 r보다 작다면 count++
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());

                x3 = Integer.parseInt(st.nextToken());
                y3 = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());
                r *= r;

                //점과 점 사이 거리 계산
                //1. 출발점
                cal1 = (x1 - x3)*(x1 - x3) + (y1 - y3)*(y1 - y3);

                //2. 도착점
                cal2 = (x2 - x3)*(x2 - x3) + (y2 - y3)*(y2 - y3);

                //출발점 도착점 모두 같은 하나의 행성계에 포함되어있는 경우에는 진입/이탈하는 경우가 아님
                if((cal1 < r && cal2 < r) == false && (cal1 < r || cal2 < r)) count++;
            }

            //행성계의 경계가 맞닿거나 교차하는 경우도 없기때문에 둘러싸고 있는 경우는 존재하지 않는다
            //반례 뭐가있을까
            //

            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}