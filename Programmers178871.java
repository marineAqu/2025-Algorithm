import java.util.*;

public class Programmers178871 {
    
}



class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();

        //1등부터 순서대로 담기

        //추월했을 때 추월한 선수 이름을 부른다.
        //둘만 바꿔주면 되는 문제같음
        //선수 수 50,000, 교체 수 1,000,000 -> 1000000 * 50000 = 
        //해당 String을 찾는 데 시간이 많이 걸리는 듯
        
        for(int r=0; r<players.length; r++){
            map.put(players[r], r);
        }

        String temp;
        int findIndex;
        for(int i=0; i<callings.length; i++){
            //사전 업데이트
            findIndex = map.get(callings[i]);
            map.put(callings[i], findIndex-1);
            map.put(players[findIndex-1], findIndex);
            
            //교체
            temp = players[findIndex-1];
            players[findIndex-1] = players[findIndex];
            players[findIndex] = temp;
            
        }

        return players;
    }
}