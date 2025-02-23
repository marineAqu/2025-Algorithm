import java.util.*;

public class BaekJoon15652 {
    static int n, m;
    static int arr[];

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m+1];
        Arrays.fill(arr, 1);
        //n개의 자연수 중 m개를 고른 수열, 중복 가능
        //오름차
        //겹치는 조합은 출력하지 않는다

        dfs("", 1);
    }

    static void dfs(String line, int depth){
        if(depth == m+1){
            System.out.println(line);
            return;
        }

        for(int i=1; i<=n; i++) {
            dfs(line + arr[depth] + " ", depth + 1);

            if(arr[depth] + 1 <= n) {
                arr[depth]++;
                for(int k=depth+1; k<=m; k++) arr[k] = arr[depth];
            }
            else return;
        }
    }
}
