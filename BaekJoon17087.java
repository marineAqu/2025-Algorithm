import java.util.Scanner;

public class BaekJoon17087 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        int arr[] = new int[n];

        int num;


        num = sc.nextInt();
        arr[0] = Math.abs(s - num);

        for(int i=1; i<n; i++){
            num = sc.nextInt();
            arr[i] = Math.abs(s - num);

            arr[i] = GCD(arr[i-1], arr[i]);
        }

        //최대공약수를 구하는 문제
        System.out.print(arr[n-1]);

    }

    static int GCD(int a, int b){
        if(b == 0) return a;
        else return GCD(b, a % b);
    }
}
