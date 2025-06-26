import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon1091{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p[] = new int[n]; // 카드가 어떤 플레이어에게 가야하는지
        int s[] = new int[n]; // 한 번 섞었을 때
        int card[] = new int[n];
        int before[] = new int[n];

        for(int i=0; i<n; i++) p[i] = Integer.parseInt(st.nextToken()); 

        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++) {
            s[i] = Integer.parseInt(st.nextToken()); 
            
            card[i] = i;
            before[i] = i;
        }

        for(int i=0; i<n; i++){
            //바뀌지 않는 카드에 대해서 검사
            if(s[i] == i && (s[i]%3) != p[i]) {
                System.out.println(-1);
                return;
            }
        }

        boolean isOK = true;

        //즉슨 셔플한 카드를 3으로 나눴을 때 나머지가 p와 같아야 한다.
        //TODO: 셔플을 언제 멈추고 -1을 반환할지
        //1. 일단 제자리 그대로인 카드가 있는지 확인하기 -> 있는데 걔가 그자리가 아니면 -1 반환
        //2. 셔플하기

        //셔플
        while(count < 1_000_000){
            isOK = true;

            //검사
            for(int i=0; i<n; i++) {
                if(card[i] % 3 != p[i]){
                    isOK = false;
                    break;
                }
            }

            //정답 찾은 경우 
            if(isOK) {
                System.out.println(count);
                return;
            }

            //셔플 수행
            for(int i=0; i<n; i++) card[i] = before[s[i]];
            for(int i=0; i<n; i++) before[i] = card[i];
            
            count++;
        }

        System.out.println(-1);
    }
}
