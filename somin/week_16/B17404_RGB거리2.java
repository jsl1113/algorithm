package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17404_RGB거리2 {

	static int[][] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][3];
		dp = new int[n][3];
		
		int ans = Integer.MAX_VALUE;

		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int c=0;c<3;c++) {
			
			for(int j=0;j<3;j++) { //선택한 색 말고는 1001 (최대1000)
				if(j == c) {
					dp[0][j] = arr[0][j];
				}else
					dp[0][j] = 1001;
			}
			
			for(int j=1;j<n;j++) {
				dp[j][0] = arr[j][0]+Math.min(dp[j-1][1], dp[j-1][2]);
				dp[j][1] = arr[j][1]+Math.min(dp[j-1][0], dp[j-1][2]);
				dp[j][2] = arr[j][2]+Math.min(dp[j-1][0], dp[j-1][1]);
				
				if(j==n-1) {

					if(c==0) {
						ans = Math.min(ans, Math.min(dp[n-1][1], dp[n-1][2]));
					}
					if(c==1) {
						ans = Math.min(ans, Math.min(dp[n-1][0], dp[n-1][2]));
					}
					if(c==2) {
						ans = Math.min(ans, Math.min(dp[n-1][0], dp[n-1][1]));
					}
				}
				
			}
	
		}
	
		System.out.println(ans);

	}


}
