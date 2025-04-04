import java.util.*;
import java.io.*;


class Info {
    int index, num;

    Info(int index, int num){
        this.index = index;
        this.num = num;
    }
}

public class BaekJoon1083 {
    public static void main(String[] args) throws IOException {
        //큰 숫자일수록 가장 앞에 오게끔 sort하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[n];
        int temp;

        //index가 s보다 작거나 같은 것 중 가장 큰 것을 가장 왼쪽으로 이동
        //s 차감
        //다시 index가 (업데이트된) s보다 작거나 같은 것 중 가장 큰 것을 골라 왼쪽으로 이동
        //이를 무한 반복
        
        int s = Integer.parseInt(br.readLine());
        int count = s;
        Info now;

        //Exception
        if(n * (n+1) / 2 <= s){
            for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);

            for(int i=n-1; i>=0; i--) System.out.print(arr[i]+" ");
            System.exit(0);
        }

        arr[0] = Integer.parseInt(st.nextToken());

        for(int i=1; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int front = 0;
        while (count > 0 && front < n) {
            now = new Info(front, arr[front]);
            for(int i=front; i<n && i<=count + front; i++){
                if(now.num < arr[i]) now = new Info(i, arr[i]);
            }

            //찾았다면 교환
           for(int i=now.index; i>front; i--){
                temp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = temp;
                
                count--;
            }
            
            //찾았다면 지금 단위에서 지금 걸 제외하고 가장 큰 값을 또 앞으로 옮기고
            //못찾았으면 다음 단위로 옮긴다
            front++;
        }

        //출력
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
