import java.util.*;
import java.io.*;

public class BaekJoon2239 {
    static int map[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];

        //입력 저장
        String line;
        for(int i=0; i<9; i++){
            line = br.readLine();
            for(int r=0; r<9; r++) map[i][r] = Integer.parseInt(line.charAt(r)+"");
        }

        //계산
        dfs(0, 0);

        for(int i=0; i<9; i++){
            for(int r=0; r<9; r++) System.out.print(map[i][r]);
            System.out.println();
        }
    }


    //만약에 모든 게 false가 되면 이전 값도 지워야 한다
    static void dfs(int y, int x){
        if(map[y][x] == 0) {

            for(int k=1; k<10; k++){
                if(checkFill(y, x, k) == true){
                    map[y][x] = k;
                    
                    if(x < 8) dfs(y, x+1);
                    else if(y < 8) dfs(y+1, 0);
                }
            }

            if(y == 8 && x == 8){
                for(int i=0; i<9; i++){
                    for(int r=0; r<9; r++) System.out.print(map[i][r]);
                    System.out.println();
                }
    
                System.exit(0);
            }

            map[y][x] = 0;
        }

        else{
            if(x < 8) dfs(y, x+1);
            else if(y < 8) dfs(y+1, 0);
        }

        if(y == 8 && x == 8){
            for(int i=0; i<9; i++){
                for(int r=0; r<9; r++) System.out.print(map[i][r]);
                System.out.println();
            }

            System.exit(0);
        }
    }

    static boolean checkFill(int y, int x, int n){
        for(int i=0; i<9; i++){
            if(map[y][i] == n) return false;
        }

        for(int i=0; i<9; i++){
            if(map[i][x] == n) return false;
        }
        //0~2 -> 1, 3~5->2, 6~ -> 3
        
        for(int i=0; i<3; i++){
            for(int r=0; r<3; r++){
                if(map[(y/3)*3+i][(x/3)*3+r] == n) return false;
            }
        }

        return true;
    }
}
