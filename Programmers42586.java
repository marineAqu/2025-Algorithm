public class Programmers42586 {
    
}
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] result = new int[progresses.length];
        int[] endDate = new int[progresses.length];

        //진도가 100이 되어야 반영 가능
        //뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있지만 앞에있는 기능 배포 시 배포가능

        //이때 한번 배포할때 몇개가 배포되는가

        //모든 기능의 완료 날짜 계산해서 endDate에 넣기
        //endDate는 0에서부터 시작해서 나보다 작은 애들 한 묶음으로 계산하고 answer에 넣기
        //다시 커졌을 때 1로 해서 다시계산
    //100 + 100 시간은 괜찮을거같은데 

        int mod;
        //1. endDate 계산
        //몫은 없고 나머지만 있는 경우도 정상적으로 계산됨
        //애초에 100으로 채워진 작업은 없다
        for(int i=0; i<progresses.length; i++){
            mod = 100 - progresses[i];
            if(mod % speeds[i] == 0) mod /= speeds[i];
            else mod = (mod / speeds[i]) + 1;

            endDate[i] = mod;
        }

        //2. 이제 한 묶음 개수를 저장하자
        int count = 0;
        int oneTime = 1;

//설마 첫날 5일 기다렸으니까 5 4 3 4 이런것도가능한거야?

        int maxDate = endDate[0];
        for(int i=1; i<progresses.length; i++) {
            //이어지는 경우
            if(maxDate >= endDate[i]){
                oneTime++;
            }

            //끊어지는 경우
            else{
                result[count++] = oneTime;
                oneTime = 1;
                maxDate = endDate[i];
            }
        }



        //마지막 계산
        result[count++] = oneTime;

        //3. 이제 정답 배열 만들기
        int[] answer = new int[count];
        for(int i=0; i<count; i++) answer[i] = result[i];
//7days, 3, 9
// 2 1

//첫번째 작업과 두번째 작업 사이 끊김이 있는 경우
//모든 작업 사이 끊김이 있는 경우
//모든 작업 사이 끊김이 없는 경우 
//

        return answer;
    }
}