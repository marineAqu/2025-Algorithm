import java.io.*;
import java.util.*;

public class BaekJoon12851 {
    
    static int map[];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;

        if (n == k){
            System.out.println(0);
            System.out.println(1);
            return;
        }

        else if (n > k){
            System.out.println(n-k);
            System.out.println(1);
            return;
        }

        else{
            map = new int[k*2];
            Arrays.fill(map, 1000000);
            map[n] = 0;
            queue.add(n);

            int now;
            while (!queue.isEmpty()) {
                now = queue.poll();

                if(now == k){
                    count++;
                    continue;
                }

                if(now + 1 <= k && map[now+1] >= map[now] + 1){
                    map[now+1] = map[now] + 1;
                    queue.add(now+1);
                }
                if(now - 1 >= 0 && map[now-1] >= map[now] + 1){
                    map[now-1] = map[now] + 1;
                    queue.add(now-1);
                }
                if(now *2 < k*2 && map[now*2] >= map[now] + 1){
                    map[now*2] = map[now] + 1;
                    queue.add(now*2);
                }
            }

            System.out.println(map[k]);
            System.out.println(count);
        }
    }
}
