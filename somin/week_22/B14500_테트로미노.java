package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 사실 노가다로 구했는데 잘못구한거를 알았는데 진짜 하나하나 고쳐주기 너무 힘들어서
 * 더 효율적인 방법을 검색했다 dfs를 활용해서 해주면 된다
 * ㅗ 모양은 예외를 두어야한다. 
 */
public class B14500_테트로미노 {

	static int n,m;
	static int[][] map;
	static boolean[][] visited;
	static int area=Integer.MIN_VALUE;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//dfs
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {

				visited[i][j] = true;
				sol(i, j, map[i][j], 1);
				visited[i][j] = false;
				
			}
		}
		
		
		System.out.println(area);
		
	}
	
	public static void sol(int x, int y , int sum , int cnt) {
		if(cnt == 4) {
			area = Math.max(area, sum);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx = x+ dx[i];
			int ny = y+ dy[i];
			
			if(nx<0 || nx>=n || ny<0 || ny>=m) {
				continue;
			}
			
			if(!visited[nx][ny]) {
				if(cnt ==2) {
					visited[nx][ny] = true;
					sol(x, y, sum+map[nx][ny], cnt+1);
					visited[nx][ny] = false;
				}
				
				visited[nx][ny] = true;
				sol(nx, ny, sum+ map[nx][ny], cnt+1);
				visited[nx][ny] = false;
			}
			
		}
		
	}
	
	
}
