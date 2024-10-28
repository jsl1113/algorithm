import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//��ȭ���� �ʹ� ����� �� �ƴѰ���? 
public class B15989_123���ϱ�4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		int[] num = new int[t];
		int[] dp = new int[10001];
	
		int max = 0;
		for(int i=0;i<t;i++) {
			num[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, num[i]);
		}
		dp[0] = 0; dp[1] = 1;
		dp[2] = 2; // 1+1 , 2.
		dp[3] = 3; 
		
		for(int i=4;i<=max;i++) {
			dp[i] = dp[i-3] + i/2 +1;
		}
		for(int aa : num) {
			System.out.println(dp[aa]);
		}
		
		
		
		
	}

}
