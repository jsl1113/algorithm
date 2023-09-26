package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14620_꽃길 {

	static int n;
	static int[][] money;
	static boolean[][] isVisited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		
		money = new int[n][n];
		isVisited = new boolean[n][n];

		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0;j<n;j++) {
				money[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(min);
		
	}
	public static void dfs(int cnt) {
		
		if(cnt==3) {
			int sum=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(isVisited[i][j]) {
						sum+= money[i][j];
//						System.out.print(money[i][j]+" ");
					}
//					else {
//						System.out.print("X ");
//					}
				}
//				System.out.println();
			}
//			System.out.println("--------"+sum);
			min = Math.min(min, sum);
			return;
		}
			
		for(int i = 1;i<n-1;i++) {
			for(int j=1;j<n-1;j++) {
				if(check5(i, j)) {
					four(i,j,true);
					dfs(cnt+1 );
					four(i,j,false);
				}
				
			}
		}
		
		//쓰잘데기없이 괜히 테두리 제외하고 하려고 막 이리저리 하다가 한 방법 (fail)
//		int len = (n-2)*(n-2);
//		for(int i=idx;i<len+1;i++) {
//			
//			int a = (i % 4 ==0) ? i/4 : i/4+1;
//			int b = ( (i % 4 ==0)? 4 : i % 4);
////			System.out.println(i+" "+a+" "+b);
//			if(check5(a,b)) {
//				
//				four(a,b,true);
//				dfs(cnt+1,i+1 );
//				four(a,b,false);
//								
//			}
//			
//		}
		

		
	}
	public static void four(int i, int j, boolean status) {

		isVisited[i][j] = status;
		isVisited[i-1][j] = status;
		isVisited[i][j-1] = status;
		isVisited[i+1][j] = status;
		isVisited[i][j+1] = status;

	}

	public static boolean check5(int i, int j) {

		if(!isVisited[i][j] && !isVisited[i-1][j] 
				&& !isVisited[i][j-1] && !isVisited[i+1][j] && !isVisited[i][j+1] )
			return true;
		else 
			return false;
		
	}
}
