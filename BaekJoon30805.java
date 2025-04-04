import java.util.*;
import java.io.*;

public class BaekJoon30805 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> a[] = new LinkedList[101];
        for(int i=0; i<=100; i++) a[i] = new LinkedList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) a[Integer.parseInt(st.nextToken())].add(i);

        LinkedList<Integer> b[] = new LinkedList[101];
        for(int i=0; i<=100; i++) b[i] = new LinkedList<>();

        int m = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) { //숫자에다 인덱스를 저장
            b[Integer.parseInt(st.nextToken())].add(i);
        }

        int ina = -1, inb = -1;
        int tempa, tempb;

        for(int i=100; i>0; i--){
            if(a[i].size() == 0 || b[i].size() == 0) continue;

            tempa = -1;
            tempb = -1;

            //a, b 모두에 존재할 경우 가장 먼저 큐에 넣은 숫자의 index보다 뒤에 존재해야함
            for(int r : a[i]) {
                if(r > ina){
                    tempa = r;
                    break;
                }
            }

            for(int r : b[i]) {
                if(r > inb){
                    tempb = r;
                    break;
                }
            }

            if(tempa != -1 && tempb != -1){
                ina = tempa;
                inb = tempb;

                queue.add(i);
                i++; //해당 숫자가 여러개 있을 수 있으니 한번 더 검사
            }
        }

        //출력
        System.out.println(queue.size());

        while (!queue.isEmpty()) {
            System.out.print(queue.poll()+" ");
        }

        //a, b에 공통으로 들어있는 것들을 모두 넣는다.

        //a: 1 3 1
        //b: 1 1 3
        //-> 부분수열: 1 3 혹은 1 1 둘 다 될 수 있다
        //즉 모든 공통된 부분을 가져온 s를 가져다가 s의 부분수열로 구하면 안됨

        //B에 저장된 숫자들로 Map을 만들어서 (인덱스, 숫자) 저장해두기
        //A입장에서 0부터 n까지 돌면서 b에 존재하면 부분수열로 하기

        // 1. 일단 공통적으로 존재하는 것 중 가장 큰 수를 구해야한다.
        // 2. 길이를 늘림과 동시에 두번째 숫자의 크기도 커야한다.

        //1보다 2가 앞서서는 안된다. 길이보다 숫자의 크기가 선행된다

        //뒤에서부터 검사하며 스택에 쭉 넣고, 가장 큰 숫자가 있는 부분까지 다 빼기??
        // -> 뒤에 있는 것들도 길이보다 숫자의 크기도 중요하기때문에 이건 안될듯

        //1. 가장 큰 값을 찾아 첫번째로 넣기
        //2. 그 값 뒤에 있는 값들 중 가장 큰 값을 넣는다. 이 과정을 무한반복

        //전체탐색하면 10000 (2중 for문)

    }
}
