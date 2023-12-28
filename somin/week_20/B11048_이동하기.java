package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11048_이동하기 {

	static int n,m;
	static int[][] map,dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		dp = new int[n][m];
		
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];
		
		for(int i=1;i<n;i++) {
			dp[i][0] = dp[i-1][0]+ map[i][0];
		}
		
		for(int i=1;i<m;i++) {
			dp[0][i] = dp[0][i-1]+ map[0][i];
		}
		
		
		
		
		
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + map[i][j];
			}
		}
		
//		for (int[] aa : dp) {
//			for (int a : aa) {
//				System.out.print(a + " ");
//			}
//			System.out.println();
//		}System.out.println("--------");
//		for (int[] aa : map) {
//			for (int a : aa) {
//				System.out.print(a + " ");
//			}
//			System.out.println();
//		}
		
		
		System.out.println(dp[n-1][m-1]);
	}

}
