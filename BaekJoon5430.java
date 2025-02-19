import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//R은 뒤집기, D는 버리기
//배열이 비어있는데 D를 사용한 경우에는 에러 발생


public class BaekJoon5430 {
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        String line;
        int size;
        String arr;
        Deque<String> num = new LinkedList<>();
        boolean isFirst;

        for(int i=0; i<t; i++){
            sb = new StringBuilder();
            num.clear();
            isFirst = true;
            
            line = br.readLine();
            size = Integer.parseInt(br.readLine());
            arr = br.readLine();
            st = new StringTokenizer(arr.substring(1, arr.length()-1), ",");

            //숫자 넣기
            while(st.hasMoreTokens()){
                num.add(st.nextToken());
            }

            for(int r=0; r<line.length(); r++){

                //R: 뒤집는 경우
                if(line.charAt(r) == 'R'){
                    if(isFirst) isFirst = false;
                    else isFirst = true;
                }


                //D: 지우는 경우
                else{
                    if(size == 0){
                        sb.append("error");
                        break;
                    }

                    if(isFirst == true) num.pollFirst();
                    else {
                        num.pollLast();
                    }

                    size--;
                }
            }

            //종료
            if(sb.length() != 0) System.out.println(sb);
            
            else{
                if(size == 0) {
                    System.out.println("[]");
                    continue;
                }

                if(isFirst){
                    sb.append("[");
                    for(int r=0; r<size-1; r++){
                        sb.append(num.pollFirst()).append(",");
                    }
                    System.out.println(sb.append(num.pollFirst()).append("]"));
                }

                else{
                    sb.append("[");
                    for(int r=0; r<size-1; r++){
                        sb.append(num.pollLast()).append(",");
                    }
                    System.out.println(sb.append(num.pollLast()).append("]"));
                }

            }
        }
    }
}
