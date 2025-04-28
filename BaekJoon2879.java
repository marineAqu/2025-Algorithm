import java.io.*;
import java.util.*;

class Info{
    int index, value;

    Info(int index, int value){
        this.index = index;
        this.value = value;
    }
}

public class BaekJoon2879 {
    public static void main(String[] args) throws IOException {
        //[0]이 [1]보다 큰 연속된 부분을 찾아야 하고
        //[1]이 [0]보다 큰 연속된 부분을 찾아 계산하는 식

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        int arr[][] = new int[n][3];

        //input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i][0] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = arr[i][1] - arr[i][0];
            queue.add(new Info(i, Math.abs(arr[i][2])));
        }

        //계산
        //가장 큰 값을 기준으로 그 근처 애들도 탭하는 김에 같이 탭하기
        Info now;
        while (!queue.isEmpty()) {
            now = queue.poll();
            if(arr[now.index][2] == 0) continue;


            answer += Math.abs(arr[now.index][2]); //일단 나는 정상으로 만든다

            //나보다 앞부분 체크
            for(int i=now.index+1; i<n; i++){
                if(arr[i][2] * arr[now.index][2] > 0){
                    arr[i][2] -= arr[now.index][2];
                }

                else break;
            }

            //나보다 뒷부분 체크
            for(int i=now.index-1; i>=0; i--){
                if(arr[i][2] * arr[now.index][2] > 0){
                    arr[i][2] -= arr[now.index][2];
                }

                else break;
            }

            arr[now.index][2] = 0;
        }

        System.out.print(answer);
    }

    //한번 전체로 빼고, 또 그 안에서 부분으로 뺄 수 있음
    //빗물 문제랑 비슷한 것 같기도하고
    //투포인터로 풀었는데

    //일단 arr[0][2]의 절댓값이 큰 지점을 잡고 
    //3 1 3 이라고하면
    //전체 1 빼고 양 옆의 2 2는 각각 따로 빼줘야함 즉 1+2+2 = 5
    
    //내 로직대로라면 정답은 3이 된다. 틀림
    //그러면 큐를 작은 순서대로 담고 걜 기준으로하면되나 

    //그런데 계산하면서 큐 안의 value가 업데이트되며 순서가 일치하지 않을 수도 있나
    //2 근처에 5가 있고 사이에 7 7 7 9 이런거 있고 또 다른 곳에 4가 있는데
    //1덕분에 3이 됐으면 얘를 먼저 해야는데 근데 그럼 다같이 빠진다 4도 2가 됨
    //아니다 이런 경우는 없겠다
}
