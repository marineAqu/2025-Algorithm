import java.io.*;
import java.util.*;

public class BaekJoon2473 {
    static long arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int a = 0, b = 0, c = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new long[n];
        long zeroClose = Long.MAX_VALUE;

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int p1, p2;
        for(int i=0; i<n-2; i++) {
            p1 = i+1;
            p2 = n-1;
            
            //이분탐색
            while(p1 < p2){
                if(Math.abs(arr[i] + arr[p1] + arr[p2])  < zeroClose) {
                    zeroClose = Math.abs(arr[i] + arr[p1] + arr[p2]);
                    a = i;
                    b = p1;
                    c = p2;
                }

                if(arr[i] + arr[p1] + arr[p2] > 0) p2--;
                else p1++;
            }
        }

        System.out.print(arr[a] + " " + arr[b] + " " + arr[c]);
    }
}
