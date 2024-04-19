package BOJ.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_DFS와BFS {

	static int n,m,v;
	static ArrayList<Integer>[] graph;
	static boolean [] isVisited;
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		for(int i=0;i<n+1;i++) graph[i] = new ArrayList<Integer>();
		
		isVisited = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
			
		}
//		System.out.println(Arrays.deepToString(graph));
		for(int i=1;i<n+1;i++) {
			Collections.sort(graph[i]);
		}

//		System.out.println(Arrays.deepToString(graph));
		
		ans.add(v);
		dfs(v);
		for(int i:ans) System.out.print(i+" ");
		System.out.println();
		
		
		ans = new ArrayList<Integer>();
		isVisited = new boolean[n+1];

		ans.add(v);
		bfs(v);
	}

	public static void dfs(int i) {
		
		for(int a:graph[i]) {
			if(i == v) isVisited[i] = true;
			if(!isVisited[a]) {
				isVisited[a] = true;
				ans.add(a);
				dfs(a);
			}
		}
		
	}
	
	//que를 통해 들어온 순서를 기억할 수 있다. 좋은 생각이구나 
	//이부분을 몰라서 참고했다.. bfs는 큐 활용하기! 
	public static void bfs(int i) {
		
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(i);
		isVisited[i] = true;
		
		while(!que.isEmpty()) {
			int a = que.poll();
			System.out.print(a+" ");
			for(int j:graph[a]) {
				if(!isVisited[j]) {
					que.add(j);
					isVisited[j] =true;					
				}
			}
			
		}
		
		
	}
}
