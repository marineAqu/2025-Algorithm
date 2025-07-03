import java.util.*;

class Programmers42578{


}

class Solution {
    static int answer = 0;
    static HashMap<String, Integer> map = new HashMap<>();
    static LinkedList<String> list = new LinkedList<>();
    static int category[];
    
    public int solution(String[][] clothes){
        //1개만 입은 경우의 수, 2개 입은 경우의 수, ... clothes.length개 입은 경우의 수
        
        //input
        for(int i=0; i<clothes.length; i++){
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
            
            else{
                map.put(clothes[i][1], 1);
                list.add(clothes[i][1]);
            }
        }
        
        category = new int[list.size()];
        
        //계산
        for(int i=0; i<list.size(); i++){
            category[i] = map.get(list.get(i));
        }
        
        backtracking(0, category);
    
        
        return answer - 1;
    }
    
    public void backtracking(int depth, int[] category){
        if(depth == category.length) {
            answer++;
            return;
        }
        
        //아무것도 선택하지 않는 선택지까지 포함
        for(int i=0; i<=category[depth]; i++){
            //자신 추가하고 넘기기
            backtracking(depth+1, category);
        }
    }
}
