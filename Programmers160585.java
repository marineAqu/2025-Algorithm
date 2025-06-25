public class Programmers160585{
  
}

class Solution {
    public int solution(String[] board) {        
        
        //1. O가 하나 더 많거나 수가 같아야한다
        //2. 승리해서 종료했는데 진행중인 경우
        //-> 이미 종료된 시점인데 계속하는 경우
        
        int count[] = new int[2];
        boolean flagO = false;
        boolean flagX = false;
        
        // 세로, 직선, x자 검사하면 된다.
        
        for(int i=0; i<3; i++){
            for(int r=0; r<3; r++){
                if(board[i].charAt(r) == 'O') count[0]++;
                else if(board[i].charAt(r) == 'X') count[1]++;
            }
        }
        
        //검사
        for(int i=0; i<3; i++){
            //가로 검사
            if(board[i].charAt(0) == board[i].charAt(1) 
               && board[i].charAt(1) == board[i].charAt(2)) {
                if(board[i].charAt(0) == 'O') flagO = true;
                else if(board[i].charAt(0) == 'X') flagX = true;
            }
            //세로 검사
            if(board[0].charAt(i) == board[1].charAt(i)
               && board[1].charAt(i) == board[2].charAt(i)) {
                if(board[0].charAt(i) == 'O') flagO = true;
                else if(board[0].charAt(i) == 'X') flagX = true;
            }
            // \ 검사
            if(board[0].charAt(0) == board[1].charAt(1)
               && board[1].charAt(1) == board[2].charAt(2)) {
                if(board[0].charAt(0) == 'O') flagO = true;
                else if(board[0].charAt(0) == 'X') flagX = true;
            }
            // / 검사
            if(board[0].charAt(2) == board[1].charAt(1)
               && board[1].charAt(1) == board[2].charAt(0)) {
                if(board[0].charAt(2) == 'O') flagO = true;
                else if(board[0].charAt(2) == 'X') flagX = true;
            }
        }
        
        if(flagX && count[0] > count[1]) return 0;
        if(flagO && count[0] <= count[1]) return 0;
        if(flagO && flagX) return 0;
        if(count[0] < count[1] || count[0] > count[1] + 1) return 0;
        
        return 1;
    }
}
