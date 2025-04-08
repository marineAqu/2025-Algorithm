import java.io.*;
import java.util.*;

public class BaekJoon9996 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //빈칸을 포함해 *를 문자열로 바꿨을 때 일치해야한다.
        //해서 일치하는지 검사

        int n = Integer.parseInt(br.readLine());
        String patt = br.readLine();
        int front = 0, end = 0; // * 이전 길이, 이후 길이

        for(int i=0; i<patt.length(); i++){
            if(patt.charAt(i) == '*'){
                front = i;
                end = patt.length() - (i + 1);
                break;
            }
        }

        String compa;
        boolean flag;
        for(int i=0; i<n; i++){
            compa = br.readLine();
            flag = false;

            //애초에 길이 부족인 경우
            if(compa.length() < front + end){
                System.out.println("NE");
                continue;
            }

            //앞단 검사
            for(int r=0; r<front; r++){
                if(patt.charAt(r) != compa.charAt(r)){
                    System.out.println("NE");
                    flag = true;
                    break;
                }
            }

            if(flag == true){
                continue;
            }

            //뒷단 검사
            for(int r=0; r<end; r++){
                if(patt.charAt(patt.length() - 1 - r) != compa.charAt(compa.length() - 1 - r)){
                    System.out.println("NE");
                    flag = true;
                    break;
                }
            }

            if(flag == true){
                continue;
            }

            //여기까지 걸리지 않았다면
            System.out.println("DA");
        }
    }
}
