import java.io.*;
import java.util.*;

public class BaekJoon1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        int score[] = new int[100001];
        int top;

        //누구 한명에게라도 뭐 하나라도 더 나으면 됨.
        // -> 나보다 낮은 점수를 가진 사람이 a에서건 b에서건 한 명만 있으면 됨

        int n, count;
        for(int i=0; i<testCase; i++) {
            n = Integer.parseInt(br.readLine());
            count = 1;

            //입력과 동시에 정렬됨
            for(int r=0; r<n; r++){
                st = new StringTokenizer(br.readLine());
                score[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            //100000 에서 각 
            //검사
            top = score[1];
            for(int r=2; r<=n; r++) {
                if(top > score[r]) {
                    top = score[r];
                }
                
                else{
                    //나보다 높은 순위가 한명이라도 있어서는 안된다
                    continue;
                }

                count++;
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
