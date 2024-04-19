package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B9465_½ºÆ¼Ä¿ {

	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());


		int t = Integer.parseInt(br.readLine());
		for(int k=0;k<t;k++) {
			n = Integer.parseInt(br.readLine());
			
			int [][] dp = new int[2][n];
			for(int i=0;i<2;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			if(n==1) {
				System.out.println(Math.max(dp[0][0], dp[1][0]));
				continue;
			}
			if(n==2) {
				System.out.println(Math.max(dp[0][1] + dp[1][0], dp[1][1] + dp[0][0]));
				continue;
			}
			
			dp[0][1] += dp[1][0];
			dp[1][1] += dp[0][0];
			for(int i=2;i<n;i++) {
				dp[0][i] += Math.max( dp[1][i-1], dp[1][i-2]);
				dp[1][i] += Math.max( dp[0][i-1], dp[0][i-2]);
			}
			System.out.println(Math.max( dp[1][n-1], dp[0][n-1]));
			
			
		}
	}


}
