package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B9657_µπ∞‘¿”3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int n = Integer.parseInt(br.readLine());
		
		int [] dp = new int[1001];
		
		// 1, 3, 4
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 1;
		dp[4] = 1;
		
		for(int i=5;i<=1000;i++) {
			
//			System.out.println( (i-1) +" /"+(i-3) +" /"+(i-4) +" /");
//			System.out.println(dp[i-1]);
//			System.out.println(dp[i-3]);
//			System.out.println(dp[i-4]);
			if(dp[i-1] == 2 || dp[i-3]==2 ||dp[i-4]==2) {
				dp[i] = 1;
			}else
				dp[i] =2;
			
		}
		if(dp[n]==1) {
			System.out.println("SK");
		}
		else
			System.out.println("CY");
		
	}

}
