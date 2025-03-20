import java.util.*;
import java.io.*;

public class BaekJoon2504 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line = br.readLine();

    Stack<Integer> st = new Stack<>();
    int now, sum;

    // (는 -1, [는 -2
    for (int i = 0; i < line.length(); i++) {

      if (line.charAt(i) == ')') {

        sum = 0;

        while (true) {
          if (st.isEmpty()) {
            System.out.print(0);
            return;
          }

          now = st.pop();

          if (now == -1) {
            if (sum == 0)
              sum = 2;
            else
              sum *= 2;

            break;
          }

          if (now == -2) {
            System.out.print(0);
            return;
          }

          else {
            sum += now;
          }
        }

        st.push(sum);
      }

      else if (line.charAt(i) == ']') {
        sum = 0;
        
        while (true) {
          if (st.isEmpty()) {
            System.out.print(0);
            return;
          }
          
          now = st.pop();

          if (now == -2) {
            if (sum == 0)
              sum = 3;
            else
              sum *= 3;

            break;
          }

          if (now == -1) {
            System.out.print(0);
            return;
          }

          else {
            sum += now;
          }
        }

        st.push(sum);
      }

      else if (line.charAt(i) == '(')
        st.push(-1);

      else if (line.charAt(i) == '[')
        st.push(-2);
    }

    // 잘못된 괄호를 판별하는 기준을 생각해보자

    // 1. 갯수가 맞지 않는 경우
    // 2. ()()([)] 같은 경우. 서로 겹쳐있는 경우. 즉 안의 x가 잘못된 괄호열인 경우

    // 스택으로 해야겠는데 닫는 거 나오면 바로 전에 같은 모양의 여는 게 존재해야함. 그렇지않으면 0출력하고 return
    // 단 스택으로 할 때 곱하기를 계산해야한다

    // 닫는 거 나오면 값 계산하고 스택에 넣고
    // 근데 닫는 거 나왔는데 스택에서 꺼낸 게 연 게 아니라 다른 숫자라면 곱하면된다

    // 괄호의 아스키코드값이랑 계산값이랑 겹치는 거 대비해서 괄호는 -1, -2같은 걸로 넣자

    sum = 0;

    while (!st.isEmpty()) {
      now = st.pop();
      
      if(now < 0){
        System.out.print(0);
        return;
      }
      sum += now;
    }

    System.out.print(sum);
  }
}