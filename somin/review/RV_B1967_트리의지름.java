package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RV_B1967_트리의지름 {

	static int n;
	static ArrayList<Node>[] list; 
	static boolean[] parents;
	static boolean[] visited;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());

		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		for(int i=0;i<n+1;i++) list[i] = new ArrayList<>();
		parents = new boolean[n+1];
		visited = new boolean[n+1];
		
		for(int i=0;i<n-1;i++) {
			 st = new StringTokenizer(br.readLine());
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 int w = Integer.parseInt(st.nextToken());
			 list[a].add(new Node(b, w));
			 list[b].add(new Node(a, w));
			 //부모노드이면 true
			 parents[a] = true;
		}
//		for(int i=1;i<=n;i++) {
//			System.out.print(i+":");
//			for(Node jj : list[i]) {
//				System.out.print(jj.nextNode+" ");
//			}System.out.println();
//		}
		//1~n까지 반복문 1부터 끝까지 갔을 때 최대값 저장 
		for(int i=1;i<=n;i++) {
			visited = new boolean[n+1];
			dfs(i,0);
		}
		System.out.println(max);
	
	}

	//dfs 
	static void dfs(int idx, int d) {
		if(!parents[idx] && d!=0) { //리프노드여야 retrun = 부모노드면 안돼 + 지름 0일때 return 금지
			
			max = Math.max(max, d);
			return;
		}
		
		visited[idx] = true;
		for(Node nn : list[idx]) {
			if(!visited[nn.nextNode]) {
//				System.out.println(nn.nextNode+" * "+nn.w+" /"+d);
				dfs(nn.nextNode,d+nn.w);
				
			}
		}
		
	}
	static class Node{
		int nextNode;
		int w;
		Node(int nextNode, int w){
			this.nextNode=nextNode;
			this.w=w;
		}
	}
}
