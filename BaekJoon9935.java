import java.util.*;
import java.io.*;

public class BaekJoon9935 {
  
    //도움받은 반례: (aaaabbbb / ab)
    //  - 스택에서 하나 꺼내 그 자리로 돌아가고 continue해버리면 스택에서 꺼낸 걸 다시 또 넣는 문제 발생
    //시간초과 문제 -> sb.delete(i-blength + 1, i+1);에서 시간초과 발생. 스택으로 연산하는 게 낫다.
    
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      String ori = br.readLine();
      String boomline = br.readLine(); //폭발 문자열
      
      int length = ori.length();
      int blength = boomline.length();
      int c = 0;
      
      int i=0;
      Stack<Integer> stack = new Stack<>();
      LinkedList<Character> list = new LinkedList<>();
      for(int r=0; r<length; r++) list.add(ori.charAt(r));

      //1. 처음부터 끝까지 검사를 돌리며 boomline의 첫글자가 들어있는 위치를 스택에 저장해둔다. (터트리면 pop 1회)
      //2. 검사 도중 폭발문자열과 일치함을 발견하면 터트린다.
      //2-1. 터트리고 스택에서 하나를 꺼내 일치하는지 다시 검사한다.
      //2-1-1. 스택에서 꺼낸 게 일치하지 않으면 다시 넣는다.
      //2-2. 스택이 비어있으면 내 다음부터 다시 c=0으로 검사한다.
      //3. 일치하지 않으면 c=0으로 초기화하고 나 자신부터 쭉 검사를 계속한다.
      
      //검사 시작
      while(i < length) {
        //일단 첫글자 보이면 저장
        if (list.get(i) == boomline.charAt(0)){
          stack.push(i);
        }
        
        
        //이어지는지 검사
        if(list.get(i) == boomline.charAt(c)){
          c++;
        }

        //이어지지 않음
        else {
            if(list.get(i) == boomline.charAt(0)) c = 1;
            else c = 0;
            // 일치하지 않는 동시에 다시 첫글자부터 검사해야 한다
        }
        
        //폭발문자열과 완전 일치하는 경우
        if(c == blength) {
            stack.pop(); //스택에 최근에 넣은 한개는 없앤다 (폭발)

            //폭발된 것 지우기
            for(int r = 0; r < blength; r++){
              list.remove(i - blength + 1); //여기서도 해당 위치찾느라 시간 많이걸릴것같은데
            }
            
            length -= blength;
            c = 0;
            
            if(!stack.isEmpty()) {
              i = stack.lastElement() + 1;
              c = 1;
            }
            else i = i - blength + 1;
            
            continue;
        }
        
        i++;
      }
      
      if(list.size() > 0) {
        for(int r=0; r<length; r++){
          bw.append(list.poll());
        }
      }
      else bw.write("FRULA");
      
      bw.flush();
      bw.close();
  }
}