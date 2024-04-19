package BOJ.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//개스트레스 와 입력값에 j대신 i 넣어서 뭐 틀렸나 다 뒤졌네ㅠ ㅠ
public class B10026_적록색약 {

	static int n,cnt,cnt2;
	static char[][] map,notnm;
	static int [][] normal;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map= new char[n][n]; 
		normal= new int[n][n]; 
		notnm = new char[n][n]; 
		visited = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				char c = s.charAt(j);
				map[i][j] =c;
				if(c == 'G') notnm[i][j] = 'R';
				else
					notnm[i][j] = c;
			}
		}
		System.out.println(Arrays.deepToString(notnm));
		for (char[] aa : map) {
			for (char a : aa) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
		cnt=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j]) {
					System.out.println(i+" / "+j +" ///"+cnt);
					
					bfs(i,j);
					cnt++;
				}
			}
		}
		
		
		for (int[] aa : normal) {
			for (int a : aa) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
		cnt2=0;
		visited = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j]) {
//					System.out.println(cnt);
					bfs2(i,j);
					cnt2++;
				}
			}
		}

		System.out.print(cnt+" "+cnt2);
	}
	
	static void bfs(int x,int y) {
		Queue<int []> que = new LinkedList<int[]>();
		
		que.add(new int[] {x,y});
		
		visited[x][y] = true;
		normal[x][y] = cnt;
		
		while(!que.isEmpty()) {
			int [] now = que.poll();
			char nowc = map[now[0]][now[1]];
			
			for(int k=0;k<4;k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				
				if(nx<0 || nx>=n ||ny <0 ||ny >=n) continue;
				
				if(!visited[nx][ny] && map[nx][ny] == nowc) {
					que.add(new int[] {nx,ny});
					visited[nx][ny] = true;
					normal[nx][ny] = cnt;
				}
				
			}
			
			
		}
		
		
	}
	
	//적녹색약
	static void bfs2(int x,int y) {
		Queue<int []> que = new LinkedList<int[]>();
		
		que.add(new int[] {x,y});
		
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			int [] now = que.poll();
			char nowc = notnm[now[0]][now[1]];
			
			for(int k=0;k<4;k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				
				if(nx<0 || nx>=n ||ny <0 ||ny >=n) continue;
				
				if(!visited[nx][ny] && notnm[nx][ny] == nowc) {
					que.add(new int[] {nx,ny});
					visited[nx][ny] = true;
				}
				
			}
			
			
		}
		
		
	}
	
	

}
