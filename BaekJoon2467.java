import java.io.*;
import java.util.*;

public class BaekJoon2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        //두 값을 더해서 가장 0에 가까운 값을 만들고 이 값을 만드는 두 용액을 오름차 출력
        //두개 이상의 경우엔 아무거나 출력

        //이것도 투포인터같은데 슬라이딩윈도우?
        //정렬 후 양 끝에서 투포인터 실행

        int p1 = 0;
        int p2 = n-1;

        Arrays.sort(arr);

        int minVal = 2000000001;
        
        int v1 = 0, v2 = n-1;

        while(p1 < p2){

            if(Math.abs(arr[p1] + arr[p2]) < minVal){
                v1 = p1;
                v2 = p2;
                minVal = Math.abs(arr[p1] + arr[p2]);
            }

            if(arr[p1] + arr[p2] == 0) break;

            else if(arr[p1] + arr[p2] < 0){
                p1++;
            }

            else p2--;
        }

        System.out.println(arr[v1] > arr[v2] ? arr[v2] + " "+ arr[v1] : arr[v1] + " "+ arr[v2]);
    }
}
