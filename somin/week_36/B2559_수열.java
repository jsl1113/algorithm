import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2559_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[n];
		int [] dp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());	
			if(i==0) {
				dp[i] = arr[i];
				continue;
			}
			dp[i]+= dp[i-1]+ arr[i];
		}
		
		int sum=0; //첫번째 합
		for(int i=0;i<k;i++) {
			sum += arr[i];
		}

		for(int i=k;i<n;i++) {
			sum = Math.max(sum, dp[i]-dp[i-k]);
		}
		
		System.out.println(sum);
	}

}
