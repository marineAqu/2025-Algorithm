import java.io.*;
import java.util.*;

class Gem{
    int size, price;

    Gem(int size, int price){
        this.size = size;
        this.price = price;
    }
}

public class BaekJoon1202_PriorityQueue {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Gem> queue = new PriorityQueue<>((o1, o2) -> o2.price - o1.price);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] gems = new int[n][2];

        //보석
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            gems[i][0] = Integer.parseInt(st.nextToken()); //무게
            gems[i][1] = Integer.parseInt(st.nextToken()); //가격
        }

        //크기 오름차순
        Arrays.sort(gems, (o1, o2) -> o1[0] - o2[0]);

        //가방
        int[] bag = new int[k];
    
        for(int i=0; i<k; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        //오름차 정렬
        Arrays.sort(bag);
        
        long answer = 0;
        int temp = 0;

        Gem g;
        for(int i=0; i<k; i++) {
            //가방에 들어갈 수 있는 것들 중 가장 가격이 높은 것을 넣기
            while(temp < n && gems[temp][0] <= bag[i]){
                queue.add(new Gem(gems[temp][0], gems[temp][1]));
                temp++;
            }

            try{
                g = queue.poll();
                answer += g.price;
            } catch(Exception e){
                continue;
            }
        }

        System.out.println(answer);
    }
}
