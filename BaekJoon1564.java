import java.io.*;

public class BaekJoon1564{
    public static void main(String[] args) throws IOException {
        //0이 아닌 뒤 5자리.
        //dfs로 하면서 0 있으면 나눠버리기?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long result = 2; // 2* 3 = 6, 6*4 = 24, 24*5 = 120
        long k = 1000000000000L;
        for(int i=3; i<=n; i++){
            if(i % 10 != 0) result *= i;
            else result *= (i/10);

            while(result % 10 == 0) result /= 10;

            result %= k;
        }

        //뒤에 0이 없어야한다는 말은 %10 했을 때 0이면 10으로 /해야한다.
        //앞에 0 붙여줘야한다.
        result %= 100000;
        if(result / 10000 >= 1) System.out.print(result);
        else if(result / 1000 >= 1) System.out.print("0"+result);
        else if(result / 100 >= 1) System.out.print("00"+result);
        else if(result / 10 >= 1) System.out.print("000"+result);
        else if(result / 1 >= 1) System.out.print("0000"+result);
    }
}