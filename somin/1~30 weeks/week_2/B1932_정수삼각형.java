package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1932_정수삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		int [][] a = new int[n+1][n+1];
		int [][] m = new int[n+1][n+1];
		
		for(int i=1;i<n+1;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=1;j<i+1;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		m[1][1]= a[1][1];
		//처음 세팅 모서리 1,1=7
		for(int i=2;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				m[i][1] = m[i-1][1]+a[i][1];
				if(i==j) {
					m[i][i] = m[i-1][i-1] + a[i][i];
				}
				
				else {
					m[i][j] = Math.max(m[i-1][j-1], m[i-1][j])+a[i][j];
				}
				
			}
		}

		int ans = m[n][1];

		for(int num: m[n]) {
			if(num>ans) {
				ans = num;
			}
		}
		System.out.println(ans);
	}

}
