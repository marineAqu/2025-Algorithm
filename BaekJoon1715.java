import java.util.*;
import java.io.*;

public class BaekJoon1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long count = 0;

        //작은 것끼리 먼저 합해야 한다
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i<n; i++) queue.add(Integer.parseInt(br.readLine()));

        int a, b;
        
        while (queue.size() != 1) {
            a = queue.poll();
            b = queue.poll();

            queue.add(a+b);
            count += (a+b);
        }

        System.out.println(count);
    }
}
