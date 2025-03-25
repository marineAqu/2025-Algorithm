import java.util.*;
import java.io.*;

public class BeakJoon2143 {
    static int n, m;
    static long arr1[], arr2[], temp;
    static HashMap<Long, Long> map1 = new HashMap<>();
    static HashMap<Long, Long> map2 = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        arr1 = new long[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr1[0] = 0;
        for(int i=1; i<n+1; i++){
            arr1[i] = Integer.parseInt(st.nextToken()) + arr1[i-1];
        }

        m = Integer.parseInt(br.readLine());

        arr2 = new long[m+1];
        
        st = new StringTokenizer(br.readLine());
        arr2[0] = 0; 
        
        for(int i=1; i<m+1; i++){
            arr2[i] = Integer.parseInt(st.nextToken()) + arr2[i-1];
        }


        //Set 만들기
        for(int i=1; i<=n; i++){
            putMap1(i);
        }

        for(int i=1; i<=m; i++){
            putMap2(i);
        }

        long answer = 0;

        for(long now : map1.keySet()){
            if(map2.containsKey(t - now)){
                answer += map1.get(now) * map2.get(t - now);
            }
        }

        System.out.println(answer);

        // 이제 누적합을 가지고 합이 T가 되는 arr1+arr2를 찾아야 한다.
        // n, m의 크기는 최대 각각 1000
        // 그냥 HashSet에다가 모든 경우의 누적합을 다 넣어버리고 하나씩 꺼내서 조합해버릴까

        //배열에다가 각각 2000000, 2000000 크기를 할당해버리면 초과날 것 같으니 HashSet 쓰자
        //근데 같은값이중복될수있으니까 HashSet이아니라 HashMap으로 만들어야겠다(값, 개수) 형태
    }

    static void putMap1(int length){
        for(int r = length; r <= n; r++){
            if(map1.containsKey(arr1[r] - arr1[r - length])){
                temp = map1.get(arr1[r] - arr1[r - length]);

                map1.put(arr1[r] - arr1[r - length], temp+1);
            }

            else map1.put(arr1[r] - arr1[r - length], 1L);
        }
    }

    static void putMap2(int length){
        for(int r=length; r <= m; r++){
            if(map2.containsKey(arr2[r] - arr2[r - length])){
                temp = map2.get(arr2[r] - arr2[r - length]);

                map2.put(arr2[r] - arr2[r - length], temp+1);
            }
            else map2.put(arr2[r] - arr2[r - length], 1L);
        }
    }
}