/*
 * N�� M (3)�� �����ؼ� �����ؼ� Ǯ���µ� �׷��� �ȵȰɱ�..?
 * �����Ƽ� �����ߴµ� 3�̶� 4�� �ʹ� ����� ������ �Ӿ� 
 */
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15652_N��M4 {

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
