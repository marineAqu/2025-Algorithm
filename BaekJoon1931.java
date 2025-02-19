import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//할 수 있는 최대한의 회의 수

public class BaekJoon1931 {
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        long arr[][] = new long[n][2];
        long endTime = 0;
        int count = 0;

        //입력
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        //일단 시작 시간순으로 정렬 -> 같으면 일찍 끝나는 순으로
        //시작이 늦은데 더 빨리 끝나는 경우에는 그걸로 바꿔

        //오름차 정렬
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]) return Long.compare(o1[1], o2[1]);
            return Long.compare(o1[0], o2[0]);
        });

        //계산
        for(int i=0; i<n; i++){
            //현재 끝나는 회의보다 일찍 끝나는 회의라면 이걸로 교체한다
            if(arr[i][1] < endTime){
                endTime = arr[i][1];
                continue; //틀렸던 부분. 교체한 건데 이다음 if문에서 또 나를 실행해서는 안된다
            }

            //실행할 수 있는 회의일 경우
            if(arr[i][0] >= endTime){
                endTime = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
