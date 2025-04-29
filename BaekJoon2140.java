import java.io.*;
import java.util.*;

public class BaekJoon2140 {
    static int n, count, map[][];
    static int[] dx = {0, 0, 1, -1, -1, 1, -1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1}; //8방탐색
                     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        //1~3만 예외처리하자 (4부터 100은 같은 로직 사용하면 됨)
        if(n == 1 || n == 2) {
            System.out.print("0");
            return;
        }

        if(n == 3){
            if((int)(br.readLine().charAt(0) - '0') > 0) System.out.print("1");
            else System.out.print("0");
            
            return;
        }

        String line;
        map = new int[n][n];
        count = (n-2)*(n-2);

        //테두리 바로 안쪽테두리의 지뢰 여부는 알 수 있지만 그 안쪽들은 알 수가 없다. 
        //최댓값이니 전부 지뢰라고 가정하면 될 듯함

        //입력
        for(int i=0; i<n; i++){
            line = br.readLine();
            for(int r=0; r<n; r++) map[i][r] = (int)(line.charAt(r)-'0'); //불확실함 (0은 확실히 미존재, 1은 확실히 존재)
        }

        //계산
        for(int r=1; r<n-1; r++) calc(1, r);
        for(int i=2; i<n-2; i++){
            calc(i, 1);
            calc(i, n-2);
        }
        for(int r=1; r<n-1; r++) calc(n-2, r);


        System.out.println(count);
    }

    static void calc(int y, int x){
        for(int i=0; i<8; i++){
            if(y+dy[i] < 0 || y+dy[i] >= n || x+dx[i] >= n || x+dx[i] < 0) continue;
            
            //계산하기
            if(map[y+dy[i]][x+dx[i]] == 0) {
                count--;
                return;
            }
        }

        //지뢰로 확정지었다면 주변 숫자 -1
        for(int i=0; i<8; i++){
            if(y+dy[i] < 0 || y+dy[i] >= n || x+dx[i] >= n || x+dx[i] < 0) continue;
            
            //계산하기
            if(map[y+dy[i]][x+dx[i]] > 0 && map[y+dy[i]][x+dx[i]] < 6) {
                map[y+dy[i]][x+dx[i]]--;
            }
        }
    }
}