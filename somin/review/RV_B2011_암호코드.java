package review.w14Over;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RV_B2011_암호코드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		
		int [] dp = new int[str.length()+1];
		
		dp[0] = 1; 
		
		for(int i=1;i<=str.length();i++) {
			
			int now = str.charAt(i-1)-'0';
			
			if(now>0) {
				dp[i] +=dp[i-1];
				dp[i]%=1000000;
			}
			if(i==1)continue;
						
			int pri = 10*(str.charAt(i-2)-'0') + (str.charAt(i-1)-'0');
			
			if(pri >=10 &&pri <=26 && pri!=0) {
				dp[i] += dp[i-2];
				dp[i] %=1000000;
			}
			
		}

		
		System.out.println(dp[str.length()]);
	}

}
