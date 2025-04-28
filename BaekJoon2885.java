import java.io.*;

public class BaekJoon2885 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int count = 0;
        long size = 1, sum = 0;

        while(size < k){
            size *= 2;
        }

        System.out.print(size+" ");

        if(size == k){
            System.out.print(0);
            return;
        }

        while(size > 1){
            count++;

            size /= 2;
            if(size + sum <= k){
                sum += size;
            }

            //쪼갠 조각이 두개까지 있는 거니까
            if(size + sum <= k){
                sum += size;
            }

            if(sum == k) break;
        }

        System.out.print(count);
        //여러조각 합쳐서 k개로 만들어도 된다
        //구매해야 하는 초콜릿 크기/ 최소 쪼개야 하는 횟수 출력

        //k=6이면
        //8 사서 4 4 만들고 4 2 2 만들어서 4 2 나 먹고 2 선영이주기. 그러면 2회쪼개고 작은 거 2
    }
}
