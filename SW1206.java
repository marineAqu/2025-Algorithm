import java.util.*;
import java.io.*;


public class SW1206 {

	public static void main(String[] args) throws IOException{
		//반드시 횟수만큼 교환, 동일한 위치의 교환이 중복되어도 된다.
		//받을 수 있는 가장 큰 금액
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n, count;
		int map[] = new int[1005];
		int dp;
		
		for(int tc=1; tc<=10; tc++) {
			count = 0;
			n = Integer.parseInt(br.readLine());
			
			Arrays.fill(map,0);
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=2; i<n+2; i++) map[i] = Integer.parseInt(st.nextToken());
			
			//세대 수 count
			for(int i=2; i<n+2; i++) {
				dp = Math.max(Math.max(map[i-2], map[i-1]), Math.max(map[i+2], map[i+1]));
				
				if(map[i] > dp) count += map[i] - dp;
			}
			
			//i-2, i-1과 i+1, i+2의 최대 높이를 확인하고 map[i] - max 가 조망권 획득 세대 수
			
			System.out.println("#"+tc+" "+count);
		}
	}
}
