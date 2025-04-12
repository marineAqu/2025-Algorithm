import java.util.*;
import java.lang.*;
import java.io.*;

class BaekJoon10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        
        int num;
        String commend;
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            
            commend = st.nextToken();

            if(commend.equals("push_front")){
                num = Integer.parseInt(st.nextToken());

                deque.push(num);
            }

            if(commend.equals("push_back")){
                num = Integer.parseInt(st.nextToken());

                deque.addLast(num);
            }

            if(commend.equals("pop_front")){
                if(deque.size() != 0) System.out.println(deque.pop());
                else System.out.println(-1);
            }

            if(commend.equals("pop_back")){
                if(deque.size() != 0) System.out.println(deque.removeLast());
                else System.out.println(-1);
            }

            if(commend.equals("size")){
                System.out.println(deque.size());
            }

            if(commend.equals("empty")){
                if(deque.size() == 0) System.out.println(1);
                else System.out.println(0);
            }

            if(commend.equals("front")){
                if(deque.size() == 0) System.out.println(-1);
                else System.out.println(deque.getFirst());
            }

            if(commend.equals("back")){
                if(deque.size() == 0) System.out.println(-1);
                else System.out.println(deque.getLast());
            }
        }
    }
}
