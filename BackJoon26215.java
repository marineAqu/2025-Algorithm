import java.util.*;
import java.lang.*;
import java.io.*;

class BackJoon26215 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        //int arr[] = new int[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(int i=0; i<n; i++) queue.add(Integer.parseInt(st.nextToken()));
        //arr[i] = Integer.parseInt(st.nextToken());

        //Arrays.sort(arr); //오름차 정렬

        //크기순 정렬해서 큰거랑 2번째로 큰거를 가장 먼저 빼는게 나음.
        //두번째로 큰 값이 세번째로 큰 값보다 작아질 때까지 빼고 
        
        int count = 0;

        int a, b;
        while (queue.size() > 1 && count <= 1440) {
            a = queue.poll();
            b = queue.poll();

            if(a-1 != 0) queue.add(a-1);
            if(b-1 != 0) queue.add(b-1);

            count++;
        }

        if(queue.size() == 1){
            count += queue.poll();
        }

        if(count > 1440) System.out.print(-1);
        else System.out.print(count);
    }
}
