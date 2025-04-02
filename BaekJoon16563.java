import java.io.*;
import java.util.*;

public class BaekJoon16563 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int now, r;
        int arr[] = new int[5000001];

        //소수
        for(int i=2; i<5000001; i++) {
            if(arr[i] != 0) continue;

            arr[i] = i;

            for(r=2; r*i<5000001; r++) {
                if(arr[i*r] == 0) arr[i*r] = i;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            now = Integer.parseInt(st.nextToken());
            r = 2;

            //ki는 5000000보다 작거나 같다.
            while(true) {
                if(arr[now] == now){
                    sb.append(now).append(" ");
                    break;
                }
                sb.append(arr[now]).append(" ");
                now /= arr[now];
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
