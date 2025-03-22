import java.io.*;
import java.util.*;

public class BaekJoon15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //카드 수
        int m = Integer.parseInt(st.nextToken()); //합체 수

        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        long a, b;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) queue.add(Long.parseLong(st.nextToken()));

        for(int i=0; i<m; i++){
            a = queue.poll();
            b = queue.poll();

            a += b;
            b = a; //연산 수행

            queue.add(a);
            queue.add(a);
        }

        //각각의 숫자를 가장 작게 만들어야 한다. 그러면 작은 숫자부터 더해야
        //우선순위 큐??

        long sum = 0;
        while(!queue.isEmpty()){
            sum += queue.poll();
        }

        System.out.print(sum);
    }
}
