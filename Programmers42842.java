class Programmers42842 {

}

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int x, y;
        
        //2x+2y-4 = brown
        //(x-2)*(y-2) = yellow
        //xy - 2x -2y +4 = yellow
        //xy - brown = yellow
        //12 -> 1*12
        //2*6, 3*4
        
        int mul = yellow + brown;
        int addval = (brown + 4) / 2;
        
        for(int i=1; i<=addval / 2; i++){
            if(i * (addval - i) == mul){
                answer[1] = i;
                answer[0] = addval - i;
                break;
            }
        }
        
        return answer;
    }
}
