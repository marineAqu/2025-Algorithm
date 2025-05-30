import java.util.*;
import java.lang.*;
import java.io.*;

class BackJoon10828 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int num;
        String s;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            s = st.nextToken();
            
            if(s.equals("push")){
                num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }

            if(s.equals("pop")){
                if(stack.size() == 0) System.out.println("-1");
                else System.out.println(stack.pop());
            }

            if(s.equals("size")){
                System.out.println(stack.size());
            }

            if(s.equals("empty")){
                if(stack.size() == 0) System.out.println("1");
                else System.out.println("0");
            }

            if(s.equals("top")){
                if(stack.size() == 0) System.out.println("-1");
                else System.out.println(stack.peek());
            }
        }
    }
}
