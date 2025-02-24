import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1699_Á¦°ö¼öÀÇÇÕ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		long [] dp = new long[n+1];
		
		
		dp[1]=1;
		
		/*
		 * ÇÙ½É : j*j<=i;
		 * (i - j*j)+1 
		 */
		
		for(int i=2;i<=n;i++) {
			dp[i] = i;
			for(int j=1;j*j<=i;j++) {
				if(dp[i] > dp[i - j*j ]+1) {
					dp[i] = dp[i- j*j ]+1;
				}
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
	}

}
