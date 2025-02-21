import java.util.Scanner;

public class BaekJoon1463 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int DP[] = new int[n+1];

        for(int i=2; i<=n; i++) DP[i] = Integer.MAX_VALUE;

        DP[1] = 0;
        if (n >= 2) DP[2] = 1;
        if (n >= 3) DP[3] = 1;

        //3으로 나누거나, 2로 나누거나, 1을 뺀다.
        //틀렸다: 나중에 꼭 다시 풀어보자.

        // DP문제. DP문제는 점화식을 찾는 게 중요하다.
        // DP[3] = DP[1] + 1, DP[9] = DP[3] + 1 같은 식으로 DP에 저장해두어야 한다.
        
        for(int i=2; i<n; i++){
            if(DP[i]+1 < DP[i+1]) DP[i+1] = DP[i] + 1;
            if(i*2 <= n && DP[i]+1 < DP[i*2]) DP[i*2] = DP[i] + 1;
            if(i*3 <= n && DP[i]+1 < DP[i*3]) DP[i*3] = DP[i] + 1;
        }
        
        /*
        while(true){
            if(n == 1) break;

            //이제 연산 세 개 중에 골라야 한다. 
            
            //n이 2로 나누어지며 3으로 나누어질 경우: 어느 쪽으로 나누는 것이 더 작은 값을 만드는지 확인
            //2로만 나누어질 경우: 4로 나누는 것, n-1/3 중 뭐가 더 작은 값인지 확인
            //
            if(n % 3 == 1) n--;
            else if(n % 3 == 0) n /= 3;
            else if(n % 2 == 1) n--;
            else if(n % 2 == 0) n /= 2;
            else n--;
            

            count++;
        }*/

        System.out.print(DP[n]);
        //10
        //10 -> 5 -> 4 -> 2 -> 1

        //10 -> 9 -> 3 -> 1

        //12
        //12 -> 4 -> 3 -> 1 
        //12 -> 6 -> 2 -> 1
    }
}
