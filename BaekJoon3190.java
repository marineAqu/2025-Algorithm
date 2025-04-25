import java.io.*;
import java.util.*;

public class BaekJoon3190 {
    static int map[][], n;
    static int body[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //2~100
        int k = Integer.parseInt(br.readLine()); //0~100

        map = new int[n][n];
        map[0][0] = 2;
        body = new int[102][2];
        body[0][0] = 0; body[0][1] = 0;

        StringTokenizer st;
        //사과 정보 저장
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }

        int L = Integer.parseInt(br.readLine()); //0~100
        
        //꼬리가 증가하는 게 의미가 있나?? -> 자기자신에게 부딪히는 경우때문에

        //직접 맵에 뱀을 그리면 
        //추적하기가 어려울 것 같으니 링크드리스트로 연달아 저장??
        int tail = 0;

        int time = 1;

        int changeDirc[] = new int[10001];

        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            changeDirc[Integer.parseInt(st.nextToken())] = (int)st.nextToken().charAt(0);
        }

        //1. 벽에 부딪히는지 확인
        //2. 사과가 있는지 확인 + 몸통과 부딪히진 않는지 확인
        // - 꼬리, 머리 이동

        int dirct = 0; //0은 오른쪽

        while(true){
            if(dirct == 0){
                if(body[0][0] + 1 == n) break;
                if(map[body[0][1]][body[0][0]+1] == 2) {
                    break;
                }

                //사과가 아니면 꼬리 이동
                if(map[body[0][1]][body[0][0]+1] != 1){
                    map[body[tail][1]][body[tail][0]] = 0;
                    changePoint(tail);
                    //tail = findTail(body[tail][0], body[tail][1]);
                }

                else {
                    tail++;
                    changePoint(tail);
                }

                //머리 이동
                map[body[0][1]][body[0][0]+1] = 2;
                body[0][0]++;
            }

            else if(dirct == 1){ //1은 왼쪽
                if(body[0][0] - 1 == -1) break;
                if(map[body[0][1]][body[0][0]-1] == 2) {
                    break;
                }

                //사과가 아니면 꼬리 이동
                if(map[body[0][1]][body[0][0]-1] != 1){
                    map[body[tail][1]][body[tail][0]] = 0;
                    
                    changePoint(tail);
                    //tail = findTail(body[tail][0], body[tail][1]);
                }

                else {
                    tail++;
                    changePoint(tail);
                }

                //머리 이동
                map[body[0][1]][body[0][0]-1] = 2;
                body[0][0]--;
            }

            else if(dirct == 2){ //2은 위쪽
                if(body[0][1] - 1 == -1) break;
                if(map[body[0][1]-1][body[0][0]] == 2) {
                    //몸통과 부딪히는 경우인데 꼬리가 아닌 경우
                    //   -> 아니다. 문제를 보면 머리를 한칸 다음에 위치시킨 다음에, 동시가 아니라 그 다음 꼬리를 줄임.
                    //      즉 꼬리라도 부딪히면 멈춰야한다.
                    break;
                }

                //사과가 아니면 꼬리 이동
                if(map[body[0][1]-1][body[0][0]] != 1){
                    map[body[tail][1]][body[tail][0]] = 0;
                    
                    changePoint(tail);
                    //tail = findTail(body[tail][0], body[tail][1]);
                }

                else {
                    tail++;
                    changePoint(tail);
                }

                //머리 이동
                map[body[0][1]-1][body[0][0]] = 2;
                body[0][1]--;
            }

            else if(dirct == 3){ //3은 아래쪽
                if(body[0][1] + 1 == n) break;
                if(map[body[0][1]+1][body[0][0]] == 2) {
                    //몸통과 부딪히는 경우인데 꼬리가 아닌 경우
                    break;
                }

                //사과가 아니면 꼬리 이동
                if(map[body[0][1]+1][body[0][0]] != 1){
                    map[body[tail][1]][body[tail][0]] = 0;
                    
                    changePoint(tail);
                    //tail = findTail(body[tail][0], body[tail][1]);
                }

                else {
                    tail++;
                    changePoint(tail);
                }
                
                //머리 이동
                map[body[0][1]+1][body[0][0]] = 2;
                body[0][1]++;
            }

            if(changeDirc[time] != 0) {
                if(changeDirc[time] == (int)'D') {
                    if(dirct == 0) dirct = 3;
                    else if(dirct == 1) dirct = 2;
                    else if(dirct == 2) dirct = 0;
                    else if(dirct == 3) dirct = 1;
                }
                else {
                    if(dirct == 0) dirct = 2;
                    else if(dirct == 1) dirct = 3;
                    else if(dirct == 2) dirct = 1;
                    else if(dirct == 3) dirct = 0;
                }
            }
            time++;
            //System.out.println("time: "+time);
            //System.out.println("dirct: "+dirct);
        }

        //for(int i=0; i<changeDirc.length; i++){
        //    System.out.print(changeDirc[i]+" ");
        //}

        /*
        for(int i=0; i<n; i++){
            for(int r=0; r<n; r++) System.out.print(map[i][r]+" ");
            System.out.println();
        }
        */
        System.out.println(time);
    }

    static void changePoint(int tail){
        for(int i=tail-1; i>=0; i--){
            body[i+1][0] = body[i][0];
            body[i+1][1] = body[i][1];
        }
    }
}
