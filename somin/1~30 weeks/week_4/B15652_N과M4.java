/*
 * N과 M (3)을 복붙해서 수정해서 풀었는데 그러면 안된걸까..?
 * 귀찮아서 복붙했는데 3이랑 4랑 너무 비슷한 문제라 머쓱 
 */
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15652_N과M4 {

	static int n,m;
	static int [] arr;
	static StringBuilder s;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		s = new StringBuilder();
		dfs(0,0);
		System.out.print(s);

	}
	
	public static void dfs(int cnt, int start) {
		if(cnt==m) {
			for(int i=0;i<m;i++) {
				s.append(arr[i]+" ");
			}
			s.append("\n");
			return;
		}
	
		for(int i=start;i<n;i++) {
			arr[cnt] = i+1;
			dfs(cnt+1,i);
			start++;
		}
	}

}
