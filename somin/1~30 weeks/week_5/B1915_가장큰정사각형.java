package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1915_가장큰정사각형 {

	static int n,m;
	static int [][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int [n][m];
		
		String[][] arr_str = new String[n][m];
		
		for(int i=0;i<n;i++) {
			String s = bf.readLine();
			arr_str[i]=(s.split(""));
			for(int j =0;j<m;j++) {
				arr[i][j] = Integer.parseInt(arr_str[i][j]);		
			
			}
		}
		
		System.out.println(sol());
		
	}
	/*
	 * 총 1의 개수를 세서
	 * 3의 제곱보다 작으면 2*2부터 존재하는지 체크 
	 * 실패 (X)
	 
	
	public static void dfs(int s) {
		int sum=0;
		for(int i=0;i<=n-s;i++) {
			System.out.println("시작");
			int [][] arr1 =Arrays.copyOfRange(arr, i, s);
			System.out.println(Arrays.deepToString(arr1));
//			sum = Arrays.stream(arr1).sum();
			
		}
	}*/
	public static int sol() {
		int [][] map = new int[n+1][m+1];
		
		int maxLen=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(arr[i-1][j-1]!=0) {
					int min = Math.min(Math.min(map[i-1][j], map[i][j-1]), map[i-1][j-1]);
					map[i][j]=min+1;
					
					maxLen = Math.max(maxLen, min+1);
				}
			}
		}
		return maxLen*maxLen;
	}

}
