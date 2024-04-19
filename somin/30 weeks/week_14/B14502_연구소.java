package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502_연구소 {

	static int n,m;
	static int[][] map;
	static int[][] virus;
	static int[] dx= {-1,1,0,0}; 
	static int[] dy= {0,0,-1,1};
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(max);
		
	}
	//벽 세우기 dfs 3
	public static void dfs(int cnt) {
		if(cnt == 3) {
			bfs();
			return;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					dfs(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	//바이러스 bfs
	public static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		virus = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				virus[i][j] = map[i][j];
				if(virus[i][j]==2) {
					que.add(new int[] {i,j});
				}
			}
		}
		
		while(!que.isEmpty()) {
			int [] now = que.poll();
			for(int k=0;k<4;k++) {
				int nx = now[0]+dx[k];
				int ny = now[1]+dy[k];
				
				if(nx<0 || ny<0 || nx>=n || ny>=m ) continue;
				if(virus[nx][ny]==0) {
					virus[nx][ny] = 2;
					que.add(new int[] {nx,ny});
				}
			}
			
		}
		int cnt=0;
		for(int []a : virus) {
			for(int status : a ) {
				if(status==0) cnt++;
			}
		}
		max = Math.max(cnt, max);
		
		
	}
	

}
