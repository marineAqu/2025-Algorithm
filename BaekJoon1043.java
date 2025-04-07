import java.io.*;
import java.util.*;

public class BaekJoon1043 {
    static int boss[];

    static int find(int now){
        if(boss[now] == now) return now;
        else return boss[now] = find(boss[now]);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //사람 수
        int m = Integer.parseInt(st.nextToken()); //파티 수

        int partyBoss[] = new int[m];

        int count;
        int mem;
        int answer = 0;

        //진실을 아는 사람 수
        boss = new int[n+1];
        for(int i=1; i<=n; i++) boss[i] = i;
        
        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken()); //아는 사람 수
        //진실을 아는 사람 체크
        for(int r=0; r<know; r++) boss[Integer.parseInt(st.nextToken())] = 0;

        //파티 멤버 입력
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            //오는 사람의 수
            count = Integer.parseInt(st.nextToken());

            //오는 멤버 (첫번째 멤버는 각 파티의 대표로)
            partyBoss[i] = Integer.parseInt(st.nextToken());

            for(int r=1; r<count; r++) {
                mem = Integer.parseInt(st.nextToken());

                if(find(mem) == 0) boss[find(partyBoss[i])] = 0;
                boss[find(mem)] = find(partyBoss[i]);
            }
        }

        //검사하기
        for(int i=0; i<m; i++){
            if(find(partyBoss[i]) != 0) answer++;
        }

        System.out.print(answer);
        //유니온파인드 아닌가??
        //근데 모든 경우를 생각해야하기때문에 복구할 수 있어야한다.

        //일단 아는 사람이 있는 파티에는 말을 할 수가 없음.
        //아는 사람이 없는 파티 중 가장 많은 파티에서 말을 해야함. 단 사람이 겹쳐선 안된다
    }
}
