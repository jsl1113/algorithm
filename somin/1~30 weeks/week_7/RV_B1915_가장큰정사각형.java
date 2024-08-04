package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * �� ���� .
 * ans�ȿ� �����ϴ� �� ���簢���� �����ϴ� ���� ���̴�.
 * 1 1
 * 1(min(�� ����) +1) �� ��� 1�̻��̿��� �� ��ġ�� 2�� �� �� �ִ�.!
 * 
 */
public class RV_B1915_����ū���簢�� {

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
