import java.util.*;

public class Programmers340199 {
    
}

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        //같은 각도, 한번 돌린 각도 이렇게 두번 비교해야함
        while(true){
            if(wallet[0] >= bill[0] && wallet[1] >= bill[1]) break;
            if(wallet[1] >= bill[0] && wallet[0] >= bill[1]) break;
            
            if(bill[0] > bill[1]) bill[0] /= 2;
            else bill[1] /= 2;
            
            answer++;
        }
        
        return answer;
    }
}
