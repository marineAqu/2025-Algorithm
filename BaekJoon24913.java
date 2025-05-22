import java.io.*;
import java.util.*;

public class BaekJoon24913{
    public static void main(String args[]) throws IOException{

        //1 x p : x장이 p번 후보의 표
        //2 x y : 이 이후 x가 정후, y가 다른 후보로 집계될 시 당선될 "가능성"이 있는지

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); //n명의 후보
        int q = Integer.parseInt(st.nextToken()); //질문

        long vote[] = new long[n+2]; //1부터 인덱싱, 정후 포함하면 N+1명
        long sum = 0;
        long maxValue = 0;
        
        int a, b, c;
                //N+1이 아닌 것 중 최솟값을 저장하고 있어야한다

                //셋이나 맵으로 저장해두고.. 값 꺼내고 하는식으로 하기엔 중복 안 되는게 걸린다
                //매번 가장 작은 값을 찾아야함. 300000 * 100000 매번 검사하는 건 시간초과
                //

        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a == 1) {
                vote[c] += b;

                if(c != n+1) {
                    sum += b;
                    if(maxValue < vote[c]) {
                        maxValue = vote[c];
                    }
                }
            }

            else { //-1 하는 이유: 똑같이 8인 애가 하나라도 있으면 틀림
                if((vote[n+1] + b - 1)*n >= sum + c && maxValue < vote[n+1] + b) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}