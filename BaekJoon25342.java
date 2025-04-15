import java.io.*;
import java.util.*;

public class BaekJoon25342 {

    static long answer(int a, int b, int c){
        return lcm(lcm(a, b), c);
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static long gcd(long a, long b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int n;
        long re = 0;

        //0이면 소수.

        for(int i=0; i<testCase; i++){
            n = Integer.parseInt(br.readLine());
            
            re = 0;

            re = Math.max(re, answer(n-1, n-2, n-3));

            re = Math.max(re, answer(n, n-1, n-2));

            re = Math.max(re, answer(n, n-1, n-3));

            System.out.println(re);
        }
    }
}
