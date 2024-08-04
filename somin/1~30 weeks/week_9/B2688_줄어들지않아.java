package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 망할문제 혹시나 했더니~ long~~~~
 */
public class B2688_줄어들지않아 {

	static long[] dp = new long[65];
	static long[][] num;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		dp[1] = 10; //0 1 2 3 4 5 6 7 8 9
		
		int ans[] = new int[t]; 

		int max = 0;
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			ans[i]=n;
			if(max<n) max=n;
		}
		num = new long[max+1][10];
		for(int i=0;i<max+1;i++) {
			if(i==1)
				Arrays.fill(num[i], 1);
			else
				Arrays.fill(num[i], 0);
		}
		for(int i=1;i<=max;i++) {
			if(dp[i]==0) {
				up(i);							
			}
		}
		for(int i=0;i<t;i++) {
			System.out.println(dp[ans[i]]);
		}
		
//		System.out.println(Arrays.deepToString(num));
//		System.out.println(dp);
//		System.out.println(num[max][1]);
		
	}
	public static void up(int n) {
		//n이 2임
		for(int i=0;i<10;i++) {
			long cnt = num[n-1][i]; //0이 계쏙 증가?
			for(int j=i;j<10;j++) {
				num[n][j] = num[n][j] + (cnt);
			}
		}
		
//		for(int []i:num) {
//			for(int j :i) {
//				System.out.print(j+" ");
//			}System.out.println();
//		}
		
		for(long i:num[n]) {
			dp[n]+=i;
		}
//		System.out.println(dp[n]);
		
	}

}
