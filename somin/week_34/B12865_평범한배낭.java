import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*
 * 왜 배낭문제 예전에도 푼 것 같은데.......
 * 아직도 어렵다
 */
public class B12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int dp[][] = new int[101][100001]; // n , k
		
		int[] weight = new int[1000];
		int[] val = new int[1000];
		
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			weight[i] = w;
			val[i] = v;
			
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				//지금j 무게이하일 때
				if(j >= weight[i]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + val[i] );
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
			
		}
		
		System.out.println(dp[n][k]);
		
	}
}

