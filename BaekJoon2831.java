import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon2831 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int now, answer = 0;
        int n = Integer.parseInt(br.readLine());
        

        int male[][] = new int[1001][2]; //[0]은 작은 쪽과 춤을, [1]은 큰 쪽과 춤을
        int female[][] = new int[1001][2];

        //정보 저장
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            now = Integer.parseInt(st.nextToken());
            if(now < 0) male[(-1 * now) - 1500][0]++;
            else male[now - 1500][1]++;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            now = Integer.parseInt(st.nextToken());
            if(now < 0) female[(-1 * now) - 1500][0]++;
            else female[now - 1500][1]++;
        }

        //계산
        for(int i=1; i<1001; i++) {
            //남자와 남자보다 키 작은 여자 매칭
            if(male[i][0] > 0){
                if(female[i-1][1] > 0){
                    if(male[i][0] >= female[i-1][1]){
                        answer += female[i-1][1];
                        male[i][0] -= female[i-1][1];
                        female[i-1][1] = 0;
                    }

                    else{
                        answer += male[i][0];
                        female[i-1][1] -= male[i][0];
                        male[i][0] = 0;
                    }
                }
            }

            //여자와 여자보다 키 작은 남자 매칭
            if(female[i][0] > 0){
                if(male[i-1][1] > 0){
                    if(female[i][0] >= male[i-1][1]){
                        answer += male[i-1][1];
                        female[i][0] -= male[i-1][1];
                        male[i-1][1] = 0;
                    }

                    else{
                        answer += female[i][0];
                        male[i-1][1] -= female[i][0];
                        female[i][0] = 0;
                    }
                }
            }

            //한칸씩 앞으로 (for문 안 돌리게)
            male[i][0] += male[i-1][0];
            male[i][1] += male[i-1][1];
            female[i][0] += female[i-1][0];
            female[i][1] += female[i-1][1];
        }

        System.out.print(answer);
    }
}
