package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * swap을 떠오르긴 했는데 왜 열과 열을 스왑한다고 생각했는지..
 * 괜히 기억에 의존해서 안좋은.. 결과가 나왔다
 * 
 * 하나 하나 바꿔서 모든 경우를 다 체크하는 것이 해결방법이였다...
 */
public class RV_B3085_사탕게임 {

	static int n;
	static Character [][] map;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new Character[n][n];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j);
			}
		}
//		System.out.println(Arrays.deepToString(map));
		
		
		//행체크
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1;j++) {
				char c = map[i][j];
				map[i][j] = map[i][j+1];
				map[i][j+1] = c;
				
				//
				check();
				
				c = map[i][j+1];
				map[i][j+1] = map[i][j];
				map[i][j] = c;
				
			}
		}
		
		
		
		//열체크
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1;j++) {
				Character c = map[j][i];
				map[j][i] = map[j+1][i];
				map[j+1][i] = c;
				
				max = Math.max(max, check());
				
				c = map[j+1][i];
				map[j+1][i] = map[j][i];
				map[j][i] = c;
				
			}
		}
		
		
		System.out.println(max);
		
	}
	public static int check() {
		
		//가로
		for(int i=0;i<n;i++) {
			int cnt=1;
			for(int j=0;j<n-1;j++) {
				if(map[i][j]==map[i][j+1]) {
					cnt++;
				}
				else {					
					cnt=1;
				}
				max =Math.max(max, cnt);
			}
		}
		
		//세로
		
		for(int i=0;i<n;i++) {
			int cnt=1;
			for(int j=0;j<n-1;j++) {
				if(map[j][i] == map[j+1][i]) {
					cnt++;
				}
				else {					
					cnt=1;
				}
				max =Math.max(max, cnt);
			}
		}
		return max;
		
	}
	
}
