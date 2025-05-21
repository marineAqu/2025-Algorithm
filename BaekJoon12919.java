import java.io.*;

public class BaekJoon12919 {
    static int s[], t[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        s = new int[line.length()];
        for(int i=0; i<line.length(); i++) s[i] = (int)(line.charAt(i) - 'A' + 1);

        line = br.readLine();
        t = new int[line.length()];
        for(int i=0; i<line.length(); i++) t[i] = (int)(line.charAt(i) - 'A' + 1);

        dfs(false, 0, t.length-1);

        System.out.println(0);
    }

    static void dfs(boolean reverse, int front, int end){
        if(Math.abs(front - end) + 1 == s.length){
            if(reverse){
                for(int i=0; i<s.length; i++){
                    if(s[i] != t[front-i]) return;
                }
            }

            else{
                for(int i=0; i<s.length; i++){
                    if(s[i] != t[i+front]) return;
                }
            }

            System.out.println(1);
            System.exit(0);
        }

        if(reverse){
            if(t[front] == 2){
                dfs(false, end, front-1);
            }

            if(t[end] == 1){
                dfs(reverse, front, end+1);
            }
        }

        else{
            if(t[front] == 2){
                dfs(true, end, front+1);
            }

            if(t[end] == 1){
                dfs(reverse, front, end-1);
            }
        }
    }
}
