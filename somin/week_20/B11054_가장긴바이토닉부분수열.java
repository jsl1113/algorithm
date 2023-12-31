package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 진짜... 풀고싶은데 어렵따..........ㅜ
 */
public class B11054_가장긴바이토닉부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int[n];
		int [] arr2 = new int[n];
		int [] dp = new int[n];
		int [] dp2 = new int[n];
		
		int sum =Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0;i<n;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				
				if(arr[j]<arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		//
		for(int i=n-1;i>=0;i--) {
			dp2[i] = 1;
			for(int j=n-1;j>i;j--) {
				
				if(arr[j]<arr[i]) {
					dp2[i] = Math.max(dp2[i], dp2[j]+1);
				}
			}
		}
		
		int max = 0;
		
		for(int i=0;i<n;i++) {
			if(max<dp[i]+dp2[i]) {
				max = dp[i]+dp2[i];
			}
		}
		
		System.out.println(max-1);
		
	}
	
	
	

}
