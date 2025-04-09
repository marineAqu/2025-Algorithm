import java.io.*;

public class BaekJoon2671 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sound = br.readLine();

        //잠수함의 패턴은 (100~1~|01)~
        //01로 시작하거나
        //100으로 시작했으면 0이 사이에 자리잡을 수 있고, 그다음에 1이 마음대로 자리잡을 수 있다.
        
        //100부터 100..........1................
        //01 

        int code;
        //일단 100에서 0 두개가 필수라는 거, 1도 필수라는거

        //code1일때는 0, 1이 각각 실행되고 다시 code 검사를 해야함
        //code0일때는 0 두번 이상, 1 한번 이상 실행된 후 다시 code검사를 해야함.
        // 이때 다음 코드가 0이면 1, 1이면 0이라는 점 주의. 1 실행할만큼 실행하고 0이 시작된 순간 다음이 1이라면 code1이고
        //다음도 0이라면 code0인 것.

        //코드화해둘까
        //code = 0일때
        //incode가 1이면 현재 첫번째 0
        //          2면 현재 두번째 0
        //          3면 현재 세번째 1
        //          0면 첫번째 1

        //code 1일때
        //incode가 0이면 현재 0
        //          1이면 현재 1
        int incode;

        if(sound.charAt(0) == '0') {
            code = 1;
            incode = 0;
        }
        else {
            code = 0;
            incode = 0;
        }

        for(int i=1; i<sound.length(); i++){
            //100...1...
            if(code == 0){
                if(incode == 0){
                    if(sound.charAt(i) != '0'){
                        System.out.print("NOISE");
                        return;
                    }
                    else incode = 1;
                }

                else if(incode == 1){
                    if(sound.charAt(i) != '0'){
                        System.out.print("NOISE");
                        return;
                    }
                    else incode = 2; 
                }

                else if(incode == 2){ //나는 0이어도 1이어도 됨
                    if(sound.charAt(i) == '0'){
                        continue;
                    }
                    else {
                        incode = 3; // '1'인 경우 (1이 계속 이어지거나 code 0이 종료되거나)
                    }
                }

                else if(incode == 3){ //나는 0이어도 1이어도 됨
                    if(i == sound.length() - 1) break;

                    else if(i == sound.length() - 2 && sound.charAt(i+1) == '0'){
                        System.out.print("NOISE");
                        return;
                    }

                    if(sound.charAt(i) == '0'){
                        code = 1;
                        incode = 0;
                    }

                    else{ //지금도 '1'인 경우
                        //code0으로 돌아가 100...1... 이거나
                        //code1로 가서 1 / 010101이거나
                        if(sound.charAt(i+1) == '0'){
                            if(sound.charAt(i+2) == '0'){
                                code = 0;
                                incode = 0;
                            }
                        }

                        else{
                            continue;
                        }
                    }
                
                }
            }

            else{ //code == 1일때
                if(incode == 0){
                    if(sound.charAt(i) == '0'){
                        System.out.print("NOISE");
                        return;
                    }
                    else { 
                        incode = 1;
                    }
                }
    
                //01
                else{ // incode == 1
                    if(i == sound.length() - 1) break;

                    else if(sound.charAt(i) == '0'){
                        code = 1;
                        incode = 0;
                    }

                    else{
                        code = 0;
                        incode = 0; 
                    }
                }
            }
            
        }

        if(code == 0 && incode < 3){
            System.out.print("NOISE");
            return;
        }

        if(code == 1 && incode == 0){
            System.out.print("NOISE");
            return;
        }

        System.out.print("SUBMARINE");
    }
}
