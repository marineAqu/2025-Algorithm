import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1759 {
    static char aeiou[];
    static char alp[];
    static int L, C;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); // 길이
        C = Integer.parseInt(st.nextToken());

        aeiou = new char[C];
        alp = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        char now;
        for (int i=0; i<C; i++) {
            now = st.nextToken().charAt(0);
            alp[i] = now;
        }

        Arrays.sort(aeiou);
        Arrays.sort(alp);
        

        //최소 한 개의 모음 & 최소 두 개의 자음으로 구성. 
        //증가하는 순서로 배열되어야 한다.
        func("", 0, false, -1, 0);
    }

    static public void func(String line, int depth, boolean isContain, int lastIndex, int jaCount){
        if(depth == L) {
            if(isContain == true && jaCount > 1) System.out.println(line);
            return;
        }

        for(int i=lastIndex+1; i<C; i++){
            if(visited[i] == false){
                visited[i] = true;
                if(alp[i] == 'a' || alp[i] == 'e' || alp[i] == 'o' || alp[i] == 'i' || alp[i] == 'u'){
                    func(line + alp[i], depth+1, true, i, jaCount);
                }
                else func(line + alp[i], depth+1, isContain, i, jaCount+1);

                visited[i] = false;
            }
        }
    }
}
