package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * Ʋ������ : �ΰ踦 ���ڸ� �ð�������.
 * dfs �ʿ��� cnt == m �϶� ġŲ�Ÿ��� ���Ҷ� �ʱ�ȭ�� �����༭ Ʋ�ȴٰ�
 * �׸��� isVisited �ʱ�ȭ�� ġŲ.add �ϱ����� �ؼ� ArrayIndex ���� ���� ;
 */
public class RV_B15686_ġŲ��� {

	static int n,m;
	static int [][] map;
	static ArrayList<Point> chicken = new ArrayList<>();
	static ArrayList<Point> house= new ArrayList<>();;
	
	static boolean[] isVisited;
	
	static int ans = Integer.MAX_VALUE;
	
	
	public static class Point{
		int x;
		int y;
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map =new int[n][n];
		
		
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) house.add(new Point(i, j));
				if(map[i][j] == 2) chicken.add(new Point(i, j));
			}
		}
		isVisited = new boolean[chicken.size()];
		dfs(0,0);
		System.out.println(ans);
		
	}
	
	public static void dfs(int cnt, int start) {
		if(cnt == m) {
			int sum=0;
			for(int j=0;j<house.size();j++) {
				int min = Integer.MAX_VALUE;
				for(int i=0;i<chicken.size();i++) {
					if(isVisited[i]) {
						int dis = Math.abs(house.get(j).x -chicken.get(i).x)
								+ Math.abs(house.get(j).y -chicken.get(i).y    );
						min = Math.min(min, dis);
					}
				}
				sum += min;
			}
			ans = Math.min(sum, ans);
			return;
		}
		
		for(int i=start;i<chicken.size();i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				dfs(cnt+1,i+1);
				isVisited[i] = false;
			}
		}
		
	}

}
