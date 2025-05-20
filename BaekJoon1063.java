import java.io.*;
import java.util.*;

class Point{
    int x, y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BaekJoon1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int map[][] = new int[8][8];

        String p = st.nextToken();
        Point king = new Point(p.charAt(0) - 'A', p.charAt(1) - '1');

        p = st.nextToken();
        map[p.charAt(1) - '1'][p.charAt(0) - 'A'] = 2; //stone

        int n = Integer.parseInt(st.nextToken());

        //1~8 인덱스가 거꾸로다

        for(int i=0; i<n; i++){
            p = br.readLine();

            if(p.equals("R")){
                
                //넘치는 경우
                if(king.x + 1 >= 8) {
                    continue;
                }

                //그 자리에 돌이 있는 경우
                else if(map[king.y][king.x+1] == 2){
                    if(king.x+2 >= 8) continue;
                    
                    //돌을 밀 수 있는 경우
                    else {
                        map[king.y][king.x+2] = 2;
                        map[king.y][king.x+1] = 0;
                        king.x++;
                    }
                }
                
                //이동 가능한 경우
                else{
                    king.x++;
                }
            }

            if(p.equals("L")){
                
                //넘치는 경우
                if(king.x - 1 < 0) {
                    continue;
                }

                //그 자리에 돌이 있는 경우
                else if(map[king.y][king.x-1] == 2){
                    if(king.x - 2 < 0) continue;
                    
                    //돌을 밀 수 있는 경우
                    else {
                        map[king.y][king.x-2] = 2;
                        map[king.y][king.x-1] = 0;
                        king.x--;
                    }
                }
                
                //이동 가능한 경우
                else{
                    king.x--;
                }
            }

            if(p.equals("T")){
                
                //넘치는 경우
                if(king.y + 1 >= 8) {
                    continue;
                }

                //그 자리에 돌이 있는 경우
                else if(map[king.y+1][king.x] == 2){
                    if(king.y+2 >= 8) continue;
                    
                    //돌을 밀 수 있는 경우
                    else {
                        map[king.y+2][king.x] = 2;
                        map[king.y+1][king.x] = 0;
                        king.y++;
                    }
                }
                
                //이동 가능한 경우
                else{
                    king.y++;
                }
            }

            if(p.equals("B")){
                
                //넘치는 경우
                if(king.y - 1 < 0) {
                    continue;
                }

                //그 자리에 돌이 있는 경우
                else if(map[king.y-1][king.x] == 2){
                    if(king.y - 2 < 0) continue;
                    
                    //돌을 밀 수 있는 경우
                    else {
                        map[king.y-2][king.x] = 2;
                        map[king.y-1][king.x] = 0;
                        king.y--;
                    }
                }
                
                //이동 가능한 경우
                else{
                    king.y--;
                }
            }

            if(p.equals("RB")){
                
                //넘치는 경우
                if(king.y - 1 < 0 || king.x + 1 >= 8) {
                    continue;
                }

                //그 자리에 돌이 있는 경우
                else if(map[king.y-1][king.x+1] == 2){
                    if(king.y - 2 < 0 || king.x+2 >= 8) continue;
                    
                    //돌을 밀 수 있는 경우
                    else {
                        map[king.y-2][king.x+2] = 2;
                        map[king.y-1][king.x+1] = 0;
                        king.y--;
                        king.x++;
                    }
                }
                
                //이동 가능한 경우
                else{
                    king.y--;
                    king.x++;
                }
            }

            if(p.equals("LB")){
                
                //넘치는 경우
                if(king.y - 1 < 0 || king.x - 1 < 0) {
                    continue;
                }

                //그 자리에 돌이 있는 경우
                else if(map[king.y-1][king.x-1] == 2){
                    if(king.y - 2 < 0 || king.x - 2 < 0) continue;
                    
                    //돌을 밀 수 있는 경우
                    else {
                        map[king.y-2][king.x-2] = 2;
                        map[king.y-1][king.x-1] = 0;
                        king.y--;
                        king.x--;
                    }
                }
                
                //이동 가능한 경우
                else{
                    king.y--;
                    king.x--;
                }
            }

            if(p.equals("RT")){
                
                //넘치는 경우
                if(king.y + 1 >= 8 || king.x + 1 >= 8) {
                    continue;
                }

                //그 자리에 돌이 있는 경우
                else if(map[king.y+1][king.x+1] == 2){
                    if(king.y+2 >= 8 || king.x+2 >= 8) continue;
                    
                    //돌을 밀 수 있는 경우
                    else {
                        map[king.y+2][king.x+2] = 2;
                        map[king.y+1][king.x+1] = 0;
                        king.y++;
                        king.x++;
                    }
                }
                
                //이동 가능한 경우
                else{
                    king.y++;
                    king.x++;
                }
            }

            if(p.equals("LT")){
                
                //넘치는 경우
                if(king.y + 1 >= 8 || king.x - 1 < 0) {
                    continue;
                }

                //그 자리에 돌이 있는 경우
                else if(map[king.y+1][king.x-1] == 2){
                    if(king.y+2 >= 8 || king.x-2 < 0) continue;
                    
                    //돌을 밀 수 있는 경우
                    else {
                        map[king.y+2][king.x-2] = 2;
                        map[king.y+1][king.x-1] = 0;
                        king.y++;
                        king.x--;
                    }
                }
                
                //이동 가능한 경우
                else{
                    king.y++;
                    king.x--;
                }
            }
        }

        System.out.print((char)(king.x+'A'));
        System.out.println(king.y+1);

        for(int i=0; i<8; i++){
            for(int r=0; r<8; r++){
                if(map[i][r] == 2){
                    System.out.print((char)(r+'A'));
                    System.out.print(i+1);
                    return;
                }
            }
        }
    }
}
