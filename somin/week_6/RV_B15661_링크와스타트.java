package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RV_B15661_링크와스타트 {

	static int n;
	static int[][] s;
	static boolean [] isVisited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		
		n = Integer.parseInt(bf.readLine());
		
		s = new int[n][n];
		isVisited = new boolean[n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(min);
	}
	//부분집합 구하기 (중복제거..?)
	public static void dfs(int cnt) {
		
		if(cnt==n) {
			int ck=0;
			for(int i=0;i<n;i++) {
				if(isVisited[i]) {
					ck++;
				}
			}
			
			if(ck>=2 && ck<n-1) link();
		
			return;
		}
		isVisited[cnt] = true;
		dfs(cnt+1);
		
		isVisited[cnt] = false;
		dfs(cnt+1);
		
	}
	public static void link() {
		ArrayList<Integer> link = new ArrayList<Integer>();
		ArrayList<Integer> start = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++) {
			if(isVisited[i]) link.add(i+1);
			else
				start.add(i+1);
		}

		//12
		//34
		int l_sum=0;
		for(int i:link) {
			for(int j:link) {
				l_sum+=s[i-1][j-1];
		
			}
		}

		
		int s_sum=0;
		for(int i:start) {
			for(int j: start) {
				s_sum+=s[i-1][j-1];
		
			}
		}
		
		min = Math.min(min, Math.abs(s_sum-l_sum));
		
		
	}

}
