import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon15927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        boolean allSame = true;

        // 3이면 0 만
        for (int i = 1; i < line.length(); i++) {
            if(line.charAt(i) != line.charAt(0)){
                allSame = false;
                break;
            }
        }

        if(allSame){
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < line.length() / 2; i++) {
            //전문 자체가 펠린드롬이 아닌 경우
            if (line.charAt(i) != line.charAt(line.length() - 1 - i)) {
                System.out.println(line.length());
                return;
            }
        }

        //펠린드롬은 맞는 경우

        System.out.println(line.length() - 1);
    }
}
