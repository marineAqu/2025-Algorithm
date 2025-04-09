import java.util.*;
import java.io.*;

public class BaekJoon13019 {
    public static void main(String[] args) throws IOException {
        int alpa[] = new int[26];
        //한문자를 가장 앞으로 옮길 수 있다.
        //불가능하면 -1 (글자수가 안 맞거나)

        //뒤에서부터 검사해야겠다. 일치하면 그냥 두고 불일치하면 가장 앞으로 뺀다
        //교체된 다음 또 일치하는지 검사해야함

        //2번을 가장 먼저 앞으로 빼고 3번을 그다음 앞으로 빼는 게 
        //3 후 2를 앞으로 뺀 것보다 더 최솟값일 수도 있을까??

        //일단 앞으로 빼고 앞으로뺀것끼리는 위치를 조절할 수 있다는 걸 생각하자
        // 앞으로 뺀 순서에따라 (index 2를 먼저 앞으로 빼고 index3을 그다음으로 앞으로 빼는 등)
        //즉 갯수가 똑같은지 검사하고, 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        if(a.length() != b.length()){
            System.out.println(-1);
            return;
        }

        int count = a.length() - 1;
        int moveCount = 0;


        //길이 50이니까 두번씩 검사해도 시간초과나지는 않음

        for(int i=a.length() - 1; i>=0; i--){
            if(a.charAt(i) == b.charAt(count)) {
                count--;
            }

            else {
                moveCount++;
                alpa[a.charAt(i) - 'A']++;
            }
        }

        for(int i=0; i<moveCount; i++){
            if(alpa[b.charAt(i) - 'A'] > 0) alpa[b.charAt(i) - 'A']--;
            else {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(moveCount);
    }
}
