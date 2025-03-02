import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

//24line과 같이 비교하는 부분에서 이미 오버플로우가 발생해 비교문 자체에서 오류가 발생한다.
//즉 b의 범위는 int 안이 맞으나 이로 인해 long으로 해야 한다.

public class BaekJoon16953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        long b = sc.nextInt();

        PriorityQueue<Long> list = new PriorityQueue<>();
        HashMap<Long, Integer> hashMap =new HashMap<>();
        list.add(a);

        hashMap.put(a, 0);

        long now;
        while (!list.isEmpty()) {
            now = list.poll();

            if(now * 2 <= b){
                if(!hashMap.containsKey(now * 2)){
                    hashMap.put(now * 2, hashMap.get(now) + 1);
                    list.add(now * 2);
                }
                else if(hashMap.get(now * 2) > hashMap.get(now) + 1){
                    hashMap.put(now * 2, hashMap.get(now) + 1);
                    list.add(now * 2);
                }
            }

            if(now * 10 + 1 <= b){
                if(!hashMap.containsKey(now * 10 + 1)) {
                    hashMap.put(now * 10 + 1, hashMap.get(now) + 1);
                    list.add(now * 10 + 1);
                }
                
                else if (hashMap.get(now * 10 + 1) > hashMap.get(now) + 1) {
                    hashMap.put(now * 10 + 1, hashMap.get(now) + 1);
                    list.add(now * 10 + 1);
                }
            }
        }
        
        if(hashMap.get(b) == null){
            System.out.print(-1);
            return;
        }
        System.out.print(hashMap.get(b) + 1);
    }
}
