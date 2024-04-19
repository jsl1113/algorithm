package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * dp����.. �̺�Ž�� ��� �ϴ� �ǵ�...
 * dp�� �����ϴ� ���� �����ɷȴµ�... ��� �ϴµ�..
 * 
 */
public class B22871_¡�˴ٸ��ǳʱ�large {

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
	 * ó���� ã�ƺ� �����ε� �� �ð��� ���� �ɷ��� ���ߴ�.
	 *  ���+dp�����̰� dp�� ��� -1�� �ʱ�ȭ�ϰ� ����.
	 *  branch(0)�� ����ϸ� ���� ������ ����
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
