import java.util.*;

public class BaekJoon11047 {
    //실버4/그리디
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coins = new int[n];
        int answer = 0;

        //오름차순으로 주어짐
        for(int i=0; i<n; i++){
            coins[i] = sc.nextInt();
        }

        //계산
        for(int i=n-1; i>-1; i--){
            if(k / coins[i] > 0){
                answer += k / coins[i];
                k = k % coins[i];
            }
        }
        
        System.out.println(answer);
    }
}
