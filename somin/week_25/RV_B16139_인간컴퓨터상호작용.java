package review.w14Over;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RV_B16139_인간컴퓨터상호작용 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		String s = br.readLine();
		
		int q = Integer.parseInt(br.readLine());
		
		int dp[][] = new int[s.length()][26];
		
		for(int i=0;i<s.length();i++) {
			if(i!=0) {
				for(int j=0;j<26;j++) {
					dp[i][j] += dp[i-1][j];
				}
			}
			
			dp[i][s.charAt(i)-'a']++;
			
			
			
		}

		
		for(int i=0;i<q;i++) {
			st = new StringTokenizer(br.readLine());
			int al = st.nextToken().charAt(0)-'a';
			
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			if(f==0) {
				sb.append(dp[t][al]);
			}else {
				sb.append(dp[t][al]-dp[f-1][al]);
				
			}
			sb.append("\n");
			
			
		}
		System.out.println(sb);
		
	}

}
