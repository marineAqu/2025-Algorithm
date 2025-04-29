import java.io.*;

public class BaekJoon1996 {
    static int n, map[][];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String line;

        map = new int[n][n]; //1,000,000

        for(int i=0; i<n; i++){
            line = br.readLine();

            for(int r=0; r<n; r++){
                if(line.charAt(r) == '.') continue;
                map[i][r] = -1;
                calc(i, r, (int)(line.charAt(r) - '0'));
            }
        }

        //출력
        for(int i=0; i<n; i++){
            for(int r=0; r<n; r++){
                if(map[i][r] == -1) System.out.print("*");
                else if(map[i][r] > 9) System.out.print("M");
                else System.out.print(map[i][r]);
            }
            System.out.println();
        }
    }

    static void calc(int y, int x, int val){
        if(x-1 >= 0 && map[y][x-1] != -1) map[y][x-1] += val;
        if(x+1 < n && map[y][x+1] != -1) map[y][x+1] += val;
        if(y-1 >= 0 && map[y-1][x] != -1) map[y-1][x] += val;
        if(y+1 < n && map[y+1][x] != -1) map[y+1][x] += val;
        if(x-1 >= 0 && y-1 >= 0 && map[y-1][x-1] != -1) map[y-1][x-1] += val;
        if(x-1 >= 0 && y+1 < n && map[y+1][x-1] != -1) map[y+1][x-1] += val;
        if(x+1 < n && y-1 >= 0 && map[y-1][x+1] != -1) map[y-1][x+1] += val;
        if(x+1 < n && y+1 < n && map[y+1][x+1] != -1) map[y+1][x+1] += val;
    }
}
