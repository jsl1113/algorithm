package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 일단.. 상 좌 우선 코드 구현이 어려웠고
 * while문을 두번 써서 구현하는 것도 생각해내지 못했다.
 * bfs : 상하좌우 dist=0이고 지나갈 수 있는 공간을 다시 큐에 넣기
 * 그 좌표 중 먹을 수 있는 물고기면 ArrayList에 추가하기 (~큐가 빌때까지 반복)
 * 
 * 어레이리스트에 먹을 수 있는 물고기들 존재 -> 좌표로 체크해서 상.좌 우선으로 먹을고기 선택
 * 그 물고기 먹고 dist와 ArrayList는 초기화 (물고기 어레이리스트가 비어있으면 break) 
 * 
 */
public class B16236_아기상어 {

	static int n;
	static int[][] map;

	static ArrayList<Point> list = new ArrayList<>();

	static Queue<int []> que = new LinkedList<>();
	
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0, -1,1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					que.add(new int[] {i,j});
					map[i][j]=0;
				}
			}
		}

		dfs();
		
	}

	
	static void dfs() {
		int ansTime=0;
		int big = 2;
		int eat=0;
		
		while(true) {
			ArrayList<Point> eatFish = new ArrayList<>();
			int [][] dist = new int[n][n];
			
			while(!que.isEmpty()) {
				int[] now = que.poll();
				for(int k=0;k<4;k++) {
					int nx = now[0]+dx[k];
					int ny = now[1]+dy[k];
					
					if(nx<0 || nx >=n || ny<0 ||ny>=n) continue;
					
					if(dist[nx][ny] == 0 && map[nx][ny]<=big) {//지나갈 수 있음
						dist[nx][ny]=dist[now[0]][now[1]]+1;
						que.add(new int[] {nx,ny});
						if(1<=map[nx][ny] && map[nx][ny]<=6 && map[nx][ny] <big	) {
							eatFish.add(new Point(dist[nx][ny], nx, ny));
						}
					}
				}
			}
			
			if(eatFish.size()==0) {
				System.out.println(ansTime);
				return;
			}
			
			Point nowFish = eatFish.get(0);
			for(int i=1;i<eatFish.size();i++) {
				if(nowFish.size > eatFish.get(i).size) {
					nowFish = eatFish.get(i);
				}else if(nowFish.size == eatFish.get(i).size) {
					if(nowFish.x >eatFish.get(i).x) { //좌표 위가 먼저
						nowFish = eatFish.get(i);
					}else if(nowFish.x == eatFish.get(i).x) {
						if(nowFish.y > eatFish.get(i).y) { //좌표 왼쪽 먼저
							nowFish = eatFish.get(i);							
						}
					}
				}
			}
			
			ansTime += nowFish.size;
			eat++;
			map[nowFish.x][nowFish.y] = 0;
			if(eat == big) {
				big++;
				eat=0;
			}
			que.add(new int[] {nowFish.x,nowFish.y});
		}
		
	}
	
	static class Point{
		int size;
		int x;
		int y;
		Point(int size, int x,int y){
			this.size=size;
			this.x=x;
			this.y=y;
		}
	}
	
}
