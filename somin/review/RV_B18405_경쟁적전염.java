package review.w14Over;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class RV_B18405_경쟁적전염 {

	static int n,k,s,x,y;
	static int [][] map ;
	static boolean [][] visit;
	static PriorityQueue<Point> que = new PriorityQueue<>(1,new Points()); //틀린이유 (1,new Points()) 안써서; 
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		//1~k 번까지의 바이러스 종류
		
		map = new int [n][n];
		visit = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) {
					que.add(new Point(i, j, map[i][j], 0));
					visit[i][j] = true;
				}
			}
		}
		//1,2,3,... 순서대로 큐에 넣어주기 (우선순위큐)
		
	
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		
			
		bfs();
	}
	
	static void bfs() {
		
		while(!que.isEmpty()) {
			
			Point point = que.poll();
			
			if(point.time >s) {// 시간이 s초 초과했는데도 x,y visit안했으면 0
				System.out.println(0);
				return;
			}
			
			//x,y 일 때
			if(point.x == x-1 && point.y == y-1 && visit[x-1][y-1] ) { 
				System.out.println(point.val);
				return;
			}
			
			for(int k=0;k<4;k++) {
				int nx = point.x + dx[k];
				int ny = point.y + dy[k];
				
				if(nx < 0 || nx>=n || ny < 0 || ny >=n || visit[nx][ny]) {
					continue;
				}
				
				visit[nx][ny] = true;
				map[nx][ny] = point.val;
				que.add(new Point(nx, ny, point.val, point.time+1));
			}
			
		}
		
	}
	

}

class Point {
	int x,y,val,time;
	
	Point(int x, int y, int val, int time) {
		this.x = x;
		this.y = y;
		this.val = val;
		this.time = time;
	}
	
	
}
class Points implements Comparator<Point>{
	
	@Override
	public int compare(Point p, Point p2) {
		
		if(p2.time!= p.time) { //시간 작은 순
			return p.time-p2.time;
		}else { // 바이러스 번호 작은 것부터
			return p.val - p2.val;
		}
	}
	
}

