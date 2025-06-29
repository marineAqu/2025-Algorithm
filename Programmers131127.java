import java.util.*;

public class Programmers131127 {

}

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int got[] = new int[number.length];
        int whereis[] = new int[discount.length];
        Arrays.fill(whereis, -1);
        
        
        //1일차 - 할인내역 저장
        for(int i=0; i<10; i++){
            for(int r=0; r<number.length; r++){
                if(want[r].equals(discount[i])){
                    got[r]++;
                    whereis[i] = r;
                }
            }
        }
        
        boolean flag = true;
        for(int i=0; i<got.length; i++){
            if(got[i] < number[i]){
                flag = false;
                break;
            }
        }
        if(flag) answer++;
        int lastdate;
        
        //2일차~
        for(int i=1; i<discount.length; i++){
            //전날 것 지우기
            if(whereis[i-1] != -1){
                got[whereis[i-1]]--;
            }
            
            //다음날 채우기
            lastdate = (i+9 < discount.length) ? i+9 : -1;
            if(lastdate != -1){
                for(int r=0; r<number.length; r++){
                    if(want[r].equals(discount[lastdate])){
                        got[r]++;
                        whereis[lastdate] = r;
                    }
                }
            }
            
            //check
            flag = true;
            for(int t=0; t<got.length; t++){
                if(got[t] < number[t]){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        
        
        return answer;
    }
}
