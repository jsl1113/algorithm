/*
 * �ذ� ���� ����
 * arr[n][m] �� �迭�� ���� �Ʒ��� ����� ��� ������ ����ұ� ����ߴ�.
 * n=3 m=2 
 * 00
 * 00
 * 00 
 * 
 * �ذ��� : ���
 * ������ ��Ŀ��� isVisited[] �湮���θ� üũ ���ϸ� �ȴ�.
 * m�� ������ �迭�� ����� ( m = 3 => [0, 0 ,0])
 *  [1, 1, 1 ] 3�� ���� ������ ����ϱ��ϰ� ������
 *  [1, 1, 2 ] 1�� ���������� 2�� ������  ~~
 *  ���� ������ ����̿���. �� ����������.. 
 *  �ʹ� DFS�� Ǯ��߰ڴٴ� ���������� �׷� �� ���� 
 *  ��ͷ� Ǫ�� ��������.
 *  
 *  StringBuilder�� ������� - �ð��ʰ��� �����ش�!
 */
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15651_N��M3 {

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
		dfs(0);
		System.out.print(s);

	}
	
	public static void dfs(int cnt) {
		if(cnt==m) {
			for(int i=0;i<m;i++) {
				s.append(arr[i]+" ");
			}
			s.append("\n");
			return;
		}
		//���� (������ �ٸ��� �ٸ� ��) 
		for(int i=0;i<n;i++) {
			arr[cnt] = i+1;
			dfs(cnt+1);
		}
	}

}
