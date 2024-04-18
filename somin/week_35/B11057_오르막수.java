import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11057_오르막수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
				
		int [][] dp = new int[10][1001];
		
		Arrays.fill(dp[9], 1);
		
		for(int i=0;i<=9;i++) {
			dp[i][0] = 1;
		}
		
		for(int i=0;i<10;i++) {
			dp[i][1] = 10-i;
		}
		
		//n이 2이상이다
		for(int num=2;num<=n;num++) {
			
			for(int i=8;i>=0;i--) {
				dp[i][num] = (dp[i+1][num]+dp[i][num-1])%10007;
			}
		}
		
		System.out.println(dp[0][n]%10007);
	}

}
