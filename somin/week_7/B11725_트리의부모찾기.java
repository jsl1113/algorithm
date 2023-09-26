package BOJ.graph_traversal;
/*
 * 그래프 탐색 , 트리, BFS, DFS
 * 출력: 첫째 줄부터 N-1개의 줄에 
 * 		각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11725_트리의부모찾기 {

	static int n;
	static ArrayList<Integer>[]tree;

	static int[] parent;
	static boolean [] isVisited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		
		tree = new ArrayList[n+1];

		parent = new int[n+1];
		isVisited = new boolean[n+1];
		
		for(int i=0;i<n+1;i++) tree[i] = new ArrayList<Integer>();
		
		
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			tree[u].add(v);
			tree[v].add(u);
		}
		
//		System.out.println(Arrays.deepToString(tree));

		bfs(1);
		for(int i=2;i<n+1;i++) {
			System.out.println(parent[i]);
		}
		
	}
	
	//너비우선탐색 - 큐?
	//1의 자식을 넣어. 
	public static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int a: tree[i]) {
			queue.add(a);
			parent[a] = 1;
		}
		
		isVisited[i] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int a:tree[now]) {
				if(!isVisited[a]) {
					queue.add(a);  
					parent[a] = now;
				}
			}
			isVisited[now] = true;
		}
		
		
	}

}
