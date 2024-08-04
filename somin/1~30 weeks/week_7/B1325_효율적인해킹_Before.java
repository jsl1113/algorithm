package BOJ.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1325_효율적인해킹_Before {

	static int n,m;
	static int cnt=0;
	static ArrayList<Integer> [] graph;
	static boolean[] isVisited;
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());

		graph = new ArrayList[n+1];
		isVisited = new boolean [n+1];
		ans = new int [n+1];
		
		for(int i=0;i<n+1;i++) graph[i] = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[v].add(u);
		}
//		System.out.println(Arrays.deepToString(graph));


		int max = 0;
		for(int i=1;i<n+1;i++) {
			isVisited = new boolean [n+1];
			cnt=0;
			dfs(i);
			ans[i] = cnt;
			max = Math.max(max, cnt);
		}
//		System.out.println(Arrays.toString(ans));
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<n+1;i++) {
//			bfs(i);
			if(ans[i]==max) {
//				System.out.print(i+" ");
				sb.append(i+" ");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int i) {
		
		for(int a:graph[i]) {
			if(!isVisited[a]) {
				isVisited[a] =true;
				dfs(a);
				cnt++;
				
			}
		}
		
	}
	public static void bfs(int i) {
		Queue<Integer> que = new LinkedList<Integer>();
		for(int a: graph[i]) {
			que.add(a);
			isVisited[a] = true;
		}
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			if(!isVisited[now]) continue;
			
			ans[now]++;
			
		}
		
	}

}
