import java.io.*;
import java.util.*;

public class BaekJoon2036 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> plusQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        int now;
        long sum = 0, a , b;
        boolean haveZero = false;

        for(int i=0; i<n; i++) {
            now = Integer.parseInt(br.readLine());
            if(now < 0) minusQueue.add(now);
            else if(now > 0) plusQueue.add(now);
            else haveZero = true;
        }

        while (plusQueue.size() > 1) {
            a = plusQueue.poll();
            b = plusQueue.poll();

            if(a == 1 || b == 1) sum += a+b;
            
            else sum += a*b;
        }

        while (minusQueue.size() > 1) {
            a = minusQueue.poll();
            b = minusQueue.poll();
            
            sum += a*b;
        }

        if(plusQueue.size() == 1) sum += plusQueue.poll();
        if(minusQueue.size() == 1) {
            if(!haveZero) sum += minusQueue.poll();
        }

        System.out.println(sum);

        //음수도 큰 것 끼리 곱하는 게 좋다.
        // -10 -5 -3 -2 -1
        //50 + 6 -1
        //2 + 15 - 10

        //한 정수를 제거하는 경우 그 정수가 점수
        //두 정수를 제거하는 경우 두 정수의 곱이 점수

        //이렇게 수열에 아무 수도 안 남았을 때 점수 총합의 최대

        //3 + 25 +1
        //29

        //그러면 음수 개수 세서 짝수면 음수끼리 곱하게 한다
        //남은 수 중에서는 큰 수끼리 곱하는 게 좋다. 무조건 곱하는 게 좋음

        //수는 최대 100,000 십만
    }
}
