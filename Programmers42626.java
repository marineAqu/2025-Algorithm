import java.util.*;

public class Programmers42626 {
    
}

class Solution {
    public int solution(int[] scoville, int k) {
        int answer = 0;
        
        int i;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        
        for(i=0; i<scoville.length; i++){
            queue.add((long)scoville[i]);
        }
        
        long a;
        long b;
        
        while(queue.size() > 1){
            a = queue.poll();
            b = queue.poll();
            
            if(a >= k && b >= k) {
                return answer;
            }
            
            a += b*2;

            queue.add(a);
            
            answer++;
        }
        
        //섞은 음식의 스코빌 지수 = 덜매움 + 매움*2
        //가장 낮은 두 개의 음식을 이렇게 만든다.
        // k 이상이 될 때까지 반복
        //
        
        if(queue.poll() < k) answer = -1;
        
        
        return answer;
    }
}