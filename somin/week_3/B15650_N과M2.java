package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650_N과M2 {

	static int n,m;
	static boolean [] Visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		Visited = new boolean[n];
		dfs(0, 0);
	}
	
	public static void dfs(int cnt, int idx) {
		if(cnt == m) {
			for(int i=0;i<n;i++) {
				if(Visited[i]) System.out.print(i+1 +" ");
			}
			System.out.println();
			return;
		}
		//중복 제외 ; idx를 매개변수로 가져서 dfs(cnt+1, i+1) 
		for(int i=idx;i<n;i++) {
			if(!Visited[i]) {
				Visited[i] = true;
				dfs(cnt+1, i+1);
				Visited[i] = false;
			}
		}
	}

}
