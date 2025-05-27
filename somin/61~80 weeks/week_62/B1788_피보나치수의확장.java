import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1788_피보나치수의확장 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		if(n == 0) {
			System.out.println(0);
			System.out.println(0);
			return;
		}
		
		int fn = 999;
		
		if(n<0) {
			int[] dp = new int[Math.abs(n)+1];
			//음수의 경우
			dp[0] = 0;
			dp[1] = 1; 
			//dp[2] = dp[0] - d[1];
			for(int i=2;i<=Math.abs(n);i++) {
				dp[i] = dp[i-2] - dp[i-1];
				dp[i] %= 1000000000;
			}
			fn = dp[Math.abs(n)];
			if(fn<0) {
				System.out.println(-1);
			}else if(fn ==0 ) {
				System.out.println(0);
			}else {
				System.out.println(1);
			}
			System.out.println(Math.abs(fn)%1000000000);
			
		}else {
			int[] dp = new int[Math.abs(n)+1];
			//양수의 경우
			dp[0] = 0;
			dp[1] = 1; 
			//dp[2] = dp[0] + d[1];
			for(int i=2;i<=Math.abs(n);i++) {
				dp[i] = dp[i-1] + dp[i-2];
				dp[i] %= 1000000000;
			}
			fn = dp[Math.abs(n)];
			if(fn<0) {
				System.out.println(-1);
			}else if(fn ==0 ) {
				System.out.println(0);
			}else {
				System.out.println(1);
			}
			
			System.out.println(Math.abs(fn)%1000000000);
			
		}
		
		
	}
}
