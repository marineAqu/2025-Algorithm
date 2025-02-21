import java.util.*;

public class BaekJoon15654 {
    static int n, m;
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    static int arr[];

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n];
        arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);

        //n개의 자연수 중 m개를 고른 수열. (숫자 중복 ㄴ, 사전순)
        //sb.append(dfs("", 0));
        dfs("", 0);
        
        System.out.print(sb);
    }

    static void dfs(String line, int depth){
        if(depth == m) {
            sb.append(line).append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i] == false){
                visited[i] = true;

                dfs(line+arr[i]+" ", depth+1);
                visited[i] = false;
            }
        }
    }
}
