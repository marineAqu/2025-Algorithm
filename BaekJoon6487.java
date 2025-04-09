import java.io.*;
import java.util.*;

public class BaekJoon6487 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double lin1, lin2, b1, b2, x, y;

        StringTokenizer st;
        // 점 4개
        double dot[][] = new double[4][2];
        for (int t = 0; t < n; t++) {
            
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++) {
                dot[i][0] = Integer.parseInt(st.nextToken()); // x
                dot[i][1] = Integer.parseInt(st.nextToken()); // y
            }

            // 둘을 y=ax+b 형태로 변형해야할 것 같다
            // 소수 형태로 나타내면 오차가 생길 것 같은데 분수형태로 비교해야 하지 않을까

            //x = a 꼴인 경우에 대한 예외처리 필요
            if(dot[0][0] == dot[1][0]){
                if(dot[2][0] == dot[3][0]){
                    if(dot[0][0] == dot[2][0]) System.out.println("LINE");
                    else System.out.println("NONE");
                }

                else {
                    x = dot[1][0];
                    y = x * (dot[2][1] - dot[3][1]) / (dot[2][0] - dot[3][0]) + dot[2][1] - ((dot[2][1] - dot[3][1]) / (dot[2][0] - dot[3][0]) * dot[2][0]);
                    System.out.printf("POINT %.2f %.2f\n", x, y);
                }

                continue;
            }

            else if(dot[2][0] == dot[3][0]){
                x = dot[2][0];
                y = x * (dot[0][1] - dot[1][1]) / (dot[0][0] - dot[1][0]) + dot[2][1] - ((dot[0][1] - dot[1][1]) / (dot[0][0] - dot[1][0]) * dot[0][0]);
                System.out.printf("POINT %.2f %.2f\n", x, y);

                continue;
            }

            lin1 = (dot[0][1] - dot[1][1]) / (dot[0][0] - dot[1][0]);
            lin2 = (dot[2][1] - dot[3][1]) / (dot[2][0] - dot[3][0]);
            b1 = dot[0][1] - (lin1 * dot[0][0]);
            b2 = dot[2][1] - (lin2 * dot[2][0]);

            if (lin1 == lin2) {
                if(b1 == b2) System.out.println("LINE");
                else System.out.println("NONE");
            }

            //점 계산
            
            else {
                x = (b2 - b1) / (lin1 - lin2);
                y = x * lin1 + b1;

                System.out.printf("POINT %.2f %.2f\n", x, y);
            }
        }
    }
}
