import java.io.*;
import java.util.*;

public class BaekJoon9663 {
    static int n, arr[];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        method(0);

        System.out.print(count);
    }

    static void method(int depth){
        if(depth == n){
            count++;
            return;
        }

        boolean flag;

        for(int i=0; i<n; i++){
            flag = true;
            
            //검사
            for(int r=0; r<depth; r++){
                if(arr[r] == i) {
                    flag = false;
                    break;
                }

                if(Math.abs(arr[r] - i) == Math.abs(r - depth)){
                    flag = false;
                    break;
                }
            }

            //검사 후
            if(flag == true) {
                arr[depth] = i;
            
                method(depth+1);
            }
        }
    }
}
