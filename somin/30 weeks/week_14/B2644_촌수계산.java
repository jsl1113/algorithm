package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2644_ÃÌ¼ö°è»ê {

	static int n;
	static int[] ans;
	static ArrayList<Integer>[] fam;
	static int result = -1;

	
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		fam = new ArrayList[n+1];
		for(int i=0;i<n+1;i++) {
			fam[i] = new ArrayList<Integer>();
		}
		visited = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ans = new int[2];
		for(int i=0;i<2;i++) {
			ans[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			fam[a].add(b);
			fam[b].add(a);
		}
		
//		System.out.println(Arrays.toString(fam));
		dfs(ans[0], 0, ans[1]);
		System.out.println(result);
	}
	public static void dfs(int a, int cnt, int another) {
		if(a == another) {
			result = cnt;
			return;
		}
		visited[a] = true;
		for(int aa : fam[a]) {
			if(!visited[aa]) {
				dfs(aa,cnt+1,another);
			}
		}
		
	}
	

}
