import java.util.*;
import java.io.*;

public class BaekJoon10775_unionFind {
    static int boss[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        boss = new int[g+1];

        for(int i=1; i<=g; i++) boss[i] = i;
        
        int now;
        for(int i=0; i<p; i++) {
            now = Integer.parseInt(br.readLine());

            if(find(now) != 0) union(find(now), find(now) - 1);
            else {
                System.out.print(i);
                return;
            }
        }

        System.out.print(p);
    }

    static int find(int now){
        if(boss[now] == now) return now;
        else return boss[now] = find(boss[now]);
    }

    static void union(int a, int b){
        boss[find(a)] = find(b);
    }
}
