import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1719{
    
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int distance[][] = new int[n+1][n+1];
        int answer[][] = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int k=1; k<=n; k++){
                if(i == k) distance[i][k] = 0;
                else distance[i][k] = 10000001;
            }
        }

        for(int i=1; i<=n; i++){
            for(int k=1; k<=n; k++){
                answer[i][k] = k;
            }
        }

        int a, b, c;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(distance[a][b] > c) {
                distance[a][b] = c;
                answer[a][b] = b;
            }

            if(distance[b][a] > c) {
                distance[b][a] = c;
                answer[b][a] = a;
            }
        }


        //6에서 1 가는 경우에서 문제 발생
        // 6 - 2
        // 2로 가려면 5
        // 표에 6출발 1도착은 2라 되어있지만 사실은 2 전에 5부터 가야한다
        // 플로이드 워셜로 하니까 애초부터 5라고 표기되는데 이러면 5로 도착하고 더 갈 데가 없어서 안됨
        //왜지??? 왜이렇게갱신되는거지

        //distance[1][6] = distance[1][5] + distance[5][6]
                    //      = distance[1][2] + distance[2][6]
                    // 그러니까 5도, 2도 답이 되는데 인덱스 상 작은 값이 먼저 들어간다.
                    // 제약조건으로 if(answer[5][6] == 6) 이면 패스하는 걸로 할까
                    // 패스하면 정작 정말 그렇게 지나가는 애들이 업데이트가 안 된다
                    // 그러면 ==인 경우도 포함해서 만약 그 사이에 중간에 들리는 값이 있다면 업데이트

        //계산
        for(int i=1; i<=n; i++){
            for(int k=1; k<=n; k++){
                for(int r=1; r<=n; r++){

                    if(distance[k][r] > distance[k][i] + distance[i][r]) {
                        //갱신되는 경우: i를 들리는 편이 더 짧은 경우
                        distance[k][r] = distance[k][i] + distance[i][r];
                        answer[k][r] = i;
                    }
                }
            }
        }

        //정확한 표기를 위한 다시 반복
        for(int i=1; i<=n; i++){
            for(int k=1; k<=n; k++){
                for(int r=1; r<=n; r++){

                    if(distance[k][r] == distance[k][i] + distance[i][r]) {
                        //처음 들리는 부분을 정확하게 표기하기 위해서

                        //나는 한군데 더 들릴 곳이 있는데 현재 저장은 그렇지 않은 경우
                        if(answer[k][r] != i && answer[k][answer[k][r]] != answer[k][r]) {
                            answer[k][r] = answer[k][answer[k][r]];
                        }
                    }
                }
            }
        }

        //출력
        for(int i=1; i<=n; i++){
            for(int k=1; k<=n; k++){
                if(i == k) sb.append("- ");
                else sb.append(answer[i][k]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}