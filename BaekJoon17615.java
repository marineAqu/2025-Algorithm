import java.io.*;

public class BaekJoon17615 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        String line = br.readLine();
        int answerB = 0;
        int answerR = 0;
        int answer;

        boolean startCount = false;

        for(int i=n-1; i>=0; i--){
            if(!startCount && line.charAt(i) != line.charAt(n-1)) startCount = true;
            
            if(!startCount) continue;

            if(line.charAt(i) == 'B') answerB++;
            else answerR++;
        }

        answer = Math.min(answerR, answerB);

        startCount = false;
        answerB = 0;
        answerR = 0;

        for(int i=0; i<n; i++){
            if(!startCount && line.charAt(i) != line.charAt(0)) startCount = true;
            
            if(!startCount) continue;

            if(line.charAt(i) == 'B') answerB++;
            else answerR++;
        }

        //1초에 n은 500,000
        //두번 탐색해도 시간초과 안 날 것 같은데
        //BBBBBR

        System.out.println(Math.min(answer, Math.min(answerB, answerR)));
    }
}
