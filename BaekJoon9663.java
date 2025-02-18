import java.util.Scanner;

public class BaekJoon9663 {
    static int arr[]; //퀸의 위치
    static int answer = 0;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n];

        //대표적인 백트래킹 문제
        //퀸은 대각선, 상하좌우로 칸 제한 없이 이동할 수 있다.


        //n * n인 체스판 위에 퀸 n개를 올린다.

        //1. 일단 같은 열, 같은 행에는 절대 올 수 없다.
        //-> 1차원 배열로 하고, i는 행이고 값은 해당 행에 퀸이 위치한 열로 계산한다.

        nQueen(n, 0);


        System.out.print(answer);
    }

    static boolean isItAble(int depth, int point){

        for(int i=0; i<depth; i++){
            //가로는 이미 뺐고 세로, 대각선을 체크해야 한다.
            if(arr[i] == point) return false; //세로가 겹치는 경우
            if(Math.abs(point - arr[i]) == Math.abs(depth - i)) return false; //대각선이 겹치는 경우
        }

        return true;
    }

    static void nQueen(int n, int depth){
        if(n == depth) {
            answer++;
            return;
        }

        for(int i=0; i<n; i++){

            if(isItAble(depth, i) == true){
                arr[depth] = i;
                
                nQueen(n, depth+1);
            }

        }

    }
}
