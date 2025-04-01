import java.io.*;
import java.util.*;

public class BaekJoon5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String s = br.readLine();

        //1. s에서 남은 길이를 체크하기
        //1000000 가 m 최대 길이

        //그냥 m에서 IOI의 개수를 세고, 위치 저장해두기. 그리고 연달아 n회라면 count++

        //I라면 그자리에서 IOI여부를 체크. 다음자리가 I라면 리셋하고 다시 
        //O라면 다음자리가 I인지 검사
        LinkedList<Integer> list = new LinkedList<>();

        int count = 0;
        
        for(int i=0; i<m; i++){
            if(count == 0){
                if(s.charAt(i) == 'I') count++;
                else continue;
            }

            else if(count == 1){
                if(s.charAt(i) == 'O') count++;
                else {
                    continue; //이 자리를 시작으로 다시 검사
                }
            }

            else{ //count == 3인 경우
                if(s.charAt(i) == 'I'){
                    list.add(i-2);
                    count = 1;
                }
                else{
                    count = 0;
                }
            }
        }

        //한번 이어지는 걸 체크하면 그 이어진 부분은 더이상 검사 필요 X
        
        int finalCount = 0;
        count = 0;
        int before = -10;

        for(int now : list){
            if(before == now - 2){
                count++;  //연결된 수
            }

            else{ //끊어진 경우
                if(count >= n){
                    finalCount += (count + 1 - n);
                }

                count = 1;
            }

            before = now;
        }

        //마지막 계산
        if(count >= n){
            finalCount += (count + 1 - n);
        }

        System.out.println(finalCount);

    }
}
