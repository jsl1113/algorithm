import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11441_합구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		int[] dp = new int[n+1];
	
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			dp[i+1] = dp[i] + arr[i];
		}
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			int ans = dp[e] - dp[s-1];
			System.out.println(ans);
		}

	}

}
