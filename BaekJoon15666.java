import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon15666 {
    static int n, m;
    static int[] arr;
    static int[] visited;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        visited = new int[m];

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        Arrays.fill(visited, -1);

        //같은 수 중복 선택 가능, 오름차순, 중복 조합 출력 X

        dfs("", 0, 0);

    }

    //인덱스 관점에서
    // 0 0 0 0
    // 0 0 0 1
    // 0 0 1 1
    // 1 1 2 2
    // 1 2 2 2

    // 여기서 중복을 빼야한다

    static void dfs(String line, int depth, int beforeIndex){
        if(depth == m) {
            System.out.println(line);
            return;
        }

        for(int i=beforeIndex; i<n; i++) {
            //7 9 / 7 9 중복 문제: 같은 dfs for문 내에서 생김 
            if(i != beforeIndex && arr[i-1] == arr[i])
                continue;
            
            visited[depth] = i;

            dfs(line + arr[i] + " ", depth + 1, i);
        }
    }
}
