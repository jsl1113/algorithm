import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2589_º¸¹°¼¶ {

	static int n,m;
	static int[][] map;
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean[][] visit;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			String[] s = (br.readLine()).split("");
			for(int j=0;j<m;j++) {
				map[i][j] = 0;
				if(s[j].equals("L")) {
					map[i][j] = 1;
				}
			}
		}


		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) continue;
				visit = new boolean[n][m];
				bfs(i, j);
			}
		}
		System.out.println(ans);
	}
	
	static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(x, y, 0));
		visit[x][y] = true;
		
		while(!que.isEmpty()) {
			Point now = que.poll();
			
			for(int k=0;k<4;k++) {
				int nx = now.x + dx[k];
				int ny = now.y + dy[k];
				
				if(nx <0 || nx >=n || ny<0 || ny>=m ||visit[nx][ny]==true|| map[nx][ny]==0) continue;
				
				visit[nx][ny] = true;
				que.add(new Point(nx, ny, now.cnt+1));
				ans = Math.max(ans, now.cnt+1);
			}
		}
		
	}
	
	static class Point{
		int x;
		int y;
		int cnt;
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}

}
