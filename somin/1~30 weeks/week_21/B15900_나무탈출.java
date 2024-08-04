package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15900_나무탈출 {

	static int n,a,b;
	static ArrayList<Integer>[] list;
	static int ans =0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		for(int i=0;i<=n;i++) list[i] = new ArrayList<Integer>();
		
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1,-1,0);
		System.out.println((ans%2==0) ? "No":"Yes" );
		
	}
	static void dfs(int now, int parent, int cnt) {
		if(list[now].size()==1 && list[now].get(0) == parent) {//리프노드
			ans+=cnt;
			return;
		}
		
		for(int num : list[now]) {
			if(num != parent) {
				dfs(num,now,cnt+1);
			}
		}
		
	}

}
