import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1240_노드사이의거리 {

	static int n,m;
	static ArrayList<Node>[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		for(int i=0;i<=n;i++) arr[i] = new ArrayList<>();
		
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			arr[a].add(new Node(b, d));
			arr[b].add(new Node(a, d));
		}
		
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			visit = new boolean[n+1];
			visit[a] = true;
			dfs(a, b, 0);
		}
		
	}
	static void dfs(int now, int find, int sum) {
		if(now == find) {
			System.out.println(sum);
			return;
		}
		
		for(Node aa : arr[now]) {
			if(!visit[aa.end]) {
				visit[aa.end] = true;
				dfs(aa.end, find, sum+aa.dist);
				visit[aa.end] = false;
			}
		}
	}
	
	static class Node{
		int end;
		int dist;
		
		Node(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}
		
	}

}
