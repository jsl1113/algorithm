package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 연합국들을 어레이 리스트에 넣으니까 쉽게 풀렸다..
 */
public class B16234_인구이동 {

	static int n,l,R;
	static int[][] map;
	static boolean[][] visited;
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,-1,1};
	
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n =Integer.parseInt(st.nextToken()); 
		l =Integer.parseInt(st.nextToken()); 
		R =Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		System.out.println(Arrays.deepToString(map));
		
		while(true) {
			
			boolean have = false;
			visited = new boolean[n][n];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!visited[i][j] &&check(i,j)) {
						have = true;
					}
				}
			}
			
			//연합 없으면 
			if(!have) break;
			
			ans++;

			
		}
		
		System.out.println(ans);
	}
	
	static boolean check(int r, int c) {
		
		Queue<Point> que = new LinkedList<>();
		ArrayList<Point> list = new ArrayList<>();
		int sum = map[r][c];
		visited[r][c] = true;
		que.add(new Point(r, c));
		list.add(new Point(r, c));
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			for(int k=0;k<4;k++) {
				int nx = p.r +dx[k];
				int ny = p.c +dy[k];
				
				if(nx<0 || nx>=n ||ny<0||ny>=n || visited[nx][ny]) continue;

				int di = Math.abs(map[p.r][p.c] - map[nx][ny]);
				
				if(di >= l && di <=R) {
					visited[nx][ny] = true;
					que.add(new Point(nx, ny));
					list.add(new Point(nx, ny));
					sum+= map[nx][ny];
				}
			}
			
			
		}
		
		//없으면 
		if(list.size()==1) return false;
		
		//연합국들 평균
		for(Point lst :list) {
			map[lst.r][lst.c] = sum / list.size();
		}
		
		return true;
	}
	
	static class Point{
		int r;
		int c;
		public Point(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}

}
