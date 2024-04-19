package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16194_카드구매하기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] p = new int[n+1];
		int [] dp = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=1;i<=n;i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=1;i<=n;i++) {
			dp[i] = p[i];
			for(int j=1;j<=i;j++) {
				dp[i] = Math.min(dp[i-j]+p[j], dp[i]);
			}
		}
		
		System.out.println(dp[n]);
		
	}

}
