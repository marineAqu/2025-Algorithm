import java.util.*;

public class Programmers64061 {
    
}


class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;


        //빈칸을 집으면 아무일도 일어나지 않음 (스택에도 아무 값이 들어가선 안된다)
        //0은 빈칸
        Stack<Integer> stack = new Stack<>();

        int[] top = new int[board[0].length];
        for(int i=0; i<board[0].length; i++) top[i] = board[0].length;

        //가장 위의 위치 저장 (꽉차있으면 0, 비어있으면 n)
        for(int i=0; i<board[0].length; i++){
            for(int r=0; r<board[0].length; r++){
                if(top[i] == board[0].length && board[r][i] != 0) {
                    top[i] = r;
                }
            }
        }
        
        
        int nowTop;
        int before;
        int now;

        for(int i=0; i<moves.length; i++){
            //크레인이 닿을 위치 찾기
            nowTop = top[moves[i]-1];

            //빈 칸이라면 continue
            if(nowTop == board[0].length) continue;
            
            now = board[nowTop][moves[i]-1];  //하나 꺼내기
            top[moves[i]-1]++;                //업데이트
            
            if(!stack.isEmpty()) {
                before = stack.pop();

                if(now == before){
                    answer += 2;
                    continue;
                }
                else {
                    stack.push(before);
                    stack.push(now);
                }
            }

            else{
                stack.push(now);
            }
        }

        return answer;
    }
}