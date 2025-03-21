import java.io.*;
import java.util.*;

public class BaekJoon16931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 종이 크기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int map[][] = new int[n][m];
        int sum = 0;
        int tempsum = 0;


        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int r=0; r<m; r++){
                map[i][r] = Integer.parseInt(st.nextToken());
            }
        }

        // 윗변, 아랫변 구하기
        for(int i=0; i<n; i++){
            for(int r=0; r<m; r++){
                if (map[i][r] != 0) tempsum++;
            }
        }

        sum = tempsum * 2;

        //왼쪽, 오른쪽변 구하기
        for(int i=0; i<n; i++){
            tempsum = map[i][0];
            for(int r=1; r<m; r++){
                if(map[i][r] - map[i][r-1] > 0) tempsum += map[i][r] - map[i][r-1];
            }

            sum += tempsum * 2;
        }
            
        //앞, 뒤변 구하기
        for(int i=0; i<m; i++){
            tempsum = map[0][i];
            for(int r=1; r<n; r++){
                if(map[r][i] - map[r-1][i] > 0) tempsum += map[r][i] - map[r-1][i];
            }
    
            sum += tempsum * 2;
        }

        System.out.println(sum);
    }
}
