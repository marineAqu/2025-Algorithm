import java.io.*;
import java.util.*;

public class BaekJoon16937 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        int size[][] = new int[n][2];

        //저장
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            size[i][0] = Integer.parseInt(st.nextToken());
            size[i][1] = Integer.parseInt(st.nextToken());
        }

        //두 스티커가 붙여진 넓이의 최댓값
        //H * w 사이즈의 모눈종이에 스티커 두개 붙이기. 스티커는 회전 가능

        //일단 h, w의 최댓값을 벗어난 스티커는 붙이지 못한다.
        //그리고 두 스티커 이어붙였을 때 어떻게해도 사이즈를 초과하면 붙이지 못한다.
        
        //n은 100보다 작으니까 그냥 브루트포스?

        int answer = 0;

        //계산
        for(int i=0; i<n-1; i++){

            for(int k=i+1; k<n; k++){
                if(h >= size[i][0] + size[k][0] && (w >= size[i][1] && w >= size[k][1])){
                    answer = Math.max(answer, (size[i][0] * size[i][1]) + (size[k][0] * size[k][1]));
                }

                if(w >= size[i][0] + size[k][0] && (h >= size[i][1] && h >= size[k][1])){
                    answer = Math.max(answer, (size[i][0] * size[i][1]) + (size[k][0] * size[k][1]));
                }

                if(h >= size[i][1] + size[k][0] && (w >= size[i][0] && w >= size[k][1])){
                    answer = Math.max(answer, (size[i][0] * size[i][1]) + (size[k][0] * size[k][1]));
                }

                if(w >= size[i][1] + size[k][0] && (h >= size[i][0] && h >= size[k][1])){
                    answer = Math.max(answer, (size[i][0] * size[i][1]) + (size[k][0] * size[k][1]));
                }

                if(h >= size[i][1] + size[k][1] && (w >= size[i][0] && w >= size[k][0])){
                    answer = Math.max(answer, (size[i][0] * size[i][1]) + (size[k][0] * size[k][1]));
                }

                if(w >= size[i][1] + size[k][1] && (h >= size[i][0] && h >= size[k][0])){
                    answer = Math.max(answer, (size[i][0] * size[i][1]) + (size[k][0] * size[k][1]));
                }

                if(h >= size[i][0] + size[k][1] && (w >= size[i][1] && w >= size[k][0])){
                    answer = Math.max(answer, (size[i][0] * size[i][1]) + (size[k][0] * size[k][1]));
                }

                if(w >= size[i][0] + size[k][1] && (h >= size[i][1] && h >= size[k][0])){
                    answer = Math.max(answer, (size[i][0] * size[i][1]) + (size[k][0] * size[k][1]));
                }
            }
        }

        System.out.print(answer);
    }
}
