import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2193_ÀÌÄ£¼ö {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		long dp[] = new long [91];
		
		dp[1] = 1; dp[2] = 1;
		
		for(int i=3;i<=n;i++) {
			
			dp[i] = dp[i-1]+dp[i-2];
			
		}

//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
	}

}
