package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class RV_B1260_DFS¿ÍBFS {

	static int n,m,v;
	static ArrayList<Integer>[] graph; 
	static boolean [] isVisited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[n+1];
		graph =new ArrayList[n+1];
		for(int i=0;i<n+1;i++) graph[i] = new ArrayList<Integer>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
	
		for(int i=0;i<n+1;i++)Collections.sort(graph[i]);
		
		//dfs
		sb.append(v+" ");
		dfs(v);
		System.out.println(sb);
		
		sb = new StringBuilder();
		isVisited = new boolean [n+1];
		//bfs
		
		bfs(v);
		System.out.println(sb);
	}
	
	public static void dfs(int idx) {
		isVisited[idx]=true;
		for(int now : graph[idx]) {
			if(!isVisited[now]) {
				isVisited[now] = true;
				sb.append(now+" ");
				dfs(now);
			}
		}
		
		
	}
	
	public static void bfs(int idx) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(idx);
		isVisited[idx] = true;


		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int n : graph[now]) {
				if(!isVisited[n]) {
					isVisited[n] = true;
					queue.add(n);
				}
			}
			sb.append(now+" ");
	
		}
		
	}
	

}
