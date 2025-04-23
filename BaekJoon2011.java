import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2011 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pw = br.readLine();

        //알파벳은 1부터 26까지. 즉 1개 단위로 묶거나 2개 단위로 묶을 수 있다.
        //5글자라면
        //11111, 2111 이런식으로 1과 2만을 이용해서 n을 만드는 조합의 수를 계산하는 문제
        //단 2로 묶었을 때 26보다 크다면 그건 2로 만들 수 없다.
        int dp[] = new int[pw.length()+1];
        //dp[i]는 i번째 글자까지 1, 2만으로 만들 수 있는 순열의 수. 

        //암호가 잘못되어 해석할 수 없는 경우는 0 출력
        //7777같은경우?? 도 해석 되는데 00000같은경우를 말하는듯.. 
        // 틀린 이유: 0이 들어갈 순 있는데 앞에 1이나 2가 존재해야함
        //              0이면 단독으로 취급해줄 수 없다

        dp[0] = 1;
        dp[1] = 1;
        if(pw.charAt(0) == '0') { //암호가 잘못된 경우
            System.out.println("0");
            return;
        }

        for(int i=2; i<=pw.length(); i++){
            if(pw.charAt(i-1) == '0') {
                if(pw.charAt(i-2) == '1' || pw.charAt(i-2) == '2') {
                    //이경우 +1이 불가능
                    dp[i] += dp[i-2];
                    continue;
                }
                else break; //잘못된 코드
            }

            dp[i] = dp[i-1]; //끝자리를 +1하는 경우와 끝자리를 +2하는 경우
            dp[i] %= 1000000;
            if(pw.charAt(i-2) == '1') dp[i] += dp[i-2];
            else if(pw.charAt(i-2) == '2' && pw.charAt(i-1) < '7') dp[i] += dp[i-2];
            dp[i] %= 1000000;
            //System.out.println("dp["+i+"]: "+dp[i]);
        }

        System.out.println(dp[pw.length()]);
    }
}
