import java.io.*;
import java.util.*;

public class BaekJoon12904 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        int p1 = 0;
        int p2 = t.length() - 1;
        
        int r = t.length() - s.length();
        boolean isReverse = false;

        //1. 문자열 뒤에 A를 추가하기
        //2. 문자열을 뒤집고 B를 추가하기

        //차라리 t에서 s를 만들어보자
        //A면 그냥 지우면 되므로 p2--
        //B면 뒤집고 나서 앞에서 지운다 p1++
        
        //1. 일단 s가 t에 포함되어 있어야한다.
        //2. t에 s가 여러개 포함되어 있을 수 있다.

        // B -> ABBA

        for(int i=0; i<r; i++){
            if(isReverse == true){
                if(t.charAt(p1) == 'A'){
                    p1++;
                }
    
                else{ //B
                    isReverse = false;
                    p1++;
                }
            }

            else{
                if(t.charAt(p2) == 'A'){
                    p2--;
                }
    
                else{ //B
                    isReverse = true;
                    p2--;
                }
            }
        }


        //마지막 비교 연산
        if(isReverse == false){
            int count = 0;
            for(int i=p1; i<=p2; i++){
                if(t.charAt(i) != s.charAt(count)) {
                    System.out.print(0);
                    return;
                }
                else count++;
            }

            System.out.print(1);
        }

        else{
            int count = 0;
            for(int i=p2; i>=p1; i--){
                if(t.charAt(i) != s.charAt(count)) {
                    System.out.print(0);
                    return;
                }
                else count++;
            }

            System.out.print(1);
        }


        //BA

        //B
        //BA
        //ABB
        //ABBA

        //A는 뒤에서 지우면 된다
        //B는 뒤집고 나서 앞에서 지운다

        //두 연산의 순서를 바꿀 수 없

    }
}
