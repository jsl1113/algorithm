package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1912_연속합 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[n];
		int [] dp = new int[n];
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		dp[0] = arr[0];
		int max = dp[0];
		//10 -4 3 1 5 6 -35 12 21 -1
		for(int i=1;i<n;i++) {
			//System.out.println(i+"번째 dp[i-1]+arr[i]: "+(dp[i-1]+arr[i])+" arr: "+arr[i]);
			dp[i] = Math.max(dp[i-1]+arr[i],arr[i] );
			
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
