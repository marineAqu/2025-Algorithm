import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge4{
    int start, end, cost;
    Edge4(int start, int end,int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

// 플로이드-워셜로 풀어야 하는 문제인데 크기가 작아서 그런지 다익스트라로도 풀렸다.
// 이하 플로이드-워셜로 다시 풀이한 코드

public class BaekJoon2660_FW {
    static int distance[][];

    public static void main(String[] args) throws IOException {
        //즉 최단경로 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int minValue = 250000;
        distance = new int[n+1][n+2]; //n+1은 합산 저장

        //배열 Max로 초기화
        for(int i=1; i<=n; i++){
            for(int r=1; r<=n; r++) {
                if(r == i) continue;
                distance[i][r] = 250000;
            }
        }

        int a, b;
        
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        //입력
        while(a != -1) {
            distance[a][b] = 1;
            distance[b][a] = 1;

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
        }

        //거리 계산
        for(int i=1; i<=n; i++){
            for(int r=1; r<=n; r++) {
                for(int e=1; e<=n; e++){
                    distance[r][e] = Math.min(distance[r][e], distance[r][i] + distance[i][e]);
                }
            }
        }

        for(int i=1; i<=n; i++){
            //이제 합산 계산
            for(int r=1; r<=n; r++) {
                distance[i][n+1] = Math.max(distance[i][n+1], distance[i][r]);
            }

            minValue = Math.min(minValue, distance[i][n+1]);
        }

        PriorityQueue<Integer> list = new PriorityQueue<>();

        for(int i=1; i<=n; i++){
            if(distance[i][n+1] == minValue){
                list.add(i);
            }
        }

        //가장 작은 점수와 인원, 각 번호 출력
        System.out.println(minValue+" "+list.size());
        while (!list.isEmpty()) {
            System.out.print(list.poll() + " ");
        }
    }
}

