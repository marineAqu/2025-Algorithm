import java.util.*;

public class Programmers12939 {
    
}

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        int n;
        while(st.hasMoreTokens()){
            n = Integer.parseInt(st.nextToken());
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        return min+" "+max;
    }
}
