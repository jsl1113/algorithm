package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식 {

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
			//ck : isVisited가 모두 false인 경우에는 요리의 맛 차이를 구하지 않기 위해 체크 ->없앰
			//신맛은 곱셈이여서 1로 초기화, 쓴맛은 덧셈이므로 0 초기화
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
		//부분집합을 구하는 방식
		isVisited[cnt] = true;
		dfs(cnt+1,start);

		isVisited[cnt] = false;
		dfs(cnt+1,start);
	}

}
