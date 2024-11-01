import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916_최소비용구하기 {

	static ArrayList<Node>[] arr;
	static int ans = Integer.MAX_VALUE;
	static boolean[] visit;
	
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		dist = new int[n+1];
		visit = new boolean[n+1];
		arr = new ArrayList[n+1];
		for(int i=0;i<=n;i++) arr[i] = new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			arr[start].add(new Node(end, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		bfs(start, end);
	}
	
	static void bfs(int start, int end) {
		PriorityQueue<Node> que = new PriorityQueue<Node>();
		que.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			if(now.end == end) {
				System.out.println(now.budget);
				return;
			}
			if(!visit[now.end]) {
				visit[now.end] = true;
				
				for(Node no : arr[now.end]) {
					if(!visit[no.end]) {
						que.add(new Node(no.end, no.budget+now.budget));
					}
				}
			}
			
		}
		
		System.out.println();
		
	}
	
	static class Node implements Comparable<Node>{
		int end;
		int budget;
		public Node(int end, int budget) {
			this.end = end;
			this.budget = budget;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.budget-o.budget;
		}
	}
}

