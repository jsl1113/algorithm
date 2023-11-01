package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * dp�� �Ҷ� arr ={3,8,24}�� �ϸ�
 * 3�� ��츦 ���ϰ� ���� 8�� ��츦 ���ϰ� 24�� ��츦 �ϸ鼭 
 * ī��Ʈ�� �����ϴ� ����� ���� ���ߴ�. += �ϸ� �Ǿ���..
 */
public class B3067_Coins {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int k=0;k<t;k++) {
			
			int n = Integer.parseInt(br.readLine());
			
			int [] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int m = Integer.parseInt(br.readLine());	

			int [] dp = new int[m+1];
			dp[0] = 1;
			
			for(int i=0;i<n;i++) {
				for(int j=arr[i];j<=m;j++) {
					dp[j] += dp[j-arr[i]];
				}
			}
			System.out.println(dp[m]);
			
		}
		
	}

}
