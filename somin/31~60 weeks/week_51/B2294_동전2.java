import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2294_µ¿Àü2 {

	static int n,k;
	static int[] dp,arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		dp = new int[k+1];
		Arrays.fill(dp, 100001);
		dp[0] =0;
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		Arrays.sort(arr);
		
		for(int i=0;i<n;i++) {
			int now = arr[i];
			for(int j=now;j<=k;j++) {
				dp[j] = Math.min(dp[j], dp[j - now]+1);
			}
		}
		
		if(dp[k] == 100001)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
		
	}

}
