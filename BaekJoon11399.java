import java.io.*;
import java.util.*;

public class BaekJoon11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long arr[] = new long[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        long sum = 0;
        //누적합을 가장 작게 
        for(int i=1; i<n+1; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        for(int i=1; i<n+1; i++) arr[i] += arr[i-1];
        for(int i=1; i<n+1; i++) sum += arr[i];
        
        System.out.print(sum);
    }
}