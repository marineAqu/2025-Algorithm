import java.io.*;
import java.util.*;

public class BaekJoon1629 {

    static int a, b, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(cal(b));
    }

    public static long cal(int e){
        long now;
        if(e == 1) return a % c;

        if(e % 2 == 0){
            now = cal(e/2);
            return (now * now) % c;
        }

        else{
            now = cal(e/2);
            return (((now * now) % c) * (a % c)) % c;
        }
    }
}
