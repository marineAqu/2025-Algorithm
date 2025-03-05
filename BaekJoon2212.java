import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 센서의 개수
        int k = Integer.parseInt(br.readLine()); // 집중국의 개수

        StringTokenizer st = new StringTokenizer(br.readLine());

        //집중국의 수신 가능 영역 길이의 합의 최솟값 구하기
        //음수 좌표도 모두 양수로 바꿔준다
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken()) + 1000000;
        }

        //좌표값 정렬
        Arrays.sort(arr);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i=1; i<n; i++){
            queue.add(arr[i] - arr[i-1]);
            if(queue.size() > k-1) queue.poll();
        }

        //k개의 집중국으로 최단거리를 구해야한다.
        //즉 arr[0] ~ arr[n-1]을 k개의 범위로 나누어야 한다.
        //그렇다면 중간에 값이 많이 띄어지는 곳을 빼는게 좋다.
        //띄어지는 곳을 큐에 넣으면 될 일 같은데
        //범위를 k로 나눈다면 중간에 띄어지는 곳은 k-1개

        long sum = 0;
        //반성할 점: queue.poll로 값이 자꾸 변하는데 for(int i=0; i<queue.size(); i++) 라고 작성하면 당연히 오류가나지요,,
        while (!queue.isEmpty()){
            sum += queue.poll();
        }

        long answer = arr[n-1] - arr[0] - sum;
        System.out.print(answer);
    }
}
