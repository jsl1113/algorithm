package programmers.sql;

import java.util.Arrays;

public class P87946_ÇÇ·Îµµ {

	static boolean [] visited;
	static int [] ans;
	static int result =0;
	static int solution(int k, int[][] dungeons) {
		
		Arrays.sort(dungeons, (a,b)-> a[0]==b[0] ? a[1]-b[1] : b[0]-a[0] );
		System.out.println(Arrays.deepToString(dungeons));
		
		int len = dungeons.length;
		visited = new boolean[len];
		ans = new int [len];
		dfs(0,len,dungeons,k);
		return result;
	}
	
	static void dfs(int cnt, int len, int[][] dun,int k) {
		if(cnt ==len) {
			System.out.println(Arrays.toString(ans));
		
			result = Math.max(result, howMany(ans, dun, k));
			return;
		}
		
		for(int i=0;i<len;i++) {
			if(!visited[i]) {
				visited[i] = true;
				ans[cnt] = i;
				dfs(cnt+1,len,dun,k);
				visited[i] = false;
			}
			
		}
		
	}
	
	static int howMany(int[] ans, int[][]dun, int k) {
		int cnt=0;
		for(int i=0;i<ans.length;i++) {
			int num = ans[i];
			
			int before = dun[num][0];
			int after = dun[num][1];
			
			if(k<before) return cnt;
			k-=after;
			if(k<0) return cnt;
			
			cnt++;
			
		}
		return cnt;
		
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(solution(80, new int[][]{{50, 40}, {80, 20}, {30, 10}}));
//		System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
		
		
	}
	
}