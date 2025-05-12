import java.io.*;
import java.util.*;

public class BaekJoon1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int now, a, b;
        for(int i=0; i<n; i++){
            now = Integer.parseInt(br.readLine());

            if(left.size() == right.size()) left.add(now);
            else right.add(now);

            if(!left.isEmpty() && !right.isEmpty() && (left.peek() > right.peek())){
                a = left.poll();
                b = right.poll();

                right.add(a);
                left.add(b);
            }
            
            sb.append(left.peek()).append("\n");
        }

        System.out.print(sb);
    }
}
