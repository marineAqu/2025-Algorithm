import java.util.*;
import java.io.*;

public class BaekJoon11000 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int map[][] = new int[n][2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            map[i][0] = Integer.parseInt(st.nextToken()); //시작
            map[i][1] = Integer.parseInt(st.nextToken()); //종료
        }

        //시작하는 순서대로 정렬
        Arrays.sort(map, (o1, o2) -> o1[0] - o2[0]);

        int count = 1;

        //개수가 200,000개인데 전체가 같은 시간에 하는 강의라면
        //200,000 * 200,000번 검사 -> 40억 연산 정도
        //LinkedList 여러 회의실 종료시간을 동시에 체크해야하나


        //그럴거면 우선순위 큐에 끝나는 시간을 넣고 poll했는데(그러면 제일 일찍 끝나는 강의실을 알 수 있다)
        // 걔보다 작으면 poll한거 다시 넣고 하나 더 넣기.
        // 걔보다 크면 내 끝나는 시간 다시 넣어주면 됨


        PriorityQueue<Integer> end = new PriorityQueue<>();
        int now;

        end.add(map[0][1]);

        for(int i=1; i<n; i++) {
            now = end.poll();

            if(now <= map[i][0]) end.add(map[i][1]);
            else{
                end.add(now);
                end.add(map[i][1]);
                count++;
            }
        }

        System.out.print(count);
        
    }
}
