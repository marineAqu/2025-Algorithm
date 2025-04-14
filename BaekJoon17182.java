import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon17182 {
    static int n, k;
    static int map[][];
    static boolean visited[];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n];

        //모든 곳을 들려야한다.들렸던 곳을 또 들려도 괜찮다
        //행성은 최대 10개
        //일단 a에서 b로 가는 모든 경우의 최단거리를 저장해두어야하나
        //그런데 내가 a로 위치를 옮겼고 최단거리가 b라면 

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int r=0; r<n; r++){
                map[i][r] = Integer.parseInt(st.nextToken());
            }
        }

        //최단거리 계산
        for(int i=0; i<n; i++){
            for(int r=0; r<n; r++){
                for(int t=0; t<n; t++){
                    map[r][t] = Math.min(map[r][t], map[r][i] + map[i][t]);
                }
            }
        }

        method(k, 0, 0);

        System.out.print(answer);
    }

    //가장 가까운 행성으로 가는 것만이 전체 최단경로는 아니라서???
    //그러면 10! 인데

    static void method(int now, int depth, int sum){
        if(depth == n-1){
            answer = Math.min(answer, sum);
            return;
        }

        visited[now] = true;

        //이다음 행성 찾기
        for(int i=0; i<n; i++){
            if(visited[i] == false) method(i, depth + 1, sum + map[now][i]);
        }

        visited[now] = false;
    }

    /*
    static void method(int now, int sum){
        int minVal = Integer.MAX_VALUE, minIndex = -1;

        visited[now] = true;

        //가장 가까운 행성 찾기
        for(int i=0; i<n; i++){
            if(visited[i] == false && minVal > map[now][i]){
                minVal = map[now][i];
                minIndex = i;
            }
        }

        if(minIndex == -1){
            answer = sum;
            return;
        }

        //가장 가까운 행성으로 이동
        method(minIndex, sum + minVal);
    }
         */
}
