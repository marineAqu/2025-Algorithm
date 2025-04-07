import java.io.*;
import java.util.*;

public class BaekJoon1202 {
    static int boss[];

    static int find(int now){
        if(boss[now] == -1) return -1;
        if(boss[now] == now) return now;
        return boss[now] = find(boss[now]);
    }

    public static void main(String[] args) throws IOException {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] gems = new int[n][2];

        //보석
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            gems[i][0] = Integer.parseInt(st.nextToken()); //무게
            gems[i][1] = Integer.parseInt(st.nextToken()); //가격
        }

        //가격 내림차순
        Arrays.sort(gems, (o1, o2) -> o2[1] - o1[1]);

        //가방 유니온파인드
        boss = new int[k];
        for(int i=0; i<k; i++) boss[i] = i;
        
        int[] bag = new int[k];
        for(int i=0; i<k; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        //오름차 정렬
        Arrays.sort(bag);
        
        for(int i=k-1; i>=0; i--){
            treeMap.put(bag[i], i);
        }

        //가방에는 최대 한 개의 보석만을 넣을 수 있다.
        //그냥 가격 내림차 정렬 후 내 크기의 가방이 있는지 확인, 없으면 좀 큰 것 찾아가며 넣기.
        //사용했다면 나보다 큰 가장 작은 가방을 향해야 한다.

        //트리셋 쓸까 인덱스 향하는 용도로
        //유니온파인드로 이 가방이 사용불가인 경우 다음 가방으로 바로 향하도록 하기

        int dp[] = new int[k];
        

        //이중포문으로 계속 나보다 큰 가방 찾으면 300000*300000이라 시간초과남
        
        int temp;
        long answer = 0;

        for(int i=0; i<n; i++){
            try{
                temp = treeMap.ceilingEntry(gems[i][0]).getValue();
                if(find(temp) == -1) continue;
                else {
                    dp[find(temp)] = gems[i][1];
                    answer += gems[i][1];
                    if(find(temp) < k-1) boss[find(temp)] = find(find(temp)+1);
                    else boss[find(temp)] = -1;
                }
            }catch(Exception e){
                continue; //날 담을 수 있는 가방이 없는경우
            }
        }

        System.out.println(answer);
    }
}
