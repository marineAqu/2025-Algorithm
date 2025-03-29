import java.util.*;
import java.io.*;

class BaekJoon15651 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        method(0, "");

        System.out.print(sb);
    }

    static void method(int depth, String line){
        if(depth == m) {
            sb.append(line).append("\n");
            return;
        }
        
        for(int i=1; i<=n; i++){
            method(depth+1, line+i+" ");
        }
    }
}
