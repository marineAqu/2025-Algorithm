import java.util.*;
import java.lang.*;
import java.io.*;

class BaekJoon1697 {
    static int map[] = new int[100001];
    static int n, k;
    static Queue<Integer> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(map, 1000000);
        map[n] = 0;

        if(n == k){
            System.out.print(0);
            return;
        }
        if(n > k){
            System.out.print(n - k);
            return;
        }

        //bfs 말고는 방법이 없을 것 같다
        bfs(n);

        System.out.print(map[k]);
    }

    static void bfs(int now){
        queue.add(now);
        
        while(!queue.isEmpty()){
            int i = queue.poll();

            if(i + 1 <= 100000 && map[i+1] > map[i] + 1) {
                map[i+1] = map[i] + 1;
                queue.add(i+1);
            }
            
            if(i*2 <= 100000 && map[i*2] > map[i] + 1) {
                map[i*2] = map[i] + 1;
                queue.add(i*2);
            }
            if(i-1 >= 0 && map[i-1] > map[i] + 1) {
                map[i-1] = map[i] + 1;
                queue.add(i-1);
            }
        }
    }
}
