import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2229_조짜기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] dp = new int[n+1];
		
		/*
		 * max, min 을 해서 max-min +dp전 
		 */
		
		for(int i=2;i<=n;i++) {
			
			int max = arr[i];
			int min = arr[i];

			for(int j=i;j>=1;j--) {
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);
				
				dp[i] = Math.max(dp[i], max-min + dp[j-1]);
			}
			
		}
		
		System.out.println(dp[n]);
		
		
		
	}

}
