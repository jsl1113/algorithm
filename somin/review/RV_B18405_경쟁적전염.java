package review.w14Over;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class RV_B18405_���������� {

	static int n,k,s,x,y;
	static int [][] map ;
	static boolean [][] visit;
	static PriorityQueue<Point> que = new PriorityQueue<>(1,new Points()); //Ʋ������ (1,new Points()) �ȽἭ; 
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		//1~k �������� ���̷��� ����
		
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
		//1,2,3,... ������� ť�� �־��ֱ� (�켱����ť)
		
	
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		
			
		bfs();
	}
	
	static void bfs() {
		
		while(!que.isEmpty()) {
			
			Point point = que.poll();
			
			if(point.time >s) {// �ð��� s�� �ʰ��ߴµ��� x,y visit�������� 0
				System.out.println(0);
				return;
			}
			
			//x,y �� ��
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
		
		if(p2.time!= p.time) { //�ð� ���� ��
			return p.time-p2.time;
		}else { // ���̷��� ��ȣ ���� �ͺ���
			return p.val - p2.val;
		}
	}
	
}

