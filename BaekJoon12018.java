import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon12018 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        //과목에 신청한 사람 수, 수강인원
        //각 사람마다 넣은 마일리지

        //각 과목마다 최소한 이만큼은 넣어야 한다는 값만 저장하면 되지않을까

        int allcount, limitNum;
        int minNeedMi[] = new int[n];
        Integer temp[];

        //과목당 최대 36마일리지만 소모할 수 있음에 유의
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            allcount = Integer.parseInt(st.nextToken());
            limitNum = Integer.parseInt(st.nextToken());

            temp = new Integer[allcount];

            st = new StringTokenizer(br.readLine());
            for(int t=0; t<allcount; t++){
                temp[t] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(temp, Collections.reverseOrder());

            //또 수강신청인원이 수강인원보다 현저히 작으면 마일리지 1만 소모하면된다
            if(limitNum > allcount) minNeedMi[i] = 1;
            else minNeedMi[i] = temp[limitNum-1]; //limitNum-1 < allcount여야 오류ㄴ
        }

        Arrays.sort(minNeedMi);
        int count = 0;
        
        for(int i=0; i<n; i++){
            if(m - minNeedMi[i] >= 0 && minNeedMi[i] <= 36){
                m -= minNeedMi[i];
                count++;
            }
        }

        System.out.print(count);

    }
}