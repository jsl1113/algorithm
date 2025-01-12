import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11724_연결요소의개수 {

	static ArrayList<Integer>[] list;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		visit =new boolean[n+1];
		list = new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st= new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		
		/*
		 * 푸는 방법: bfs로 1부터 n까지 다 지나가야 끝남.
		 */
		int cnt = 0;
		for(int i=1;i<=n;i++) {
			if(!visit[i]) {
				visit[i] = true;
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

	
	static void bfs(int num) {
		Queue<Integer> que = new LinkedList<Integer>();
		for(Integer aa : list[num]) {
			que.add(aa);
		}
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			if(visit[now]) {
				continue;
			}
			for(Integer aa : list[now]) {
				que.add(aa);
			}
			visit[now] = true;
		}
	}
}
