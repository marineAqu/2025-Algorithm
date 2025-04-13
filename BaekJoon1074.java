import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Math;

public class BaekJoon1074 {
	static int num;
	static int len;
	static int r, c;
	static int xIndex, yIndex;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		//n=1이면 제트 하나. 일단 r, c가 큰 Z에서 몇번째 Z이고 그 안의 Z에서 몇번째 Z인지를 확인해야 한다.
		//int countz = (int) Math.pow(4, n-1); //z의 개수
		int size = (int) Math.pow(2, n); //한 줄 개수
		
		//                  63                   64
		len = size/2;

		xIndex = len;
		yIndex = len;

		repeatMethod(0, size * size - 1, size * size);
		System.out.print(num);
	}
	
	//x, y는 Z의 범위
	static void repeatMethod(int x, int y, int size) {
		if(size == 1) {
			num = x;
			return;
		}
		
		size /= 4; //16
		len /= 2;
		
		// 64 -> 16 -> 4
		// 8 -> 4 -> 1
		
		if(r+1 > yIndex) {
			yIndex += len;

			if(c+1 > xIndex) {
				xIndex += len;
				repeatMethod(x+size*3, y, size);
				return;
			}
			else {
				xIndex -= len;
				repeatMethod(x+size*2, y-size, size);
				return;
			}
		}
		
		else {
			yIndex -= len;
			if(c+1 > xIndex) {
				xIndex += len;
				repeatMethod(x+size, y-size*2, size);
				return;
			}
			else {
				xIndex -= len;
				repeatMethod(x, y-size*3, size);
				return;
			}
		}
	}
}
