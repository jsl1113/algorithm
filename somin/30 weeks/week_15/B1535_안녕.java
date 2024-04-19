package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1535_¾È³ç {

	static int n;
	static int[] lose;
	static int[] joy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		lose = new int[n];
		joy = new int[n];
		int[] dp = new int[101];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			lose[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			joy[i] = Integer.parseInt(st.nextToken());
		}
	
		

		for (int i = 0; i < n; i++) {
			for (int j=99; j>=lose[i];j--) {
				dp[j] = Math.max(dp[j-lose[i]]+joy[i], dp[j]);
			}
		}
		
		System.out.println(dp[99]);
	}


}
