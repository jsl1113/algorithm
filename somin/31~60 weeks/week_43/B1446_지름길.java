import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class B1446_Áö¸§±æ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[d+1];
		for(int i=0;i<d+1;i++) dp[i] = Integer.MAX_VALUE;
		
		int max = 0;
		Map<Integer, Drive> map = new HashMap<>();
		
		List<Drive>[] list = new ArrayList[10001];
		for(int i=0;i<10001;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<n;i++) {
			String[] x = br.readLine().split(" ");
			int s = Integer.parseInt(x[0]);
			int e = Integer.parseInt(x[1]);
			int shortcut = Integer.parseInt(x[2]);

			if(e>d) {
				continue;
			}
			
			if( (e-s)<shortcut ) { 
				continue;
			}
			
			list[e].add(new Drive(s, e, shortcut));
		}

		dp[0] = 0;
		for(int i=1;i<=d;i++) {
			if(list[i].size()>0) {
				for(Drive dr: list[i]) {
					if(dp[dr.s]+dr.shortcut>dp[i]) continue;
					dp[i] = Math.min(dp[dr.s] + dr.shortcut, dp[i-1]+1);
				}
			}else {
				dp[i] = Math.min(dp[i], dp[i-1]+1);
				
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[d]);
		
	}

	static class Drive{
		int s; int e; int shortcut;

		public Drive(int s, int e, int shortcut) {
			this.s = s;
			this.e = e;
			this.shortcut = shortcut;
		}
		
	}
}
