package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * Ʋ������ a[i]���� �����ϴ� �κм����� ���� ���� ������ ���ߴ�.
 * Ư�� if(a[j]<a[i] && dp[i]<dp[j]+a[i]) �� �ڿ� ������ ��¥ ����ġ�� ���ߴ�..
 * ������ ���Ҷ�� a[i] ���� �۾ƾ��ϰ� �� �ڿ� ������ �ݷʸ� ã�Ƴ��� ������.
 * �ʹ� ��ƴ�.
 * ��ȭ���� ���Ҷ� ������ ���� �������� dp�� ¥���Ѵٴ� ����! �غ���!
 */
public class B11055_����ū�����ϴºκм��� {

	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n =Integer.parseInt(st.nextToken());
		int [] dp = new int[n];
		int [] a = new int[n];

		
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(a[n-1]);
		
		for(int i=0;i<n;i++) {
			dp[i] = a[i];
//			System.out.println("dp["+i+"] = "+a[i]);
			for(int j=0;j<i;j++) {
				if(a[j]<a[i] && dp[i]<dp[j]+a[i]) {
//					System.out.println(j+"���� dp[j]= "+ dp[j]+" , "+a[i]);
					dp[i] = dp[j]+a[i];
				}else if(dp[i]>=dp[j]+a[i]) {
//					System.out.println("***");
//					System.out.println(dp[i]+" vs "+dp[j]+" + "+a[i]);
				}else {
//					System.out.println(a[j]+" vs "+a[i] +" / "+ dp[i]+" vs "+dp[j]+" + "+a[i]);					
				}
			}
//			System.out.println("�׷��� d["+i+"]= "+dp[i]);
		}
		//�ִ� ã��
		int ans = dp[0];
		for(int i=0;i<n;i++) {
//			System.out.println("dp["+i+"]= "+dp[i]);
			if(ans<dp[i]) ans = dp[i];
		}
		System.out.println(ans);
	}

}
