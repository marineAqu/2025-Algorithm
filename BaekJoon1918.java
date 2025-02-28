import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//반례: G*(A-B*(C/D+E)/F)
//정답: GABCD/E+*F/-*

//반례: ((A+B)*C)/D
//정답: AB+C*D/

//반례: A+(B)*(C-D)+(E)
//정답: ABCD-*+E+

// 연산자를 스택에 넣으려고 할 때 나보다 우선순위가 높거나 같은 게 있다면 이 때 빼주고 나를 넣어야 한다
// (반례 1에서 두번째 괄호 전후의 *, / 같은 경우)

public class BaekJoon1918 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            // 연산자들
            if(line.charAt(i) == '*' || line.charAt(i) == '/'){
                while(!stack.empty() && (stack.lastElement() == '/' || stack.lastElement() == '*')){
                    sb.append(stack.pop());
                }

                stack.push(line.charAt(i));
            }

            else if(line.charAt(i) == '+' || line.charAt(i) == '-'){
                while(!stack.empty() && stack.lastElement() != '('){
                    sb.append(stack.pop());
                }

                stack.push(line.charAt(i));
            }

            //닫는 괄호
            else if(line.charAt(i)  == ')'){ // 안에 연산자가 하나만 있지 않을 수도 있음
                while(stack.lastElement() != '('){
                    sb.append(stack.pop());
                }

                stack.pop(); // 여는 괄호 닫기
            }

            //여는 괄호
            else if(line.charAt(i)  == '('){
                stack.push(line.charAt(i));
            }
            
            //알파벳
            else{
                sb.append(line.charAt(i));

                if(stack.empty()) continue;

                //바로 전 연산자가 * 거나 / 라면 출력한다
                if(stack.lastElement() == '*' || stack.lastElement() == '/'){
                    sb.append(stack.pop());
                    //while(!stack.empty() && stack.lastElement() != '(') sb.append(stack.pop());
                }
            }
        }

        //종료 후 남아있는 스택 출력
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        
        System.out.println(sb.toString());
    }
}