import java.io.*;
import java.util.*;

public class BaekJoon27172 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int arr[][] = new int[n][2];
        int map[] = new int[1000001]; // 0은 인덱스, 1은 점수 저장. 인덱스는 번호 자체

        int maxNum = 0;

        for(int i=0; i<n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());

            map[arr[i][0]] = i+1;

            maxNum = Math.max(arr[i][0], maxNum);
        }

        for(int i=1; i<=maxNum; i++){
            if(map[i] > 0){
                for(int r=i+i; r<=maxNum; r+=i){
                    if(map[r] > 0){
                        arr[map[r]-1][1]--;
                        arr[map[i]-1][1]++;
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++){
            System.out.print(arr[i][1]+" ");
        }
    }
}