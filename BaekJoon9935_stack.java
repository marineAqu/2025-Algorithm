import java.util.*;
import java.io.*;

public class BaekJoon9935_stack {
  
    //도움받은 반례: (aaaabbbb / ab)
    //  - 스택에서 하나 꺼내 그 자리로 돌아가고 continue해버리면 스택에서 꺼낸 걸 다시 또 넣는 문제 발생
    //시간초과 문제 -> sb.delete(i-blength + 1, i+1);에서 시간초과 발생. 스택으로 연산하는 게 낫다.
    
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder sb = new StringBuilder();
      
      String ori = br.readLine();
      String boomline = br.readLine(); //폭발 문자열
      
      int orilength = ori.length();
      int blength = boomline.length();

      Stack<Character> answer = new Stack<>();
      //Stack<Character> temp = new Stack<>();
      
      int r;

      //값을 넣으면서 동시에 검사 시작
      for(int i=0; i<orilength; i++){
        answer.push(ori.charAt(i));

        //검사
        if(answer.size() >= blength){

          //폭발문자열인지 확인
          for(r=0; r < blength; r++) {
            if(answer.get(answer.size() - blength + r) != boomline.charAt(r)) {
              break;
            }
          }

          if(r == blength){
            for(r=0; r < blength; r++) {
              answer.pop();
            }
          }
        }
      }

      //출력
      while (!answer.isEmpty()) {
        sb.insert(0, answer.pop());
      }

      System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}