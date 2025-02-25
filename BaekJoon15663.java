import java.util.Arrays;
import java.util.Scanner;

//재귀호출하기 때문에 각 dfs마다 변수를 공유하면 안되는데 그 변수를 static으로 사용하는 바보같은 짓을 저질렀다

public class BaekJoon15663 {
    static int n, m;
    static int[] arr;
    static int[] visited;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        visited = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);

        // n개의 자연수 중 m개를 고른다.

        dfs("", 0);
    }


    static void dfs(String line, int depth) {
        if (depth == m) {
            System.out.println(line);
            return;
        }

        int nowIndex = -1;
        int tempNum = 0;

        for (int i = 0; i < n; i++) {
            if (tempNum >= n) return;
            
            //바로 전 출력과 같은 경우
            if (nowIndex != -1 && arr[nowIndex] == arr[tempNum]) {
                tempNum++;
                continue;
            }

            //내가 있는 이 줄에서 나와 같은 인덱스를 가지면 안 된다
            if (visited[tempNum] >= 1) {
                tempNum++;
                continue;
            }

            visited[tempNum]++;
            dfs(line + arr[tempNum] + " ", depth + 1);
            visited[tempNum]--;
            
            nowIndex = tempNum;
            tempNum++;
        }
    }

}