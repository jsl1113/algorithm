package BOJ.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16139_인간컴퓨터상호작용 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		String[] list = s.split("");
		
		
		int dp[][] = new int[s.length()][26];
		dp[0][list[0].charAt(0)-'a']++;
		for(int i=1;i<s.length();i++) {
			int aa = (list[i].charAt(0)-'a');
			for(int j=0;j<26;j++) {
				dp[i][j] = dp[i-1][j];
			}
			
			dp[i][aa]++;
			
		}
		
		
		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<q;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char l = st.nextToken().charAt(0);
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int num=0;
			if(start>=1) {
				num = dp[end][l-'a']-dp[start-1][l-'a'];
			}else {
				num = dp[end][l-'a'];
			}
//			System.out.println(num);
			sb.append(num+"\n");
			
		}
		System.out.println(sb);
		

		
		
	}

}
