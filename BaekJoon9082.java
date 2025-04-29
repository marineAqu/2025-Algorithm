import java.io.*;
import java.util.*;

public class BaekJoon9082 {
    static int n, info[], map[], count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        info = new int[100];
        map = new int[100];
        String line;
        
        for(int i=0; i<testCase; i++){
            //input
            n = Integer.parseInt(br.readLine());
            count = n;
            line = br.readLine();

            for(int r=0; r<n; r++) info[r] = (int)(line.charAt(r) - '0');
            
            line = br.readLine();
            //입력
            for(int r=0; r<n; r++) {
                if(line.charAt(r) == '*'){
                    map[r] = 1;

                    delete(r);
                }

                else map[r] = 0;
            }

            //지뢰를 넣을 수 있는지 검사
            for(int r=0; r<n; r++) {
                if(map[r] != 1){
                    find(r);
                }
            }

            System.out.println(count);
        }
    }

    //11111

    static void find(int i){
        if(i-1 >= 0 && info[i-1] == 0) {
            count--;
            return;
        }
        if(info[i] == 0) {
            count--;
            return;
        }
        if(i+1 < n && info[i+1] == 0) {
            count--;
            return;
        }

        map[i] = 1;
        delete(i);
    }

    static void delete(int i){
        if(i-1 >= 0) info[i-1]--;
        info[i]--;
        if(i+1 < n) info[i+1]--;
    }
}