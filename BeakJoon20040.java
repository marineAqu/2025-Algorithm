import java.io.*;
import java.util.*;

public class BeakJoon20040 {

    //!!하나씩 이어가며 사이클 존재 유무는 무조건 유니온 파인드를 떠올리자

    static int boss[];
    static boolean isCycle= false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boss = new int[n];
        for(int i=0; i<n; i++) boss[i] = i;
        int a = 0, b = 0;

        //연결
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            union(a, b);
            if(isCycle == true){
                System.out.println(i+1);
                return;
            }
        }

        System.out.println(0);
    }

    static int find(int n){
        if(boss[n] == n) return n;
        else return boss[n] = find(boss[n]);
    }

    static void union(int a, int b){
        if(boss[find(a)] == boss[find(b)]) isCycle = true;
        else boss[find(a)] = boss[find(b)];
    }
}