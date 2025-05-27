import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2631_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n];
		dp[0] = 1;
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		
		//가장 긴 부분수열 구하기
		for(int i=1;i<n;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int max = 0;
		for(int d : dp) {
			if(d>max) max = Math.max(max, d);
		}
		
		System.out.println(n-max);
		
		
	}

}
