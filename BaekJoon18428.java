import java.io.*;
import java.util.*;

class Point{
    int x, y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BaekJoon18428 {
    static int map[][], n, index = -1, hurdle = 0;
    static LinkedList<Point> teacher = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[n][n];

        //input
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int r=0; r<n; r++){
                map[i][r] = st.nextToken().charAt(0);

                if(map[i][r] == (int)'T') teacher.add(new Point(r, i));
            }
        }

        //(1,1) ~ (1, 4) 사이 아무데에나 장애물이 하나 필요함을 어떻게 저장할 수 있을까
        //선생이 나란히 있으면 겹치는 부분에 장애물을 설치해야한다
        //그냥 맵에다가 번호로 장애물이 필요한 위치 저장할까??\
        //이미 다른 번호가 존재하면 거기에 저장하고 해당 번호들 모두 비운다

        //계산
        for(int i=0; i<teacher.size(); i++){
            findStudent(teacher.get(i));
        }

        for(int i=0; i<n; i++){
            for(int r=0; r<n; r++){
                if(map[i][r] < 0) {
                    if(hurdle < 3) {
                        hurdle++;
                        delete(map[i][r]);
                    }
                    else{
                        System.out.println("NO");
                        System.exit(0);
                    }
                }
            }
        }


        System.out.println("YES");
    }

    //저 멀리서부터 내 위치까지 탐색해서 학생이 있으면 체크하되 학생이 둘 이상이면
    //나에게 가까운 쪽과 내 사이에 장애물이 위치해야함

    //아니 그냥 학생도 위치 저장해놓고 돌려버릴까


    static void findStudent(Point p){
        int find = -1;

        //오른쪽
        for(int i=p.x; i<n; i++){
            //다른 선생으로 인해 이미 장애물이 필요한 경우
            if(map[p.y][i] < 0){
                if(hurdle == 3){
                    System.out.println("NO");
                    System.exit(0);
                }

                delete(map[p.y][i]);

                map[p.y][i] = 'O';
                hurdle++;
                break;
            }

            else if(map[p.y][i] == 'O'){
                break;
            }

            else if(map[p.y][i] == 'S'){
                if(i == p.x + 1) {
                    System.out.println("NO");
                    System.exit(0);
                }
                find = i;
                break;
            }
        }

        if(find != -1){
            for(int i=p.x+1; i<find; i++){
                map[p.y][i] = index;
            }
            index--;
        }
        

        //왼쪽
        find = -1;
        
        for(int i=p.x; i>=0; i--){
            //다른 선생으로 인해 이미 장애물이 필요한 경우
            if(map[p.y][i] < 0){
                if(hurdle == 3){
                    System.out.println("NO");
                    System.exit(0);
                }

                delete(map[p.y][i]);

                map[p.y][i] = 'O';
                hurdle++;
                break;
            }

            else if(map[p.y][i] == 'O'){
                break;
            }

            else if(map[p.y][i] == 'S'){
                if(i == p.x - 1) {
                    System.out.println("NO");
                    System.exit(0);
                }

                find = i;
                break;
            }
        }

        if(find != -1){
            for(int i=p.x-1; i>find; i--){
                map[p.y][i] = index;
            }
            index--;
        }

        //위쪽
        find = -1;
        
        for(int i=p.y; i>=0; i--){
            //다른 선생으로 인해 이미 장애물이 필요한 경우
            if(map[i][p.x] < 0){
                if(hurdle == 3){
                    System.out.println("NO");
                    System.exit(0);
                }

                delete(map[i][p.x]);

                map[i][p.x] = 'O';
                hurdle++;
                break;
            }

            else if(map[i][p.x] == 'O'){
                break;
            }

            else if(map[i][p.x] == 'S'){
                if(i == p.y - 1) {
                    System.out.println("NO");
                    System.exit(0);
                }
                find = i;
                break;
            }
        }

        if(find != -1){
            for(int i=p.y-1; i>=0; i--){
                map[i][p.x] = index;
            }
            index--;
        }


        //아래쪽
        find = -1;
        
        for(int i=p.y; i<n; i++){
            //다른 선생으로 인해 이미 장애물이 필요한 경우
            if(map[i][p.x] < 0){
                if(hurdle == 3){
                    System.out.println("NO");
                    System.exit(0);
                }

                delete(map[i][p.x]);

                map[i][p.x] = 'O';
                hurdle++;
                break;
            }

            else if(map[i][p.x] == 'O'){
                break;
            }

            else if(map[i][p.x] == 'S'){
                if(i == p.y + 1) {
                    System.out.println("NO");
                    System.exit(0);
                }
                find = i;
                break;
            }
        }

        if(find != -1){
            for(int i=p.y+1; i<n; i++){
                map[i][p.x] = index;
            }
            index--;
        }
    }

    static void delete(int index){
        for(int i=0; i<n; i++){
            for(int r=0; r<n; r++){
                if(map[i][r] == index) map[i][r] = 'X';
            }
        }
    }
}
