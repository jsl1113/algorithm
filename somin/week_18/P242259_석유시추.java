package programmers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class P242259_석유시추 {

	static int n,m,cnt;
	static boolean[][] visited;
	static int[][] map;
	static int ans=0;
	static ArrayList<Integer> an = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
//		int [][] land = {
//                {0, 0, 0, 1, 1, 1, 0, 0},
//                {0, 0, 0, 0, 1, 1, 0, 0},
//                {1, 1, 0, 0, 0, 1, 1, 0},
//                {1, 1, 1, 0, 0, 0, 0, 0},
//                {1, 1, 1, 0, 0, 0, 1, 1}
//        };
		
		int [][] land = {
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1}
        };
		
		n = land.length;
		m = land[0].length;
		
		visited = new boolean[n][m];
		map = new int[n][m];
		cnt =1;
		an.add(0);
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visited[i][j]) {
					if(land[i][j]==1) {
						bfs(land,i,j);
					}
				}
			}
		}
		
			
		for(int j=0;j<m;j++) {
			Set<Integer> ss = new HashSet<Integer>();
			for(int i=0;i<n;i++) {
				if(map[i][j]==0) continue;
				
				ss.add(map[i][j]);
			}
			int sum = 0;
			for(int st :ss ) {
				sum+= an.get(st);
			}
//			System.out.println(j +" /./ "+sum+" /./ "+ss);
			ans = Math.max(ans,sum );
		}
		
		System.out.println(ans);
		
	}
	
	static void bfs(int [][] land, int x,int y) {
		
		int [] dx = {-1,1,0,0};
		int [] dy = {0,0,-1,1};
		
		Queue<int[]> que = new LinkedList<>();
		
		que.add(new int[] {x,y});
		visited[x][y] = true;
		map[x][y] = cnt;
		int cntC = 1;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int k=0;k<4;k++) {
				int nx = now[0]+ dx[k];
				int ny = now[1]+ dy[k];
				
				if(nx<0 || nx>=n || ny<0 || ny>=m || visited[nx][ny]) continue;
				
				if(land[nx][ny]==1) {
					que.add(new int[] {nx,ny});
					visited[nx][ny]= true;
					map[nx][ny] = cnt;
					cntC++;
				}
				
			}
		}
		an.add(cntC);
		cnt++;
		
	}

}
