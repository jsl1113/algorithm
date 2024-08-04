import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753_최단경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(br.readLine());
		
		boolean[] visit = new boolean[V+1];
		int[] ans = new int[V+1];
		ArrayList<Node>[] lst = new ArrayList[V+1];
		
		for(int i=0;i<=V;i++) {
			ans[i] = Integer.MAX_VALUE;
			lst[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			lst[u].add(new Node(v, w));
		}
		
		//다익스트라 최단거리 
		PriorityQueue<Node> que = new PriorityQueue<>((a,b) -> a.w - b.w);
		ans[k] = 0;
		que.add(new Node(k, 0));
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			if(!visit[now.end]) {
				visit[now.end] = true;
			}
			
			for(int i=0;i<lst[now.end].size();i++) {
				Node nx = lst[now.end].get(i);
				//                 현재 가중치 + 다음 가중치 < 지금까지보다 최단경로면 
				if(!visit[nx.end] && (now.w + nx.w)<ans[nx.end] ) {
					ans[nx.end] = now.w + nx.w;
					que.add(new Node(nx.end, ans[nx.end]));
				}
			}
		}
		for(int i=1;i<=V;i++) {
			if(ans[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(ans[i]);
			}
			
		}
		
		
	}
	
	static class Node{
		int end; int w;

		public Node(int end, int w) {
			this.end = end;
			this.w = w;
		}
		
	}

}
