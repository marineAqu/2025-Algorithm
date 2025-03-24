import java.io.*;
import java.util.*;

public class BaekJoon2002 {
    public static void main(String[] args) throws IOException{
        
        //들어온 순서대로 나가야한다. 만약 중간에 있더라도 삭제하긴 해야함
        //큐??? 2000번 수행, 2000*1000회 연산 정도 (index 조회 연산에)
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> list = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        String now;
        int index;
        int answer = 0;

        for(int i=0; i<n*2; i++){
            now = br.readLine();

            //존재하지 않는 경우
            if((index = list.indexOf(now)) == -1){
                list.add(now);
            }
            //존재하는데 추월한 경우
            else if(index != 0){
                list.remove(index);
                answer++;
            }
            //추월하지 않고 정상적으로 나온 경우
            else{
                list.remove(0);
                continue;
            }
        }

        System.out.println(answer);
    }
}
