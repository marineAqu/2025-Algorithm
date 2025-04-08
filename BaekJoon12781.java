import java.io.*;
import java.util.*;

class Graph{
    double a;
    double b;

    Graph(double a, double b){
        this.a = a;
        this.b = b;
    }
}

public class BaekJoon12781 {
    public static void main(String[] args) throws IOException{
        //두 선분이 꼭 한점에서만 만나야할 것 같다

        //두 선분이 한 점에서 만나는지 알 수 있는 방법
        // -> 기울기가 같지 않아야 하고..... 

        //a b c d
        // 기울기는 구할 수 있고, y = ax + b 형태로 a, b를 지나게끔

        //이렇게 두 선분을 그래프 형식으로 만들고 = 만들어서 계산
        //그 한 점의 위치가 피자 안을 벗어났는지를 알아야함

        //가장자리 중 4개의 점을 알려주니까
        //그 점 사이에 들어있는지만 알면 되지않을까

        int line1[][] = new int[2][2];
        int line2[][] = new int[2][2];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        line1[0][0] = Integer.parseInt(st.nextToken());
        line1[0][1] = Integer.parseInt(st.nextToken());

        line1[1][0] = Integer.parseInt(st.nextToken());
        line1[1][1] = Integer.parseInt(st.nextToken());

        line2[0][0] = Integer.parseInt(st.nextToken());
        line2[0][1] = Integer.parseInt(st.nextToken());

        line2[1][0] = Integer.parseInt(st.nextToken());
        line2[1][1] = Integer.parseInt(st.nextToken());

        double inc;
        double b;
        double x, y;

        if(line1[1][0] == line1[0][0]){
            //x = a 꼴
            //반례: 30 0 30 30 0 0 50 0 (정답: 0)

            if(Math.min(line2[1][0], line2[0][0]) < line1[0][0] && Math.max(line2[1][0], line2[0][0]) > line1[0][0]){
                if(line2[0][1] == line2[1][1] && (line2[0][1] == line1[0][1] || line2[0][1] == line1[1][1])) {
                    System.out.print(0);
                }
                else System.out.print(1);
            }

            else System.out.print(0);

            return;
        }

        if(line2[1][0] == line2[0][0]){
            //x = a 꼴
            if(Math.min(line1[1][0], line1[0][0]) < line2[0][0] && Math.max(line1[1][0], line1[0][0]) > line2[0][0]){
                if(line1[0][1] == line1[1][1]  && (line1[0][1] == line2[0][1] || line1[0][1] == line2[1][1])) System.out.print(0);
                else System.out.print(1);
            }

            else System.out.print(0);

            return;
        }
        
        inc = (double)(line1[1][1] - line1[0][1]) / (double)(line1[1][0] - line1[0][0]);
        b = (double)line1[0][1] - inc * line1[0][0];
        Graph g1 = new Graph(inc, b);

        inc = (double)(line2[1][1] - line2[0][1]) / (double)(line2[1][0] - line2[0][0]);
        b = (double)line2[0][1] - inc * line2[0][0];
        Graph g2 = new Graph(inc, b);

        if(g1.a == g2.a) {
            System.out.print(0);
            return;
        }

        //두 그래프가 만나는 곳: ax + t = ax + r
        // 두 직선이 만나는 곳의 점
        x = (g2.b - g1.b) / (g1.a - g2.a);
        y = g1.a * x + g1.b;

        //이 점이 벗어나는지 포함인지 알 방법??
        //그냥 이 네 점으로 사각형을 만들었을 때 그 안에 있는지만 알면 됨
        
        //System.out.println(g2.a + " " + g2.b);

        if(Math.max(Math.max(line1[0][0], line1[1][0]), Math.max(line2[0][0], line2[1][0])) >= x){
            if(Math.min(Math.min(line1[0][0], line1[1][0]), Math.min(line2[0][0], line2[1][0])) <= x){
                if(Math.max(Math.max(line1[0][1], line1[1][1]), Math.max(line2[0][1], line2[1][1])) >= y){
                    if(Math.min(Math.min(line1[0][1], line1[1][1]), Math.min(line2[0][1], line2[1][1])) <= y){
                        System.out.print(1);
                        return;
                    }
                }
            }
        }

        System.out.print(0);
    }
}
