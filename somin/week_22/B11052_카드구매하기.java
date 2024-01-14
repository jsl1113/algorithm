package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11052_카드구매하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		
		for(int i=1;i<n;i++) {
			dp[i] = arr[i];
			
			for(int j=0;j<i;j++) {
				dp[i] = Math.max(dp[j] + dp[(i-j-1)], dp[i]);
			}
			
		}
		System.out.println(dp[n-1]);
	}

}
