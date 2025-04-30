import java.io.*;
import java.util.*;

public class BaekJoon1132 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1~50
        long alp[][] = new long[26][3];
        boolean ableZero[] = new boolean[26];

        Arrays.fill(ableZero, true);
        String line;
        long sum = 0;

        //0으로 시작하는 수는 없음에 유의.
        //적어도 한 알파벳은 수의 가장 처음에 주어지지 않는다
        for(int i=0; i<n; i++){
            line = br.readLine();
            
            ableZero[(int)(line.charAt(0) - 'A')] = false;
            //ACAA 4개 100 1이고 2
            
            //길이는 4, r=3이었다면 한자릿수임
            for(int r=0; r<line.length(); r++){
                alp[(int)(line.charAt(r) - 'A')][1] += Math.pow(10, line.length() - r - 1);
            }
        }

        for(int i=0; i<26; i++) alp[i][0] = i;

        Arrays.sort(alp, (o1, o2) -> Long.compare(o2[1], o1[1]));

        //9 8 7 ... 하고 0까지 배정 완료하기
        int num = 9;
        for(int i=0; i<26; i++){
            if(alp[i][1] == 0) {
                break;
            }

            alp[i][2] = num--;

            if(num == -1) num = i;
        }

        //able 체크해서 false라면 계속해서 한칸씩 swap 하기
        if(alp[num][2] == 0){
            for(int i=num; i>0; i--){
                if(!ableZero[(int)alp[i][0]]) {
                    alp[i][2] = alp[i-1][2];
                    alp[i-1][2] = 0;
                }
                else break;
            }
        }

        //이제 계산
        for(int i=0; i<26; i++){
            if(alp[i][1] == 0) break;
            sum += alp[i][1] * (long)alp[i][2];
        }

        System.out.print(sum);
    }
}
