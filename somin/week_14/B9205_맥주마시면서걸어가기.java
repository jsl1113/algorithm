package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * ���� �ѹڽ� = ���� 20��
 * 50���� �� �Ѻ� ( 50���� ������ �� ���� ���� �Ѻ��� ���ž���.)
 * �������� �鸱�� �� ������ �����ֺ� ���(���ִ� �ִ� 20�� �������������ִ�)
 * �������� ���� ���Ŀ��� 50���͸� �������� �����Ѻ� ���ž���
 * �Ÿ� ����� x��ǥ ���� + y��ǥ ����
 */
public class B9205_���ָ��ø鼭�ɾ�� {

	static int n;
	static Point [] convin;
	static Point home;
	static Point festival;
	static boolean ans = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int k=0;k<t;k++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			home = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), 20);
			
			convin = new Point[n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				convin[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				
			}
			
			st = new StringTokenizer(br.readLine());
			
			festival = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			ans = false;
			bfs();
			if(ans) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		
	}
	public static void bfs() {
		Queue<Point> que = new LinkedList<>();
		boolean [] visited = new boolean[n];
		que.add(home);
		
		while(!que.isEmpty()) {
			Point now = que.poll();
			int x = now.x;
			int y = now.y;
			
			
			if(dist(now, festival)<=50*20) {
				ans = true;
				break;
			}
			for(int i=0;i<n;i++) {
				if(!visited[i]) {
					if(dist(now, convin[i])<=50*20) {
						
						visited[i] = true;
						que.add(convin[i]);
					}
				}
			}
		}
	}
	public static int dist(Point a, Point b) {
		
		return Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
	}
	public static class Point{
		int x;
		int y;
		int bottle;
		
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
		
		Point(int x,int y, int bottle){
			this.x=x;
			this.y=y;
			this.bottle=bottle;
		}
	}

}
