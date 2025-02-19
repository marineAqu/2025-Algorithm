import java.util.*;
import java.lang.Math;

//주의사항
// 1. 지름길은 일반 도로보다 더 효율이 별로인 경우도 있다
// 2. 되돌아갈 수 없기 때문에 도착지점 너머에 도착하는 지름길은 아예 버려야 한다.

public class BaekJoon1446 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        //하나씩 다음으로 읽어가며 최종 거리 계산
        
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[][] fastLoad = new int[n][3];
        //int[] dp = new int[n+1]; //dp에 저장하는 건 *해당 지름길이 끝난 위치*에서 주행한 거리
        int[] dp = new int[d+1]; //dp의 크기를 가야 하는 거리만큼으로 수정
        for(int i=0; i<d+1; i++) dp[i] = Integer.MAX_VALUE; //최댓값으로 수정

        //지름길 정보 저장
        for(int i=0; i<n; i++){
            fastLoad[i][0] = sc.nextInt();
            fastLoad[i][1] = sc.nextInt();
            fastLoad[i][2] = sc.nextInt();

            //넘치면 되돌아갈 수가 없기 때문에 갈 지점보다 더 많이 가는 지름길은 아예 지워야 한다
            //일반 도로보다 더 별로인 지름길도 지워야 한다
            if(fastLoad[i][1] > d || fastLoad[i][2] > fastLoad[i][1] - fastLoad[i][0]) {
                fastLoad[i][0] = 0;
                fastLoad[i][1] = 0;
                fastLoad[i][2] = 0;
            }
        }

        //지름길 정렬
        Arrays.sort(fastLoad, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2){
            if(o1[0] == o2[0]) {
                if(o2[1] == o2[1]) return o1[2] - o2[2];
                return o2[1] - o2[1];
            }
            return o1[0] - o2[0];
           } 
        });

        int loadCount = 0;

        //DP 계산
        //1번째 지름길
        dp[0] = 0;
        while(true){
            if(loadCount < n && fastLoad[loadCount][0] == 0){
                
                //채택하는 경우 (끝나는 지점의 거리가 본인이 가지고 있는 거리보다 작은 경우)
                if(dp[fastLoad[loadCount][1]] > 0 + fastLoad[loadCount][2]){
                    dp[fastLoad[loadCount][1]] = 0 + fastLoad[loadCount][2];

                    //그 사이 km는 지름길을 거치지 못하는 경우이므로
                    for(int r=1; r<fastLoad[loadCount][1]; r++){
                        dp[r] = Math.min(dp[r-1] + 1, dp[r]);
                    }
                }
                
                
                loadCount++;
            }

            //2. 0으로 시작하는 지름길 없으면 정지
            else {
                break;
            }
        }

        //1. 시작 지점이 같은 지름길은 늦게 끝나는 게 먼저 온다
        //2. 생각해야 할 것: 지름길이 겹치는 경우 (이전 지름길이 지금 지름길보다 늦게 끝나는 경우)
        for(int i=1; i<d+1; i++){

            dp[i] = Math.min(dp[i-1] + 1, dp[i]);


            //1. 지름길이 존재하면
            
            if(loadCount < n && fastLoad[loadCount][0] == i){
                
                //채택하는 경우 (끝나는 지점의 거리가 본인이 가지고 있는 거리보다 작은 경우)
                if(dp[fastLoad[loadCount][1]] > dp[i] + fastLoad[loadCount][2]){
                    dp[fastLoad[loadCount][1]] = dp[i] + fastLoad[loadCount][2];

                    //그 사이 km는 지름길을 거치지 못하는 경우이므로
                    for(int r=i+1; r<fastLoad[loadCount][1]; r++){
                        dp[r] = Math.min(dp[r-1] + 1, dp[r]);
                    }
                }
                
                
                loadCount++;
                i--; //시작 지점이 같은 지름길이 있는 것을 대비해서 다시 돌아간다
            }

            //2. 지름길 없으면 그냥 다음으로 넘어간다
        }

        System.out.println(dp[d]);
    }
}
