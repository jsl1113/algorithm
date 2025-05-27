import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18352_특정거리의도시찾기 {

	static int n,m,k,x;
	
	static ArrayList<Integer>[] lst;
	static int[] min_dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		lst = new ArrayList[n+1];
		min_dist = new int[n+1];
		for(int i=0;i<=n;i++) {
			lst[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			lst[a].add(b);
		}
		
		//최단거리
		bfs();
		int cnt=0;
		for(int i=1;i<=n;i++) {
			if(min_dist[i]==k) {
				System.out.println(i);
			}else {
				cnt++;
			}
		}
		if(cnt==n) {
			System.out.println(-1);
		}

	}
	
	//
	static void bfs() {
		Queue<Integer> que = new LinkedList<Integer>();
		boolean[] visit =new boolean[n+1];
		visit[x] = true;
		que.add(x);
		min_dist[x] = 0;
		int dist =1;
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int num :  lst[now]) {
				if(!visit[num]) {
					que.add(num);
					min_dist[num] = Math.min(min_dist[now]+1, (dist+1));
					visit[num] = true;
				}
			}
			dist++;
		}
		
	}
	

}
