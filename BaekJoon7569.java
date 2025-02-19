import java.util.*;

class node2{
    int h, x, y;

    node2(int h, int x, int y){
        this.h = h;
        this.x = x;
        this.y = y;
    }
}

public class BaekJoon7569 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int h = sc.nextInt();
        
        int arr[][][] = new int[h][m][n];

        Queue<node2> queue = new LinkedList<>();

        for(int r=0; r<h; r++){
            for(int i=0; i<m; i++){
                for(int t=0; t<n; t++) {
                    arr[r][i][t] = sc.nextInt();
                    if(arr[r][i][t] == 1) queue.add(new node2(r, t, i));
                }
            }
        }

        int days = 0;

        node2 now;

        while (!queue.isEmpty()) {
            now = queue.poll();

            if(now.x + 1 < n && arr[now.h][now.y][now.x + 1] == 0){
                arr[now.h][now.y][now.x + 1] = arr[now.h][now.y][now.x] + 1;
                queue.add(new node2(now.h, now.x+1, now.y));
            }

            if(now.y + 1 < m && arr[now.h][now.y + 1][now.x] == 0){
                arr[now.h][now.y + 1][now.x] = arr[now.h][now.y][now.x] + 1;
                queue.add(new node2(now.h, now.x, now.y+1));
            }

            if(now.x - 1 >= 0 && arr[now.h][now.y][now.x - 1] == 0){
                arr[now.h][now.y][now.x - 1] = arr[now.h][now.y][now.x] + 1;
                queue.add(new node2(now.h, now.x-1, now.y));
            }

            if(now.y - 1 >= 0 && arr[now.h][now.y - 1][now.x] == 0){
                arr[now.h][now.y - 1][now.x] = arr[now.h][now.y][now.x] + 1;
                queue.add(new node2(now.h, now.x, now.y-1));
            }

            if(now.h - 1 >= 0 && arr[now.h-1][now.y][now.x] == 0){
                arr[now.h-1][now.y][now.x] = arr[now.h][now.y][now.x] + 1;
                queue.add(new node2(now.h-1, now.x, now.y));
            }

            if(now.h + 1 < h && arr[now.h+1][now.y][now.x] == 0){
                arr[now.h+1][now.y][now.x] = arr[now.h][now.y][now.x] + 1;
                queue.add(new node2(now.h+1, now.x, now.y));
            }
        }

        for(int r=0; r<h; r++){
            for(int i=0; i<m; i++){
                for(int t=0; t<n; t++) {
                    if(arr[r][i][t] == 0){
                        System.out.println(- 1);
                        return;
                    }
                    if(arr[r][i][t] > days) days = arr[r][i][t];
                }
            }
        }

        System.out.println(days - 1);
    }
}
