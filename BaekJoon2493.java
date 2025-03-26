import java.util.*;
import java.io.*;

class Info{
    int hight, index;

    Info(int hight, int index){
        this.hight = hight;
        this.index = index;
    }
}

public class BaekJoon2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Info> stack = new Stack<>();
        int answer[] = new int[n];
        int now;
        Info num;


        for(int i=0; i<n; i++) {
            now = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if((num = stack.pop()).hight >= now) {
                    answer[i] = num.index + 1;
                    stack.push(num);
                    break;
                }
            }

            stack.push(new Info(now, i));
        }

        for(int i=0; i<n; i++) System.out.print(answer[i]+" ");
    }
}
