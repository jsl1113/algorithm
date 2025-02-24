import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2096_내려가기 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[3];
		int[] dp2 = new int[3];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(i==0) {
				dp[0] =dp2[0]= a;
				dp[1] =dp2[1]= b;
				dp[2] =dp2[2]= c;
				continue;
			}
			
			int one = dp[0];
			int two = dp[1];
			int three = dp[2];
			
			dp[0] = Math.max(one, two)+a;
			dp[1] = Math.max(one, Math.max(three, two))+b;
			dp[2] = Math.max(two, three) +c;
			
			one = dp2[0];
			two = dp2[1];
			three = dp2[2];
			
			dp2[0] = Math.min(one, two)+a;
			dp2[1] = Math.min(one, Math.min(three, two))+b;
			dp2[2] = Math.min(two, three) +c;
			
			
		}
		System.out.print(Math.max(dp[0], Math.max(dp[2], dp[1]) ) + " ");
		System.out.print(Math.min(dp2[0], Math.min(dp2[2], dp2[1]) ));
		
	}

}
