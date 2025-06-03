import java.util.*;
import java.lang.*;
import java.io.*;

class BackJoon11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        boolean map[][] = new boolean[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int r=0; r<n; r++){
                if(st.nextToken().equals("1")) map[i][r] = true;
            }
        }

        //계산
        for(int i=0; i<n; i++){
            for(int r=0; r<n; r++){
                for(int t=0; t<n; t++){
                    if(map[r][i] && map[i][t]) map[r][t] = true;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int r=0; r<n; r++){
                if(map[i][r]) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }
}
