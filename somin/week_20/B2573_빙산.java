package BOJ.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//지금까지 중에 제일 함수를 많이 만들어서 썼다.
public class B2573_빙산 {

	static int n,m;
	static int [][] map;
	static int [][] next;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		next = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		sol();
		
		
	}
	static void sol() {
		
		int year = 0;
		while(!allMelt()) { //모두가 다 안녹았으면 진행
			
			if(!iceberg(map)) { //두개이상 분리되었다면
				System.out.println(year);
				return;
			}
			year++;
			next = new int[n][m];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]!=0) {
						int cnt = cntZ(i, j, map);
						next[i][j] = (map[i][j] -cnt)<0 ? 0 : map[i][j] -cnt;
					}
				}
			}
			
			map = next;
			
		}
		
		System.out.println(0);
		
	}
	
	//빙산이 두덩어리 이상으로 분리되지 않았니?
	static boolean iceberg(int[][] arr) {
		Queue<int []> que = new LinkedList<int[]>();
		
		boolean[][] visited = new boolean[n][m];
		
		int allcnt =0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]!=0 && allcnt==0) {
					que.add(new int[] {i,j});
					visited[i][j] = true;
				}
				if(map[i][j]!=0) {
					allcnt++;
				}
			}
		}
		
		int ice = 1;
		while(!que.isEmpty()) {
			int [] now = que.poll();
			
			for(int k=0;k<4;k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				
				if(arr[nx][ny]!= 0 && !visited[nx][ny]) {
					que.add(new int[] {nx,ny});
					visited[nx][ny] = true;
					ice++;
				}
				
			}
		}
	
		if(ice == allcnt) return true;
		else
			return false;
	}
	
	static boolean allMelt() {
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]!=0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	static int cntZ(int x,int y, int[][] arr) {
		
		int cnt =0;
		for(int k=0;k<4;k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
			
			if(arr[nx][ny] == 0) cnt++;
			
		}
		
		
		return cnt;
	}
	

}
