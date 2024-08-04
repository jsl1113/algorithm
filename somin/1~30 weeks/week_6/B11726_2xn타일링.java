package BOJ;

import java.util.Scanner;
/*
 * ù° �ٿ� 2��n ũ���� ���簢���� ä��� 
 * ����� ���� 10,007�� ���� �������� ����Ѵ�.
 * 
 * dp[n] = dp[n-1]+dp[n-2]
 * �ʹ� ������ ��ȭ�� �� ���ϴ�!!!!!
 */
public class B11726_2xnŸ�ϸ� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int [] dp = new int[n+1];
		
		dp[0]=1;
		dp[1]=2;
		
		for(int i=2;i<n;i++) {
			dp[i] = (dp[i-1]+dp[i-2])%10007;
			System.out.println(i+" "+dp[i]);
		}
		
		System.out.println(dp[n-1]%10007);	
		

	}

}
