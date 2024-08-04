package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14503_로봇청소기 {

	static int n,m,d;
	static int r,c,ans=1;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());			
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}

		robot(r, c, d);
		
		int cnt=0;
		for(int i=0;i<n;i++) {	
			for(int j=0;j<m;j++) {
				if(map[i][j]==2) cnt++;
			}
		}
		System.out.println(cnt);
//		System.out.println(ans);
//		
//		for(int[] i : map) {
//			for(int j : i) {
//				System.out.print(j+" ");
//			}System.out.println();
//		}
	}
	
	public static void robot(int x, int y, int d) {
		
		map[x][y] = 2; //2 = 청소
	
		
		for(int i=0;i<4;i++) {
			d = (d+3)%4;
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx>=0 && ny>=0 && nx<n && ny<m && map[nx][ny]==0) {
				ans++;
				robot(nx, ny, d);
				return;
			}
		}
		
		//바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
		int dd = (d+2)%4;
		int nx = x + dx[dd];
		int ny = y + dy[dd];
		if(nx>=0 && ny>=0 && nx<n && ny<m && map[nx][ny]!=1) {
			robot(nx, ny, d);
		}
		
		
		
		
	}

}
