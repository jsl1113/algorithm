package BOJ.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * bfs�� �ᱹ �����߰�
 * �׳��� before���� ��� �����ߴ� dfs�� Ǯ����..
 * �߸��� �κ��� B�� A�� �߰��ߴµ� �ݴ�� A�� B�� �߰��ؾ��߰�
 * �׷��� visited üũ�� for�� �ۿ��� ���ָ� �ƴ�..! 
 */
public class B1325_ȿ��������ŷ_After {

	static int n,m;

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
		
		for(int i=1;i<n+1;i++) graph[i] = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
		}
//		System.out.println(Arrays.deepToString(graph));


		for(int i=1;i<n+1;i++) {
			isVisited = new boolean[n+1];
			dfs(i);
//			bfs(i);
//			if(ans[i]==max) System.out.print(i+" ");
		}
		
		int max = 0;
		for(int a:ans) {
			if(max<a) max = a;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<n+1;i++) {
			if(max==ans[i]) {
//				System.out.print(i+" ");
				sb.append(i+" ");
			}
		}
		System.out.println(sb.toString());
	}
	public static void dfs(int r) {
		isVisited[r] = true;
		
		for(int n: graph[r]) {
			if(!isVisited[n]) {
				ans[n]++;
				dfs(n);
			}
		}
	}

	public static void bfs(int r) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(r);
		isVisited[r] = true;
				
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int n : graph[now]) {
				if(!isVisited[n]) continue;
				ans[n]++;
				isVisited[n] = true;
				ans[n]++;
				que.add(n);
			}
		
		}
		
	}

}
