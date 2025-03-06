import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//이렇게 어렵게 풀지 말고 그냥 2중 for문 쓰면 된다...

public class BaekJoon6550 {
    static String s, t, isitTrue, line;
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while((line = br.readLine()) != null){
            st = new StringTokenizer(line);

            s = st.nextToken();
            t = st.nextToken();
            list.clear();
            isitTrue = "No";

            for(int i=0; i<t.length(); i++){
                if(t.charAt(i) == s.charAt(0)){
                    list.add(i);
                    break;
                }
            }

            while (!list.isEmpty()) {
                calMethod(list.poll());

                if(isitTrue.equals("Yes")) break;
            }

            System.out.println(isitTrue);
        }
    }

    static void calMethod(int a){
        int count = 0;

        for(int i=a; i<t.length(); i++){
            if(t.charAt(i) == s.charAt(count)){
                count++;
            }

            if(i != a && t.charAt(i) == s.charAt(0)){
                list.add(i);
            }

            if(count == s.length()) {
                isitTrue = "Yes";
                break;
            }
        }
    }
}
