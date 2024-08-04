package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 처음에 주석대로 풀다가 시간초과의 굴레에서 벗어나지 않아서
 * 새로운 방식 타파!
 */
public class B10836_여왕벌 {

	static int n,m;
	static int [][] map ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[m][m];
		int [] arr = new int[2*m-1];
		for(int i=0;i<2*m-1;i++) arr[i] = 1;
		
		for(int i =0;i<m;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = 1;
			}
		}
		
		
		for(int i=0;i<n;i++) {
			int len = 2*m -1;
			st = new StringTokenizer(br.readLine());
			
			int z = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			for(int j=z;j<z+o;j++) {
				arr[j]++;
			}
			for(int j=z+o;j<2*m-1;j++) {
				arr[j]+=2;
			}
			
			
//			for(int j=1;j<=z;j++) {
//				int ans = len / m;
//				int r = len % m;
//				sol(ans, r, 0);
//				len--;
//			}
//			for(int j=1;j<=o;j++) {
//				int ans = len / m;
//				int r = len % m;
//				sol(ans, r, 1);
//				len--;
//			}
//			for(int j=1;j<=t;j++) {
//				int ans = len / m;
//				int r = len % m;
//				sol(ans, r, 2);
//				len--;
//			}
     			
		}
		
//		for(int i=1;i<m;i++) {
//			for(int j=1;j<m;j++) {
//				map[i][j] = change(i, j);
//			}
//		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=m-1;i>=0;i--) {
			sb.append(arr[i]+" ");
			for(int j=m;j<2*m-1;j++) {
				sb.append(arr[j]+" ");
			}sb.append("\n");
		}
		
		System.out.println(sb);
//		sb = new StringBuilder();
//		for(int [] a : map) {
//			for(int aa :a) {
//				sb.append(aa+" ");
//			}
//			sb.append("\n");
//		}
//		System.out.println(sb);
	}

	
	static int change(int x,int y) {
		int left = map[x][y-1];
		int up = map[x-1][y];
		int leftup = map[x-1][y-1];
		
		return Math.max(left, Math.max(up, leftup));
	}
	
	static void sol(int ans, int r, int number) {
		
		if(ans==1) {
			if(r==0) {
				map[0][0] +=number;
			}else {
				map[r][0] += number;				
			}
		}else {
			map[0][m-r] +=number;
		}
		
	}

}
