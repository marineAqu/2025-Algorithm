import java.util.*;
import java.io.*;

public class BaekJoon1786{
    public static void main(String args[]) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        String p = br.readLine();

        KMP(t, p);
    }

    static void KMP(String t, String p){
        int[] table = makeTable(p);

        int n1 = t.length();
        int n2 = p.length();
        int idx = 0;
        int cnt = 0;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n1; i++){
            while(idx > 0 && t.charAt(i) != p.charAt(idx)){
                idx = table[idx-1];
            }

            if(t.charAt(i) == p.charAt(idx)){
                if(idx == n2 - 1){
                    sb.append((i - idx + 1) + " ");
                    cnt++;
                    idx = table[idx];
                }

                else {
                    idx++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    static int[] makeTable(String p){
        int n = p.length();
        int[] table = new int[n];

        int idx = 0;

        for(int i=1; i<n; i++){
            while(idx > 0 && p.charAt(i) != p.charAt(idx)){
                idx = table[idx - 1];
            }

            if(p.charAt(i) == p.charAt(idx)){
                table[i] = ++idx;
            }
        }

        return table;
    }
}