import java.io.*;
import java.util.*;

public class BaekJoon20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        String line;
        int[][] map = new int[26][10000];
        int[] size = new int[26];
        int k, min2, max3;
        int val;

        for(int i=0; i<tc; i++){
            //초기화
            for(int r=0; r<26; r++) Arrays.fill(map[r],0);
            for(int r=0; r<26; r++) Arrays.fill(size,0);

            min2 = Integer.MAX_VALUE;
            max3 = -1;

            line = br.readLine();
            k = Integer.parseInt(br.readLine());

            for(int r=0; r<line.length(); r++){
                val = line.charAt(r) - 'a';
                map[val][size[val]++] = r;
            }

            for(int q=0; q<26; q++) {
                for(int t=0; t<=size[q] - k; t++){
                    min2 = Math.min(min2, map[q][t+k-1] - map[q][t] + 1);
                    max3 = Math.max(max3, map[q][t+k-1] - map[q][t] + 1);
                }
            }

            if(min2 == Integer.MAX_VALUE || max3 == -1) System.out.println(-1);
            else System.out.println(min2 + " " + max3);
        }
    }
}
