import java.io.*;
import java.util.*;

class Point2{
    int index, gap;

    Point2(int index, int gap){
        this.index = index;
        this.gap = gap;
    }
}

public class BaekJoon13164 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Point2> queue = new PriorityQueue<>((o1, o2) -> {if(o2.gap == o1.gap) return o1.index - o2.index; else return o2.gap - o1.gap;});
        
        //k개의 조로 나눌 것이고, 각 조에서 가장 큰 키와 작은 키의 차가 최소가 되어야 한다.

        //너무 동떨어진 값은 본인 혼자 하는게 좋음

        st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        int gap[] = new int[k-1];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken()); //오름차로 입력됨
        }

        for(int i=1; i<n; i++){
            queue.add(new Point2(i, arr[i] - arr[i-1]));
        }

        for(int i=0; i<k-1; i++){
            gap[i] = queue.poll().index - 1;

            //갭이 큰 순서대로
        }

        Arrays.sort(gap);

        int a = 0;
        long sum = 0;

        for(int i=0; i<k-1; i++){
            sum += arr[gap[i]] - arr[a];

            a = gap[i] + 1;
        }

        sum += arr[n-1] - arr[a];

        System.out.println(sum);

        //그러니까 어디서 끊느냐가 중요. k-1번만큼 끊을 수 있고,
        //끊는 순간은 gap이 가장 큰 순간이어야한다.
        //만약 gap이 같은 경우라면 각 팀별 인원차가 적게끔 해야한다.

        //근데 gap 차이가 많이 안나는구간을 너무 많이 하나로 묶으면 결국 처음과 마지막의 차이가 커지기 때문에 좋지않음
        //gap을 누적합해가며 구해야하지않을까
    }
}
