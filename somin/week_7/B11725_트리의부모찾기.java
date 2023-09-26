package BOJ.graph_traversal;
/*
 * �׷��� Ž�� , Ʈ��, BFS, DFS
 * ���: ù° �ٺ��� N-1���� �ٿ� 
 * 		�� ����� �θ� ��� ��ȣ�� 2�� ������ ������� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11725_Ʈ���Ǻθ�ã�� {

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
	
	//�ʺ�켱Ž�� - ť?
	//1�� �ڽ��� �־�. 
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
