import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1012_¿Ø±‚≥ÛπË√ﬂ {

	
	static int n,m;
	static int[][] arr;
	static boolean[][] visit;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int q=0;q<t;q++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			arr = new int[n][m];
			
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				arr[x][y] = 1;
				
			}
			
			visit = new boolean[n][m];
			
			int cnt=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(arr[i][j]==1 && visit[i][j]==false) {
						
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		
		

	}
	
	static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {x,y});
		visit[x][y] = true;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			 for(int i=0;i<4;i++) {
				 int nx = now[0] + dx[i];
				 int ny = now[1] + dy[i];
				 if( nx<0 ||nx>= n || ny<0 || ny>=m || visit[nx][ny] || arr[nx][ny]==0) {
					 continue;
				 }else if(arr[nx][ny]==1) {
					 visit[nx][ny] = true;
					 que.add(new int[] {nx,ny});
				 }
				 
			 }
		}
		
	}

}
