package review.w14Over;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RV_NQueen {

	static int n,ans=0;
	
	static int[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		v = new int[n];
		//각행마다 하나를 놓으면 된다
		//대각선으로 겹치지 않기
		
		solve(0);
		System.out.println(ans);
	}
	
	static void solve(int cnt) {
		
		if(cnt==n) {
			ans++;
			return;
		}
		
		for(int i=0;i<n;i++) {
			v[cnt] = i;
			//대각선체크
			if(isLine(cnt)) {
				solve(cnt+1);
			}
		}
		
		//여기다 리턴을 줘야 대각선체크가 안된애들은 그냥 return
		return;
	}
	
	/*
	 * 같은 열에 있는지, 대각선에 있는지 체크하고
	 * true : 퀸의 공격범위에 없다
	 */
	static boolean isLine(int now) {
		
		for(int i=0;i<now;i++) {
			
			if(v[i] == v[now]) {
				return false;
			}
			//대각선에 있다면 즉, 삼각형이 이등변이면
			if(now-i == Math.abs(v[now]-v[i])) {
				return false;
			}
			
		}
		
		
		return true;
	}

}
