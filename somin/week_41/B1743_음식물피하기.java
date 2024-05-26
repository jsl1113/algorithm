import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1743_음식물피하기 {

	static int n,m,k;
	static int [][] map;
	static boolean [][] visit;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int ans = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int [n][m];
		visit = new boolean[n][m];
		
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x-1][y-1] = 1;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==1 && !visit[i][j]) {
					bfs(i, j);
				}
			}
		}
		System.out.println(ans);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {x,y});
		visit[x][y] = true;
		
		int cnt = 1;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int k=0;k<4;k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				
				if(nx<0 || nx>=n|| ny<0 ||ny>=m || visit[nx][ny] ) continue;
				
				if(map[nx][ny] == 1) {
					visit[nx][ny] = true;
					cnt++;
					que.add(new int[] {nx,ny});
				}
				
			}
		}
		ans = Math.max(ans, cnt);	
	}
}
