package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RV_B2225_ÇÕºÐÇØ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [][] dp = new int[k+1][n+1];
		
		for(int i=0;i<=n;i++) dp[1][i] = 1;
		for(int i=0;i<=k;i++) dp[i][0] = 1;
		

		for(int i=2;i<=k;i++) {
			for(int j=1;j<=n;j++) {
				dp[i][j] = dp[i][j-1] + dp[i-1][j];
				dp[i][j] = dp[i][j]%1000000000;
			}
		}
		
//		for(int [] i : dp) {
//			for(int j :i) {
//				System.out.print(j+" ");
//			}System.out.println();
//		}
		
		
		System.out.println(dp[k][n]);
	}

	

}
