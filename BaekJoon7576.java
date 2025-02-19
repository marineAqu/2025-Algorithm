import java.util.*;

class node{
    int x, y;

    node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BaekJoon7576 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[m][n];

        Queue<node> queue = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int t=0; t<n; t++) {
                arr[i][t] = sc.nextInt();
                if(arr[i][t] == 1) queue.add(new node(t, i));
            }
        }

        int days = 0;

        node now;

        while (!queue.isEmpty()) {
            now = queue.poll();

            if(now.x + 1 < n && arr[now.y][now.x + 1] == 0){
                arr[now.y][now.x + 1] = arr[now.y][now.x] + 1;
                queue.add(new node(now.x+1, now.y));
            }

            if(now.y + 1 < m && arr[now.y + 1][now.x] == 0){
                arr[now.y + 1][now.x] = arr[now.y][now.x] + 1;
                queue.add(new node(now.x, now.y+1));
            }

            if(now.x - 1 >= 0 && arr[now.y][now.x - 1] == 0){
                arr[now.y][now.x - 1] = arr[now.y][now.x] + 1;
                queue.add(new node(now.x-1, now.y));
            }

            if(now.y - 1 >= 0 && arr[now.y - 1][now.x] == 0){
                arr[now.y - 1][now.x] = arr[now.y][now.x] + 1;
                queue.add(new node(now.x, now.y-1));
            }
        }

        for(int i=0; i<m; i++){
            for(int t=0; t<n; t++) {
                if(arr[i][t] == 0){
                    System.out.println(- 1);
                    return;
                }
                if(arr[i][t] > days) days = arr[i][t];
            }
        }

        System.out.println(days - 1);
    }
}
