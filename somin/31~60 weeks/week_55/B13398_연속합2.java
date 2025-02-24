import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B13398_연속합2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		int[] dp2 = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		int max = dp[0];
		
		for(int i=1;i<n;i++) {
			dp[i] = arr[i];
			dp[i] = Math.max(dp[i-1]+arr[i], dp[i]);
			
			max = Math.max(dp[i], max);
		}
		
		dp2[n-1] = arr[n-1];
		for(int i=n-2;i>=0;i--) {
			dp2[i] = arr[i];
			dp2[i] = Math.max(dp2[i+1]+arr[i], dp2[i]);
		}
		
		/*
		 * 1부터 i-1 / i(제외) / i+1 부터 n 까지의 합
		 */
		for(int i=1;i<n-1;i++) {
			max = Math.max(max, dp[i-1]+dp2[i+1]);
		}
		
		System.out.println(max);
		
	}

}
