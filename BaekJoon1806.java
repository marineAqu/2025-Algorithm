import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1806 {
    public static void main(String[] args) throws IOException{
        //연속된 수의 부분합 중에 S보다 큰 것 중 가장 작은 것.
        //N은 100,000개 이하

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        int minVal = 1000001;

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0, p2 = 0;
        
        int sum = arr[0];

        //투포인터 코드 : 최대 100000 + 100000 이므로 시간초과 발생하지 않는다
        while (true) {
            if(p1 > p2) p2++;
            
            if(p1 == n) break;
            

            if(sum < s){
                if(p2 != n-1) sum += arr[++p2];
                else {
                    p1++;
                }
            }

            else if(sum >= s){
                minVal = Math.min(p2 - p1 + 1, minVal);
                sum -= arr[p1++];
            }
        }
        

        /*
        //시간초과
        //1+2*1+3*2 +... + 100000*99999 -> 기존 최악의 경우 코드
        arr[0] = Integer.parseInt(st.nextToken());

        for(int i=1; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];

            if(arr[i] < s) continue;

            for(int r = i-1; r>=0; r--){
                if(i-r > minVal) break;

                if(arr[i] - arr[r] > s && i - r < minVal) {
                    minVal = i-r;
                    break;
                }
            }
        }
        */
        System.out.println(minVal == 1000001? 0 : minVal);

    }
}
