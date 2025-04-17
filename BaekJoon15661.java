import java.io.*;
import java.util.*;

public class BaekJoon15661 {
    static int answer, sum, n, map[][], memberCount;
    static boolean member[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        member = new boolean[n];
        sum = 0;

        answer = Integer.MAX_VALUE;

        //차이를 최소로, 팀원 수 상관 X
        //n은 최대 20 최소 4
        //시간제한 2초, 브루트포스로하면 
        //조합 수: 2^20 = 1024*1024 = 1,000,000
        //한번계산할때 완탐이고 i+1부터니까 200연산임
        //그러면 200,000,000 2억인데........
        //계산할때 하나하나 다시 계산해야됨

        //조합이랑 계산은 합칠수가없다 나중에 4가 추가되면 1에서도 4를 추가해야됨

        //일단 배열에다가 ij랑 ji를 하나에 저장해두자 (i가 작은쪽 j를 큰쪽으로해서)

        //입력
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int r=0; r<i; r++){
                map[r][i] += Integer.parseInt(st.nextToken());
            }
            for(int r=i; r<n; r++){
                map[i][r] = Integer.parseInt(st.nextToken());
            }
        }

        //계산
        memberCount = 0;
        makeTeam(0);

        System.out.println(answer);
       
    }

    //팀 조합 만들기
    static void makeTeam(int i){
        if(i == n){
            if(memberCount != 0 && memberCount != n){
                cal();
            }
            
            return;
        }

        //나를 포함한 경우
        member[i] = true;
        memberCount++;
        makeTeam(i+1);

        //회복
        member[i] = false;
        memberCount--;

        //나를 포함하지 않은 경우
        makeTeam(i+1);
    }

    //계산하기
    static void cal(){
        int teamA = 0;
        int teamB = 0;

        for(int i=0; i<n; i++){
            if(!member[i]) {
                for(int r=i+1; r<n; r++){
                    if(!member[r]) teamB += map[i][r];
                }
            }

            else{
                for(int r=i+1; r<n; r++){
                    if(member[r]) teamA += map[i][r];
                }
            }
            
        }

        answer = Math.min(answer, Math.abs(teamB - teamA));
    }
}
