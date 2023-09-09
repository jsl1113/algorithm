package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RV_B16439_ġŲġŲġŲ {

	static int n,m;
	static int[][] arr;
	static boolean [] isVisited;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		isVisited = new boolean[m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j =0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		System.out.println(max);
		
	}
	
	public static void dfs(int cnt, int start) {
		if(cnt ==3) {
			System.out.println("����");
			int sum = 0;
			for(int i=0;i<n;i++) {
					int ch =0;
					for(int j=0;j<m;j++) {
						if(isVisited[j]) {
							
							System.out.println(arr[i][j]+" �̰� "+j+"��"+i+"��°");
							ch = Math.max( arr[i][j], ch);
						}
					}
					System.out.println(ch+" �ִ� "+i);
					sum+=ch;
				
			}
			System.out.println(sum+" �� ��");
			max = Math.max(sum, max);
			return;
		}
		
		for(int i=start;i<m;i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				dfs(cnt+1, i+1);
				isVisited[i] = false;
			}
		}
	}

}
