import java.io.*;
import java.util.*;

public class BaekJoon29197 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        //일직선은 따로 계산하고 나머지는 사분면에 넣어서 계산

        StringTokenizer st;
        HashSet<Double> set1 = new HashSet<>(); //1사분면
        HashSet<Double> set2 = new HashSet<>(); //2사분면
        HashSet<Double> set3 = new HashSet<>();
        HashSet<Double> set4 = new HashSet<>();

        boolean x0plus = false, x0minus = false, y0plus = false, y0minus = false;
        double x, y;
        double cal;

        //겹치는 기울기가 존재하는지. 딱 떨어지지 않는 경우에는 어떻게 하면 좋을까
        int count = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());

            if(x == 0){
                if(y > 0){
                    if(x0plus != true) {
                        x0plus = true;
                        count++;
                    }
                }
                else {
                    if(x0minus != true) {
                        x0minus = true;
                        count++;
                    }
                }

                continue;
            }

            else if(y == 0){
                if(x > 0){
                    if(y0plus != true) {
                        y0plus = true;
                        count++;
                    }
                }
                else {
                    if(y0minus != true) {
                        y0minus = true;
                        count++;
                    }
                }

                continue;
            }


            //x가 0이거나 y가 0인 경우가 아니라면 계산한다

            cal = Math.abs(y) / Math.abs(x);

            if(x > 0){
                if(y > 0){
                    if(!set1.contains(cal)) {
                        count++;
                        set1.add(cal);
                    }
                }

                else{
                    if(!set2.contains(cal)) {
                        count++;
                        set2.add(cal);
                    }
                }
            }
            else{
                if(y > 0){
                    if(!set3.contains(cal)) {
                        count++;
                        set3.add(cal);
                    }
                }

                else{
                    if(!set4.contains(cal)) {
                        count++;
                        set4.add(cal);
                    }
                }
            }
        }

        System.out.print(count);
    }
}
