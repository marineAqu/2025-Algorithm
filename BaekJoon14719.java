import java.io.*;
import java.util.*;

class Point{
    int index, h;

    Point(int index, int h){
        this.h = h;
        this.index = index;
    }
}

public class BaekJoon14719 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        LinkedList<Point> list = new LinkedList<>();

        int arr[] = new int[w];
        boolean visited[] = new boolean[w];
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        
        //exception
        if(w == 1){
            System.out.print(0);
            return;
        }

        for(int i=0; i<w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            
            list.add(new Point(i, arr[i]));
        }

        //높이순 정렬
        Collections.sort(list, (o1, o2) -> {if(o2.h == o1.h) return o1.index - o2.index; else return o2.h - o1.h;});

        Point a, b;
        int line;
        a = list.poll();

        while (!list.isEmpty()) {
            //어차피 낮은 쪽이 영향력이 있으므로 가장 높은 쪽은 그대로 두고 하한선만 조정
            b = list.poll();

            line = Math.min(a.h, b.h); //가장 낮은 위치
            visited[b.index] = true;

            //높은 두 곳 중 가장 낮은 위치와 차이나는 깊이를 계산해서 더한다
            for(int i=Math.min(a.index, b.index)+1; i<=Math.max(a.index, b.index)-1; i++){
                if(visited[i] == false) sum += line - arr[i];
                visited[i] = true;
            }
        }
        
        System.out.print(sum);
    }
}
