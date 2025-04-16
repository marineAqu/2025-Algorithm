import java.io.*;
import java.util.*;

public class BaekJoon21315 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        int check = -1;
        int k1 = 0;
        int k2 = 0;
        

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            //magic[i] = i+1;
            if(arr[i] == n) k2 = i;
        }

        check = n - arr[0];
        while (check != 1) {
            check/=2;
            k1++;
        }

        //그러면 k1을 진짜로 실행한 다음에 k1결과의 상위 = 최종결과 하위 일치하는 거 확인하면 k2도 알 수 있다
        //근데 매직 연산을 1000번 반복한다면 시간초과날 것 같은데

        check = k2;
        k2 = 0;
        while (check != 1) {
            check/=2;
            k2++;
        }
        
        System.out.println(k1 + " " + k2);

        //가장 위로 올라가는게 마술수행 전 가장 아래에 있는 것.
        //입력(결과)에서 가장 위에있는 걸 보고 가장 첫번째 k의 결과에서 가장 아래에 있었던 걸 알 수 있음
        //=그러면 첫번째 k는 알 수 있겠다(몇뭉텅이를 위에올렸는지 알수있음)
        //그런데 동시에 결과값의 제일 위에 있는 게 k2 마술 시작 전 가장 아래에 있던 것임.

        //k1결과에서 가장 위에있는것만 알 수 있을것이다 (=k와 무관하게 n)
        //걔가 입력결과값 어디에 위치해있는지를 알면 k2를 구할 수 있다!!!!!!!
        
        
        //단 첫번째 k보다 두번째 k가 더 큰 경우가 있을 수 있다는 거
        //k가 실행되면 정말로 우연히 순차적으로 존재할 경우가 없을까?
        //-> 없음. 왜냐하면 섞는 범위가 1~4 -> 2~4 같은 식이 되기 때문에
 

    }
}
