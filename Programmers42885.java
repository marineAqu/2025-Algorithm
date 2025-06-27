public class Programmers42885 {
    
}


class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int pep[] = new int[241];
        //적은 구명보트로 모두 구출
        
        for(int i=0; i<people.length; i++){
            pep[people[i]]++;
        }
        
        int reverse;
        for(int i=1; i<241; i++){
            //딱 맞으면 하고 아니면 근접한 걸로 -> 포인터??
            while(pep[i] != 0){
                pep[i]--;
                reverse = limit - i;
                
                for(int r=reverse; r>=0; r--){
                    if(r == 0){
                        reverse = r;
                        
                        answer++;
                        break;
                    }
                    
                    if(pep[r] != 0){
                        reverse = r;
                        answer++;
                        
                        pep[r]--;
                        
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}
