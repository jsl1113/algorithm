import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B2565_전깃줄 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][2];
		int[] dp = new int[n+1];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[i][0] = a;
			arr[i][1] = b;
		}

		//0번째 기준으로 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int max = 0;
		for(int i=0;i<n;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[i][1] > arr[j][1]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(n-max);
		
	}

}
