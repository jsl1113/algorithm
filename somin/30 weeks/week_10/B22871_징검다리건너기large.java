package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * dp말고.. 이분탐색 어떻게 하는 건데...
 * dp도 이해하는 데에 오래걸렸는데... 어떻게 하는데..
 * 
 */
public class B22871_징검다리건너기large {

	static int n;
	static long[] arr,dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new long[n];
		dp = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		dp[0]= 0;
		dp[1] =1+ Math.abs(arr[0]-arr[1]);
		for(int i=2;i<n;i++) {
			dp[i] = Integer.MAX_VALUE;
			for(int j=0;j<i;j++) {
				long k = (i-j)*(1+Math.abs(arr[j]-arr[i]));
				k = Math.max(dp[j], k);
				dp[i] = Math.min(dp[i], k);
			}
		}
		System.out.println(dp[n-1]);
	}
	
	/*
	 * 처음에 찾아본 형식인데 더 시간이 많이 걸려서 비추다.
	 *  재귀+dp느낌이고 dp를 모두 -1로 초기화하고 시작.
	 *  branch(0)을 출력하면 답이 나오는 형식
	 */
	public static long branch(int x) {
		if(x == n-1) return 0;
		if(dp[x]!=-1) return dp[x];
		
		dp[x] = Integer.MAX_VALUE;
		
		for(int i=x+1;i<n;i++) {
			dp[x] = Math.min(dp[x], Math.max(branch(i), (i-x)*(1+Math.abs(arr[x]-arr[i]))));
		}
		return dp[x];
		
	}

}
