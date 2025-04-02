import java.io.*;
import java.util.*;

public class BaekJoon1041 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int dirc[][] = {{1, 2, 4, 3}, {5, 3, 0, 2}, {1, 0, 4, 5}, 
                        {1, 0, 4, 5}, {0, 2, 5, 3}, {1, 3, 4, 2}};

        int arr[] = new int[6]; //n^3 최대 125000
        long min = 100;

        for(int i=0; i<6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(min > arr[i]) min = arr[i];
        }

        //1에 대한 예외처리를 하지 않아서 틀림.
        if(n == 1){
            Arrays.sort(arr);
            int sum = 0;
            for(int i=0; i<5; i++) sum += arr[i];
            System.out.print(sum);
            return;
        }

        long min3 = 201;
        for(int i=0; i<6; i++){
            for(int r=0; r<3; r++){
                min3 = Math.min(min3, arr[i] + arr[dirc[i][r]] + arr[dirc[i][r+1]]);
            }

            min3 = Math.min(min3, arr[i] + arr[dirc[i][0]] + arr[dirc[i][3]]);
        }

        long min2 = 101;
        for(int i=0; i<6; i++){
            for(int r=0; r<4; r++){
                min2 = Math.min(min2, arr[i] + arr[dirc[i][r]]);
            }
        }

        System.out.println((4 * min3) + (min2 * (8 * n - 12)) + ((5 * n * n ) - (16 * n) + 12) * min);

        //0 - 1 2 4 3
        //1 - 5 3 0 2
        //2 - 1 0 4 5
        //3 - 1 0 4 5
        //4 - 0 2 5 3
        //5 - 1 3 4 2

        //한 면이 안보임.
        //세 면이 보이는 것 4개, 두 면이 보이는 것 (n-2)*4+(n-1)*4개, 나머지(n*n*5 - 4*3 - ((n-2)*4+(n-1)*4)*2)는 한 면만 보인다.

        //= 세 면이 보이는 것 4개
        // 두 면이 보이는 것 4n - 8 + 4n- 4 = 8n - 12
        //나머지 (한 면만 보이는 것): 5n^2 - 12 - ((8n-12))*2) = 5n^2 - 12 - 16n + 24 = 5n^2 - 16n + 12

        //세 면의 합이 가장 작은 경우, 두 면의 합이 가장 작은 경우를 구해야 한다.

        //1. 세 면의 합이 가장 작은 경우
        //   내 좌우상하 4개를 연결하고 2개씩 더하며 최솟값 찾기??

        //세 면의 합이면 연달아서면 X, 즉 D A C와 EABF 조합은 불가
        // DEC도 안됨
        //세면은 연달아서가 안되고, 두 면은 꼭 연달아야함 -> 6개중 3개 조합은  n*n-1/2 -> 3*5 = 15개 조합


        //n이 1백만, n^2 * 5 = 10^14 


    }
}
