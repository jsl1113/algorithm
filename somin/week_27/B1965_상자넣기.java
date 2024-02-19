import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1965_상자넣기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());

		
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		int dp[] = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 1; 
		int ans = 0;
		for(int i=1;i<n;i++) {
			dp[i]= 1;
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j]) {
					dp[i]= Math.max(dp[i], dp[j]+1);
				}
			}
			
			ans = Math.max(ans, dp[i]);
			
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(ans);
//		System.out.println(dp[n-1]); //처음에 마지막으로 출력해서 틀림 ; 최대값을 출력해야함
	}

}
