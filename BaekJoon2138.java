import java.io.*;

public class BaekJoon2138 {
    static int arr[][], n;
    //첫번째 전구를 누르냐 마느냐에 따라 달라질 수 있으므로 두 경우 모두 테스트한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        String now = br.readLine();
        String goal = br.readLine();

        arr = new int[n][2];
        int count = 1;
        int answer = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){ 
            if(now.charAt(i) != goal.charAt(i)){
                arr[i][0] = 1; //눌러야 하는 경우
                arr[i][1] = 1;
            }
            else {
                arr[i][0] = 0; //이대로 두면 되는 경우
                arr[i][1] = 0;
            }
        }

        //계산1 (첫번째를 눌렀을 때)
        if(arr[0][0] == 0) arr[0][0] = 1;
        else arr[0][0] = 0;

        if(arr[1][0] == 0) arr[1][0] = 1;
        else arr[1][0] = 0;

        for(int i=1; i<n; i++){ 
            if(arr[i-1][0] == 1){
                count++;

                changeLight(i-1, 0);
                changeLight(i, 0);
                changeLight(i+1, 0);
            }
        }

        if(arr[n-1][0] == 0) answer = count;


        //계산2 (첫번째를 누르지 않았을 때)
        count = 0;
        for(int i=1; i<n; i++){ 
            if(arr[i-1][1] == 1){
                count++;

                changeLight(i-1, 1);
                changeLight(i, 1);
                changeLight(i+1, 1);
            }
        }
        if(arr[n-1][1] == 0) answer = Math.min(answer, count);

        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    static void changeLight(int i, int r){
        if(i<0 || i >= n) return;

        if(arr[i][r] == 0) arr[i][r] = 1;
        else arr[i][r] = 0;
    }
}
