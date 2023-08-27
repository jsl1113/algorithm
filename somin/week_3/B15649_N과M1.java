package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15649_N과M1 {

	static int n,m;
	static boolean [] Visited;
	static ArrayList<Integer> ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		Visited = new boolean[n];
		ans = new ArrayList<Integer>();
		dfs(0);

	}
	
	public static void dfs(int cnt) {
		if(cnt==m) {
			for(int i :ans) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		//순열 (순서가 다르면 다른 것) 
		for(int i=0;i<n;i++) {
			if(!Visited[i]) {
				Visited[i] = true;
				ans.add(i+1);
				dfs(cnt+1);
				Visited[i] = false;
				ans.remove(Integer.valueOf(i+1));
			}
			
		}
	}

}
