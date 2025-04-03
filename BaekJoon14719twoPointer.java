import java.io.*;
import java.util.*;

public class BaekJoon14719twoPointer {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int arr[] = new int[w];
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        
        //exception
        if(w == 1){
            System.out.print(0);
            return;
        }

        //입력
        for(int i=0; i<w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //계산
        int line = 0;
        int p1 = 0, p2 = w - 1;

        while (p1 < p2) {
            line = Math.max(line, Math.min(arr[p1], arr[p2])); //낮은 높이

            if(arr[p1] > arr[p2]) {
                sum += line - arr[p2--];
            }

            else{
                sum += line - arr[p1++];               
            }

            if(p2 < 0 || p1 >= w) break;
        }
        
        System.out.print(sum);
    }
}
