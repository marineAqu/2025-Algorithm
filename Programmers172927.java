public class Programmers172927 {
    
}

class Solution {
    static int calc[] = new int[3];
    static int stress[][];
    static int min = Integer.MAX_VALUE;
    static int g;
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        g = (minerals.length/5);
        
        // 각 곡괭이는 종류에 상관없이 5개 캔 후 끝
        // 한 번 시작하면 끝까지 사용
        
        stress = new int[(minerals.length/5)+1][3];
        
        for(int i=0; i<minerals.length; i++){
            if(minerals[i].equals("diamond")){
                stress[i/5][0] += 1;
                stress[i/5][1] += 5;
                stress[i/5][2] += 25;
            }
            
            if(minerals[i].equals("iron")){
                stress[i/5][0] += 1;
                stress[i/5][1] += 1;
                stress[i/5][2] += 5;
            }
            
            if(minerals[i].equals("stone")){
                stress[i/5][0] += 1;
                stress[i/5][1] += 1;
                stress[i/5][2] += 1;
            }
        }
        
        method(picks, 0, 0);
        
        return min;
    }
    
    public void method(int picks[], int depth, int sum){
        if(depth == g+1) {
            if (min > sum) min = sum;
            return;
        }
        
        if(picks[0] == calc[0] && picks[1] == calc[1] && picks[2] == calc[2]) {
            if (min > sum) min = sum;
            return;
        }
        
        
        for(int i=0; i<3; i++){
            if(picks[i] > calc[i]){
                calc[i]++;
                method(picks, depth+1, sum + stress[depth][i]);
                calc[i]--;
            }
        }
    }
}
