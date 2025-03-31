import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1080 {
    static boolean needChange[][];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        String map[] = new String[n];
        String dis[] = new String[n];
        needChange = new boolean[n][m];
        
        //교체가 필요한 부분을 파악한다.

        for(int i=0; i<n; i++) {
            map[i] = br.readLine();
        }

        for(int i=0; i<n; i++) {
            dis[i] = br.readLine();
            
            for(int r=0; r<m; r++){

                //교체가 필요한 부분 체크
                if(dis[i].charAt(r) != map[i].charAt(r)){
                    needChange[i][r] = true;
                }
            }
        }

        //교체가 필요한 부분 체크 완료

        for(int i=0; i<n-2; i++){
            for(int r=0; r<m-2; r++){
                if(needChange[i][r] == true) {
                    //함수 호출해서 바꾸기
                    ch(i, r);
                    count++;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int r=0; r<m; r++){
                //교체가 필요한 부분 체크
                if(needChange[i][r]){
                    System.out.println(-1);
                    return;
                }
            }
        }

        
        System.out.println(count);
    }

    static void ch(int y, int x){
        for(int i=0; i<3; i++){
            for(int r=0; r<3; r++){
                if(needChange[y+i][x+r]) needChange[y+i][x+r] = false;
                else needChange[y+i][x+r] = true;
            }
        }
    }
}
