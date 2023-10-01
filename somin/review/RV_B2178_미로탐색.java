package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RV_B2178_미로탐색 {

	static int n,m;
	static int[][] map;
	static boolean[][] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		isVisited = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
//			String[] s = br.readLine().split("");
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] =s.charAt(j) - '0';
//				System.out.print(map[n][m]);
			}
		}
		
		

		bfs(0,0);
		System.out.println(Arrays.deepToString(map));
		System.out.println(map[n-1][m-1]);
	}
	
	
	public static void bfs(int x,int y) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(x, y));
		isVisited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			int[]dx= {-1,1,0,0};
			int[]dy= {0,0,-1,1};
			
			for(int k=0;k<4;k++) {
				int nx = now.x + dx[k];
				int ny = now.y + dy[k];
				
				//안할 조건 (범위가 아니고 / 0이고 / 방문했었고 )
				if(nx<0 || ny<0 ||nx>=n || ny>=m
						|| map[nx][ny]==0
						|| isVisited[nx][ny] )continue;
				
				map[nx][ny] = map[now.x][now.y]+1;
				isVisited[nx][ny] = true;
				queue.add(new Point(nx,ny));
				
			}
			
		}
		
	}

}
class Point{
	int x;
	int y;
	Point(int x,int y){
		this.x=x;
		this.y=y;
	}
}
