package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2302_±ÿ¿Â¡¬ºÆ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int [] dp = new int[41];
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++) {
			int v = Integer.parseInt(br.readLine());
			
			list.add(v);
		}
		dp[1] = 1; dp[2] = 2;
		for(int i=3;i<=n;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		if(m==0) {
			System.out.println(dp[n]);
			return;
		}else if(m==1) { // µŒ∞≥∑Œ ≥™¥∏.
			int a = list.get(0)-1;
			int b = n- list.get(0);
			System.out.println(dp[a]*dp[b]);
			return;
		}else {
			ArrayList<Integer> nums = new ArrayList<Integer>();
			nums.add(list.get(0)-1);
			for(int i=1;i<list.size();i++) {
				int num = list.get(i)-list.get(i-1)-1;
				nums.add(num);
				if(i==list.size()-1) {
					int a = n - list.get(i);
					nums.add(a);
				}
			}
//			System.out.println(nums);
			int ans = 1;
			for(int nn :nums) {
				if(nn==0) continue;
				ans*=dp[nn];
			}
			
			System.out.println(ans);
		}
		
		
		
	}

}
