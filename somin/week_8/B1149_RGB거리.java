package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149_RGB°Å¸® {

	static int n;

	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		dp = new int[n][3];
		
		
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<3;j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		
	
		
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<3;j++) {
				if(j==0) {
					dp[i][j] += Math.min(dp[i-1][1],dp[i-1][2] );
				}
				if(j==1) {
					dp[i][j] += Math.min(dp[i-1][0],dp[i-1][2] );
				}
				if(j==2) {
					dp[i][j] += Math.min(dp[i-1][0],dp[i-1][1] );
				}
			}
		}
		
	
		
		int min = dp[n-1][0];
		
		for(int a:dp[n-1]) {
			if(min>a) min = a;
		}
		
		System.out.println(min);
	}

}
