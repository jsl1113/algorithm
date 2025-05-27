import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 모르는 문제 
 * 2차원 dp를 사용해서 서로 같은 문자일 때 
 * dp[i][j] = dp[i-1][j-1]+1; 해주는 것이 핵심
 */
public class B5582_공통부분문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		String b = br.readLine();
		
		int[][] dp = new int[a.length()+1][b.length()+1];
		
		int max =0;
		
		for(int i=1;i<=a.length();i++) {
			for(int j=1;j<=b.length();j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
					max = Math.max(max, dp[i][j]);
				}
			}
			
		}
		System.out.println(max);
		
	}

}
