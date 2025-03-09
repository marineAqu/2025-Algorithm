import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.PriorityQueue;

class Numabs{
    int ori, absNum;

    Numabs(int ori){
        this.ori = ori;
        this.absNum = Math.abs(ori);
    }
}

public class BaekJoon11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int now;
        PriorityQueue<Numabs> pq = new PriorityQueue<>((o2, o1) -> {if(o2.absNum - o1.absNum == 0){return o2.ori - o1.ori;} return o2.absNum - o1.absNum;});

        for(int i=0; i<n; i++){
            now = Integer.parseInt(br.readLine());

            if(now == 0){
                if(pq.isEmpty()) sb.append("0").append("\n");
                else sb.append(pq.poll().ori).append("\n");
            }
            else {
                pq.add(new Numabs(now));
            }
        }

        System.out.println(sb);
    }
}
