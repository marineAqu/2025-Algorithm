import java.io.*;
import java.util.*;

public class BaekJoon3109 {
    static int map[][], r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //가능하면 위에 바짝 붙여야 한다.
        //대각선 이동이 가능하다는 거

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int count = 0;
        String line;

        map = new int[r][c];

        //맵 그리기
        for(int i=0; i<r; i++){
            line = br.readLine();
            for(int k=0; k<c; k++){
                if(line.charAt(k) == '.') continue;
                map[i][k] = -1;
            }
        }

        //파이프 잇기
        for(int i=0; i<r; i++){
            if(connect(i, 0)) count++;
        }

        System.out.print(count);
    }

    //10,000 * 500 = 5,000,000 크기. 5백만
    //각 줄마다 검사해야 한다.

    //굳이 true 리턴 후에 2로 바꿔줄 필요가 있을까? false여도 어쨌든 이 경로로 가면
    //연결할 수 있는 방법이 없다는 뜻이니까 미리 바꿔도 괜찮을 것 같다

    static boolean connect(int y, int x){
        map[y][x] = 2;
        
        if(x == c-1) {
            return true;
        }

        if(y-1 >= 0 && map[y-1][x+1] == 0) {
            map[y-1][x+1] = 2;
            if(connect(y-1, x+1)) return true;
        }

        if(map[y][x+1] == 0) {
            map[y][x+1] = 2;
            if(connect(y, x+1)) return true;
        }
        if(y+1 < r && map[y+1][x+1] == 0) {
            map[y+1][x+1] = 2;
            if(connect(y+1, x+1)) return true;
        }

        return false;
    }
}
