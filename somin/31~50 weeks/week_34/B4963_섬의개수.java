import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4963_¼¶ÀÇ°³¼ö {

	
	static int w,h;
	static boolean [][] visit;
	static int[] dx = {-1,1,0,0,-1,1,1,-1};
	static int[] dy = {0,0,-1,1,-1,1,-1,1};
	static int ans=0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());

		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break;
			
			int [][] map = new int[h][w];
			
			visit = new boolean[h][w];
			
			ans=0;
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			func(map);
		}
		System.out.println(sb);
		
	}
	
	static void func(int[][] map) {
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(!visit[i][j] && map[i][j]==1) {
					bfs(map,i,j);
					ans++;
				}
			}
		}
		
		sb.append(ans+"\n");
		
	}
	
	static void bfs(int[][] map , int x, int y) {
		
		visit[x][y] = true;
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[]{x,y});
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int k=0;k<8;k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				
				if(nx<0 || nx>=h || ny<0 || ny>=w) continue;
				
				if(!visit[nx][ny] && map[nx][ny]==1) {
					que.add(new int[] {nx,ny});
					visit[nx][ny] = true;
				}
				
			}
			
			
		}
		
	}

}
