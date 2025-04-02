import java.util.*;
import java.io.*;

public class BaekJoon10775 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();

        //1~i번째 게이트 중 하나에 영구적으로 도킹시킬 수 있다.
        //끝번호(자기자신)에 도킹하는 편이 좋다

        //자기자신부터 -- 해가며 비어있는 게이트에 넣는다.
        //넣지 못한 채 끝나면 종료

        //다만 최대 10^5이기때문에 하나하나 포문 돌려가며 검사할 수 없음.
        //트리셋같은걸 써야하나

        for(int i=1; i<=g; i++) set.add(i);
        
        int now;
        int result;
        for(int i=0; i<p; i++) {
            now = Integer.parseInt(br.readLine());

            try{
                result = set.floor(now);
                set.remove(result);
            }catch(Exception e){
                System.out.println(i);
                return;
            }
        }

        System.out.println(p);
    }
}
