import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//������ ������ �˰ԵǾ���. nCr = n-1 C r-1 + n-1 C r
// math + dp ����
public class B1010_�ٸ����� {
	
	static int[][] dp = new int[30][30];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if(n==0 || m==0) {
				System.out.println(0);
			}else
				System.out.println(comb(m, n));
			
		}

	}
	
	/*
	 * ���� : n���� ���� �߿� r���� ���� ���� ���� �̴� ���
	 * nCr = n-1 C r-1 + n-1 C r
	 */
	static int comb(int n, int r) {
		
		if(n==r || r ==0) {
			return 1;
		}
		if(dp[n][r] !=0) {
			return dp[n][r];
		}
		else
			return dp[n][r]= comb(n-1, r-1)+comb(n-1, r);
		
	}

}
