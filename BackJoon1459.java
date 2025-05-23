import java.util.*;
import java.io.*;

public class BackJoon1459 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		
		int w = Integer.parseInt(st.nextToken()); //한블록
		int s = Integer.parseInt(st.nextToken()); //대각선 한블록
		
		long result = 0;
		
		//overflow warning
		
		//w*2보다 s가 작으면 최대한 s로 가야하고, 그렇지 않으면 한 블럭씩 가야한다.
		// ** __ 보다 /\로 가는게 이득인 경우가 있다
		
		
		if(w*2 > s) {
			//최대한 대각선으로 이동
			if(x > y) {
				result = y * s; //대각선
				x -= y;
				if(w > s) {
					// ** __ 보다 /\로 가는게 이득인 경우가 있다
					result += ((x/2)*2) * s;
					x = x%2;
				}
				result += x * w;
			}
			
			else {
				result = x * s; //대각선
				y -= x;
				if(w > s) {
					// ** __ 보다 /\로 가는게 이득인 경우가 있다
					result += ((y/2)*2) * s;
					y = y % 2;
				}
				result += y * w;
			}
			
			System.out.print(result);
		}
		
		else {
			System.out.print((x+y)*w);
		}	
	}
}
//18 * 11 + 49 = 198+49 = 247
