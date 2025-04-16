import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon13975 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testcase = Integer.parseInt(br.readLine());
        int k;
        long a, b, sum;
        PriorityQueue<Long> queue = new PriorityQueue<>();

        for(int i=0; i<testcase; i++){
            k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            sum = 0;

            for(int r=0; r<k; r++){
                queue.add(Long.parseLong(st.nextToken()));
            }
            
            while (queue.size() > 1) {
                a = queue.poll();
                b = queue.poll();

                queue.add(a+b);

                sum += a+b;
            }

            System.out.println(sum);
            queue.poll();
        }
    }
}
