import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1926_±×¸² {

	static int n,m;
	static int[][] map;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int ans = 0;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int pic = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==1 && !visit[i][j]) {
					bfs(i, j);
					pic++;
				}
			}
		}
		System.out.println(pic);
		System.out.println(ans);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		
		que.add(new int[] {x,y});
		visit[x][y] = true;
		
		int cnt = 1;
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int i=0;i<4;i++) {
				int nx = now[0] +dx[i];
				int ny = now[1] +dy[i];
				
				if(nx < 0 || nx >=n || ny <0 || ny>=m || visit[nx][ny]) continue;
				
				if(map[nx][ny]==1) {
					que.add(new int[] {nx,ny});
					visit[nx][ny] = true;
					cnt++;
					
				}
			}
		}
		
		ans = Math.max(ans, cnt);
	}
	

}
