package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 머리가 안돌아가요
 */
public class B9251_LCS {

	static String s,t;
	static Integer [][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		s = br.readLine();
		t = br.readLine();
		
		dp = new Integer[s.length()][t.length()];
		
		System.out.println(LCS(s.length()-1,t.length()-1));
	}
	static int LCS(int x, int y) {
		
		if(x==-1 || y==-1) {
			return 0;
		}
		
		if(dp[x][y]==null) {
			dp[x][y] = 0;
			
			if(s.charAt(x) == t.charAt(y)) {
				dp[x][y] = LCS(x-1,y-1)+1;
			}else {
				dp[x][y] = Math.max(LCS(x-1,y),LCS(x,y-1));
				
			}
		}
		
		
		return dp[x][y];
	}

}
