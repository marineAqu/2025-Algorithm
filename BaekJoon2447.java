import java.util.Scanner;

public class BaekJoon2447 {
    static StringBuilder sb = new StringBuilder();
    static int n, count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i=0; i<n; i++){
            for(int t=0; t<n; t++){
                sb.append("*");
            }
            sb.append("\n");
        }
        
        int n2 = n;
        while (n2 != 1) {
            n2 /= 3;
            count++;
        }

        func(1);

        System.out.print(sb);
    }

    //*로 채워진 곳에 빈칸을 만든다는 느낌으로
    //depth가 1이면 size를 3으로 잡고 중간 부분에 빈칸
    static void func(int depth){
        int sizex = 0;
        int sizey = 0;
        if(depth == count + 1) return;

        for(int i=0; i<n; i++){
            if(i < sizey + (Math.pow(3, depth) / 3)) continue;

            if(i >= sizey + ((Math.pow(3, depth) / 3) * 2)) {
                sizey += Math.pow(3, depth);
                continue;
            }

            for(int t=0; t<n; t++){
                if(t < sizex + (Math.pow(3, depth) / 3)) continue;
                
                if(t >= sizex + ((Math.pow(3, depth) / 3) * 2)) {
                    sizex += Math.pow(3, depth);
                    continue;
                }

                sb.setCharAt(i * (n+1) + t, ' ');
                
            }
            
            sizex = 0;
        }

        func(depth + 1);
    }
}
