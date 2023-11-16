package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2468_안전영역 {

	static int n;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int res=0;
	static int[][] map;
	static int[][] ans;
	static boolean[][] visited;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		

		
		
		for(int v=0;v<max;v++) {
			visited = new boolean[n][n];
			ans = new int[n][n];
			int cnt=0;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(v < map[i][j] ) {
						ans[i][j] = 0;
					}else {
						ans[i][j] = -1;
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(ans[i][j]==0) {
						if(visited[i][j]) continue;
						bfs(i,j,v);
						cnt++;
					}
				}
			}
			
			res = Math.max(cnt, res);
			
		}
		
		System.out.println(res);
		
	}

	static void bfs(int x,int y, int v) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visited[x][y] = true;
	
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			for(int k=0;k<4;k++) {
				int nx = now.x + dx[k];
				int ny = now.y + dy[k];
				
				if(nx<0 ||ny<0 ||nx>=n ||ny>=n ||visited[nx][ny] ||ans[nx][ny]==-1) {
					continue;
				}
				queue.add(new Point(nx, ny));
				visited[nx][ny] = true;
				
			}
			
		}
		
		
	}
	
	static class Point{
		int x;
		int y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}

	
}
