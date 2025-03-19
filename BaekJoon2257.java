import java.util.*;
import java.io.*;

public class BaekJoon2257 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Stack<Integer> stack = new Stack<>();

        int a, sum;

        //계산하기
        for(int i=0; i<line.length(); i++) {
            if(line.charAt(i) == '('){
                stack.push((int)'(');
            }

            //닫는 괄호인 경우
            else if(line.charAt(i) == ')'){
                sum = 0;
                
                while((a = stack.pop()) != (int)'('){
                    sum += a;
                }

                stack.push(sum);
            }

            else if(line.charAt(i) == 'O') stack.push(16);
            else if(line.charAt(i) == 'C') stack.push(12);
            else if(line.charAt(i) == 'H') stack.push(1);

            //곱하는 수일 경우
            else{
                a = stack.pop();
                stack.push(((int)line.charAt(i) - (int)'0') * a); //곱해서 넣어둔다. 곱하는 수 앞은 늘 다 계산되어 있음
            }
        }

        sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
