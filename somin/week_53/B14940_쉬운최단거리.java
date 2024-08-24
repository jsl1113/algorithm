import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14940_쉬운최단거리 {

	static int n,m;
	static int[][] map,ans;
	static boolean[][] visit;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		ans = new int[n][m];
		visit = new boolean[n][m];
		int x=0,y=0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					x = i; y = j;
				}else if(map[i][j]==0) {
					visit[i][j] = true;
				}
			}
		}
		bfs(x,y);

		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visit[i][j]) {
					ans[i][j] = -1;
				}
				sb.append(ans[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void bfs(int x,int y) {
		
		Queue<int[]> que = new LinkedList<int[]>();
		
		visit[x][y] = true;
		que.add(new int[] {x,y});
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			for(int k=0;k<4;k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				
				if(nx<0 || nx>=n || ny<0 || ny>=m || visit[nx][ny]) continue;
				
				if(map[nx][ny]==1) {
					visit[nx][ny] = true;
					ans[nx][ny] = ans[now[0]][now[1]]+1;
					que.add(new int[] {nx,ny});
				}
				
			}
		}
		
	}

}
