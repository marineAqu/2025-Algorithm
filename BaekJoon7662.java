import java.io.*;
import java.util.*;

public class BaekJoon7662 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        int calCount;
        char cal;
        long num;
        TreeSet<Long> set = new TreeSet<>((o1, o2) -> {if(o1 == o2) return 1; else if(o1 > o2) return 1; else return -1;});

        for(int i=0; i<testCase; i++){
            set.clear();

            calCount = Integer.parseInt(br.readLine());

            for(int r=0; r<calCount; r++){
                st = new StringTokenizer(br.readLine());

                cal = st.nextToken().charAt(0);
                num = Integer.parseInt(st.nextToken());

                //삽입 연산
                if(cal == 'I'){
                    set.add(num);
                }

                //1은 최댓값 삭제, -1은 최솟값 삭제
                else{
                    if(set.size() == 0) continue; 

                    if(num == 1){
                        set.pollLast();
                    }

                    else{
                        set.pollFirst();
                    }
                }
            }

            //출력
            if(set.size() == 0) System.out.print("EMPTY");
            else{
                System.out.print(set.last() + " " + set.first());
            }

            System.out.println();
        }
    }
}
