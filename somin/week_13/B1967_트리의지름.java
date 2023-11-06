package BOJ.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 지름 구하는 방법은 리프노드까지 가중치 최댓값
 */
public class B1967_트리의지름 {

	static int n;
	static ArrayList<Node> [] list;

	static boolean [] notLeaf;
	static boolean [] visited;
	static int max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];

		notLeaf = new boolean[n+1];
		for(int i=0;i<n+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
	
			notLeaf[a] = true;
		}
		
		for(int i=1;i<=n;i++) {
			visited = new boolean[n+1];
			dfs(i,0);
		}
		System.out.println(max);
	}
	public static void dfs(int now, int d) {
		
		if(!notLeaf[now] && d!=0) {
			max = Math.max(max, d);
			
			return;
		}
		
		visited[now] = true;
		for(Node nn : list[now]) {
			if(!visited[nn.child]) {
				dfs(nn.child,d+nn.weight);
			}
		}
		
	}
	
	public static class Node{
		int child;
		int weight;
		Node(int child,int weight){
			this.child=child;
			this.weight=weight;
		}
	}

}
