import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon2141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        long midVal = 0;
        int answer = 0;

        int arr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            // 마을 위치가 음수도 있다
            arr[i][0] = Integer.parseInt(st.nextToken()); // 마을 위치
            arr[i][1] = Integer.parseInt(st.nextToken()); // 사는 사람 수

            midVal += arr[i][1];
        }

        //정렬
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        midVal = (midVal+1) / 2; //중간값 구하기

        for (int i = 0; i < n; i++) {
            sum += arr[i][1];

            if(sum >= midVal) {
                answer = arr[i][0];
                break;
            }
        }

        System.out.println(answer);
    }
}
