package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17144_미세먼지안녕 {

	static int r,c,t,m1,m2;
	static int[][] map;
	static Queue<Point> queue;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		
		boolean flag = false;
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					if(!flag) {
						m1 = i;
						flag = true;
					}else {
						m2 = i;
					}
				}
			}
		}
		
		
		for(int i=0;i<t;i++) {
			
			spread();
			air();
			
//			for(int a[] : map) {
//				for(int j : a) {
//					System.out.print(j+" ");
//				}System.out.println();
//			}
		}
		
		int ans = 0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]==-1) continue;
				ans+= map[i][j];
			}
		}
		System.out.println(ans);
	}

	static void air() {
		
		//m1 먼저 (윗부분)
		//위에서 아래로
		for(int i=m1-1;i>=1;i--) {
			map[i][0] = map[i-1][0];
		}
		//오른쪽에서 왼쪽으로
		for(int i=0;i<c-1;i++) {
			map[0][i] = map[0][i+1];
		}
		//아래서 위로
		for(int i=0;i<m1;i++) {
			map[i][c-1] = map[i+1][c-1];
		}
		//왼쪽에서 오른쪽으로
		for(int i=c-1;i>=2;i--) {
			map[m1][i] = map[m1][i-1];
		}
		map[m1][1] = 0;
		
		
		//아래에서 위로
		for(int i=m2+1;i<r-1;i++) {
			map[i][0] = map[i+1][0];
		}
		//오른쪽에서 왼쪽으로
		for(int i=0;i<c-1;i++) {
			map[r-1][i] = map[r-1][i+1];
		}
		//위에서 아래로
		for(int i=r-1;i>=m2+1;i--) {
			map[i][c-1] = map[i-1][c-1];
		}
		//왼쪽에서 오른쪽으로
		for(int i=c-1;i>=2;i--) {
			map[m2][i] = map[m2][i-1];
		}
		map[m2][1] = 0;
	}
	
	static void spread() {
		
		queue = new LinkedList<>();
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]==-1 || map[i][j]==0) continue;
				queue.add(new Point(i, j, map[i][j]));
			}
		}
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			if(now.dust<5) continue;
			
			int cnt=0;
			//4방향으로 퍼짐
			for(int k=0;k<4;k++) {
				int nx = now.x + dx[k];
				int ny = now.y + dy[k];
				
				if(nx <0 || ny <0 || nx >=r ||ny>=c) continue;
				//공기청정기가 있는 자리면
				if(map[nx][ny] == -1) continue;
				map[nx][ny] += now.dust/5;
				cnt++;
			}
			//남은 미세먼지는   now.dust/5 * cnt의 개수
			map[now.x][now.y] -= (now.dust/5) * cnt;
			
		}
		
	}

	static class Point{
		int x;
		int y;
		int dust;
		Point(int x,int y,int dust){
			this.x=x;
			this.y=y;
			this.dust=dust;
		}
	}

}
