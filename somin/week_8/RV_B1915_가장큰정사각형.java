package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 또 실패 .
 * ans안에 저장하는 건 정사각형을 충족하는 변의 길이다.
 * 1 1
 * 1(min(저 세개) +1) 즉 모두 1이상이여야 현 위치에 2가 올 수 있다.!
 * 
 */
public class RV_B1915_가장큰정사각형 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String s = bf.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j] = s.charAt(j) -'0';
			}
		}

//		System.out.println(Arrays.deepToString(arr));
		
		int[][] ans = new int[n+1][m+1];
		
		int max=0;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(arr[i-1][j-1]!=0) {
					int min = Math.min(ans[i][j-1], Math.min(ans[i-1][j],ans[i-1][j-1] ));
					
					ans[i][j] = min+1;
					
					max = Math.max(max, ans[i][j]);
				}
				
			}
		}
		System.out.println(max*max);
	}

}
