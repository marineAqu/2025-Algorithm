import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1976 {
    static int boss[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boss = new int[n];
        
        for(int i=0; i<n; i++) boss[i] = i;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int t=0; t<n; t++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    union(i, t);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int before = 0, after = 0;
        after = Integer.parseInt(st.nextToken());
        before = after;
        
        String isYes = "YES";

        while (st.hasMoreTokens()) {
            after = Integer.parseInt(st.nextToken());
            if(find(before-1) != find(after-1)) {
                isYes = "NO";
                break;
            }
        }

        System.out.print(isYes);
        
    }

    static void union(int a, int b){
        boss[find(a)] = boss[find(b)];
    }
    
    static int find(int a){
        if(boss[a] == a) return a;
        else return boss[a] = find(boss[a]);
    }
}
