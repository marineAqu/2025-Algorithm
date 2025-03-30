import java.io.*;
import java.util.*;

public class BaekJoon2667 {
    static int n;
    static String[] map;
    static PriorityQueue<Integer> list = new PriorityQueue<>();
    static boolean visited[][];
  
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      
      map = new String[n];
      visited = new boolean[n][n];
      
      for(int i=0; i<n; i++) map[i] = br.readLine();
      
      for(int i=0; i<n; i++){
        for(int r=0; r<n; r++){
          if(visited[i][r] == false && map[i].charAt(r) == '1'){
            list.add(dfs(r, i));
          }
        }
      }
      
      //계산 종료
      System.out.println(list.size());
      while(!list.isEmpty()) System.out.println(list.poll());
  }
  
  static int dfs(int x, int y){
    visited[y][x] = true;
    int count = 1;
    
    if(x + 1 < n && map[y].charAt(x+1) == '1' && visited[y][x+1] == false){
      count += dfs(x+1, y);
    }
    
    if(y + 1 < n && map[y+1].charAt(x) == '1' && visited[y+1][x] == false){
      count += dfs(x, y+1);
    }
    
    if(x - 1 >= 0 && map[y].charAt(x-1) == '1' && visited[y][x-1] == false){
      count += dfs(x-1, y);
    }
    
    if(y - 1 >= 0 && map[y-1].charAt(x) == '1' &&  visited[y-1][x] == false){
      count += dfs(x, y-1);
    }
    
    return count;
  }
}
