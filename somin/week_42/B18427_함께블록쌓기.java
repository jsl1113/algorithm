import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B18427_�Բ���Ͻױ� {

	static int n,m,h;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		int [][] dp = new int[n+1][h+1];
		arr = new ArrayList[n+1];
		
		for(int i=0;i<=n;i++) arr[i] = new ArrayList<Integer>();
		
		for(int i=1;i<=n;i++) {
			String s[] = br.readLine().split(" ");
			
			for(int j=0;j<s.length;j++) {
				arr[i].add( Integer.parseInt(s[j]));
			}

			//dp[][0] �� 1�� �ʱ�ȭ
			dp[i][0] = 1;
		}
		//dp�� 1��° ���� ���Ͽ�
		dp[0][0] = 1;
		
		for(int i=2;i<=n;i++) {
			for(int j=1;j<=h;j++) {
				for(int num : arr[i]) {
					if(j >= num) {
						dp[i][j] += dp[i-1][j-num];
						dp[i][j] %=10007;
					}
				}
				//���� �� ���ϱ�
				dp[i][j] += dp[i-1][j];
				dp[i][j] %=10007;
			}
		}
		System.out.println(dp[n][h]);
		
	}
}
