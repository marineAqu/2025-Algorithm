import java.util.*;
import java.lang.*;
import java.io.*;

class BaekJoon1711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long count = 0;

        //a와 b 사이 기울기 * -1 = a와 c 사이 기울기여야한다
        //두개씩 조합해서 각 기울기를 저장하고, 기울기마다 -1로 대조되는 게 있는지 확인?

        // -> 그냥 피타고라스의 정리 사용해서 길이를 비교하면 된다
        long distance[][] = new long[n][n];

        long dot[][] = new long[n][2];
        //2개 조합 개수: 약 1500 * 750
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            dot[i][0] = Integer.parseInt(st.nextToken());
            dot[i][1] = Integer.parseInt(st.nextToken());
        }

        //거리 구하기 (i에 큰 숫자, r에 작은 숫자)
        for(int i=0; i<n; i++) {
            for(int r=0; r<n; r++) {
                distance[i][r] = (dot[i][0] - dot[r][0]) * (dot[i][0] - dot[r][0]) + (dot[i][1] - dot[r][1]) * (dot[i][1] - dot[r][1]);
            }
        }

        //계산
        for(int i=0; i<n; i++) {
            for(int r=i+1; r<n; r++) {
                for(int t=r+1; t<n; t++){
                    if(distance[r][t] == distance[i][r] + distance[i][t]) count++;
                    if(distance[i][t] == distance[i][r] + distance[r][t]) count++;
                    if(distance[i][r] == distance[i][t] + distance[r][t]) count++;
                }    
            }
        }

        System.out.print(count);
    }
}
