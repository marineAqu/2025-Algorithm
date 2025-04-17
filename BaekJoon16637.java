import java.io.*;
import java.io.InputStreamReader;

public class BaekJoon16637 {
    static int n, answer = Integer.MIN_VALUE;
    static String line;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        line = br.readLine();
        
        //int memorize[] = new int[line.length() + 1];
        
        //수식의 길이 19
        //시간 0.5초 = 5천번 연산
        //그러면 메모라이징해둬야하나
        
        //0, 2 사이 계산을 1에 두고
        //2 4 사이 계산은 3

        //순서대로계산하는거라 메모라이징이 의미가없을것같음 
        //일단 맨 앞은 괄호를 두나 안 두나 의미가 없음

        //2번째 숫자부터 의미가 있다
        //2^10 = 1024번 시간초과 안나지않을까

        calc(2, line.charAt(0)-'0');

        System.out.println(answer);
    }

    static void calc(int depth, int sum){
        if(depth > n){
            //계산 완료
            answer = Math.max(answer, sum);
            return;
        }

        //괄호를 하느냐 마느냐
        if(depth == line.length()-1){
            //괄호 사용 불가
            if(line.charAt(depth-1) == '*'){
                calc(depth+2, sum*(line.charAt(depth)-'0'));
            }

            if(line.charAt(depth-1) == '+'){
                calc(depth+2, sum+(line.charAt(depth)-'0'));
            }

            if(line.charAt(depth-1) == '-'){
                calc(depth+2, sum-(line.charAt(depth)-'0'));
            }
        }

        else{
            //1. 괄호 미사용
            if(line.charAt(depth-1) == '*'){
                calc(depth+2, sum*(line.charAt(depth)-'0'));
            }

            if(line.charAt(depth-1) == '+'){
                calc(depth+2, sum+(line.charAt(depth)-'0'));
            }

            if(line.charAt(depth-1) == '-'){
                calc(depth+2, sum-(line.charAt(depth)-'0'));
            }

            //2. 괄호 사용
            if(line.charAt(depth-1) == '*'){
                if(line.charAt(depth+1) == '*'){
                    calc(depth+4, sum*((line.charAt(depth)-'0')*(line.charAt(depth+2)-'0')));
                }
                else if(line.charAt(depth+1) == '+'){
                    calc(depth+4, sum*((line.charAt(depth)-'0')+(line.charAt(depth+2)-'0')));
                }
                else if(line.charAt(depth+1) == '-'){
                    calc(depth+4, sum*((line.charAt(depth)-'0')-(line.charAt(depth+2)-'0')));
                }
            }

            if(line.charAt(depth-1) == '+'){
                if(line.charAt(depth+1) == '*'){
                    calc(depth+4, sum+((line.charAt(depth)-'0')*(line.charAt(depth+2)-'0')));
                }
                else if(line.charAt(depth+1) == '+'){
                    calc(depth+4, sum+((line.charAt(depth)-'0')+(line.charAt(depth+2)-'0')));
                }
                else if(line.charAt(depth+1) == '-'){
                    calc(depth+4, sum+((line.charAt(depth)-'0')-(line.charAt(depth+2)-'0')));
                }
            }

            if(line.charAt(depth-1) == '-'){
                if(line.charAt(depth+1) == '*'){
                    calc(depth+4, sum-((line.charAt(depth)-'0')*(line.charAt(depth+2)-'0')));
                }
                else if(line.charAt(depth+1) == '+'){
                    calc(depth+4, sum-((line.charAt(depth)-'0')+(line.charAt(depth+2)-'0')));
                }
                else if(line.charAt(depth+1) == '-'){
                    calc(depth+4, sum-((line.charAt(depth)-'0')-(line.charAt(depth+2)-'0')));
                }
            }
        }

    }
}
