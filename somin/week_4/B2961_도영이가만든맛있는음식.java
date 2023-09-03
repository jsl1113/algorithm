package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2961_�����̰�������ִ����� {

	static int n;
	static ArrayList<Point> ingredient = new ArrayList<>();
	static boolean [] isVisited;
	static int sum = Integer.MAX_VALUE;
	
	public static class Point{
		int s,b;
		Point(int s,int b){
			this.s = s;
			this.b = b;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		isVisited = new boolean[n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			ingredient.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		dfs(0,0);
		System.out.println(sum);
	}
	
	public static void dfs(int cnt, int start) {
		if(cnt==n) {
			//ck : isVisited�� ��� false�� ��쿡�� �丮�� �� ���̸� ������ �ʱ� ���� üũ ->����
			//�Ÿ��� �����̿��� 1�� �ʱ�ȭ, ������ �����̹Ƿ� 0 �ʱ�ȭ
			int sour = 1;
			int bitter =0;
			
			for(int i=0;i<n;i++) {
				if(isVisited[i]) {
					sour = sour * ingredient.get(i).s;
					bitter = bitter + ingredient.get(i).b;
				}
			}
			if(sour!=1 && bitter!=0) {
				sum = Math.min(sum, Math.abs(sour-bitter));				
			}
			return;
		}
		//�κ������� ���ϴ� ���
		isVisited[cnt] = true;
		dfs(cnt+1,start);

		isVisited[cnt] = false;
		dfs(cnt+1,start);
	}

}
