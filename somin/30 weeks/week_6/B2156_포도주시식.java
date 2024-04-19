package BOJ;
/*
 * ���� ���� : 
 * XXOXXO../OXXOXX.. / XOXOXO.. ���� ������θ� �Ϸ��ϰ� 
 * XXOXOXOXX ���� ����� ������� ����
 * �׸��� �� �˰��� ���� �������� ����
 * �ذ��� : 
 * 123456
 * 3��°�� XXO~ /OXX~/XOX~ �߿� ���� �ִ��� ���� dp[3]�� ���� 
 * 4��°�� �� dp[3] �Ǵ� dp[2] + arr[4] �Ǵ� dp[1]+ arr[3]+arr[4] �� �ִ��� dp[4]�� ���� 
 * �̷� ������ ��ȭ���� �������. 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B2156_�����ֽý� {

	
	static int n;
	static int [] arr ;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		
		arr = new int[n];
		
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		int [] dp = new int[n];
		dp[0] = arr[0];
		
		for(int i=1;i<n;i++) {
			if(i==1) {
				dp[i] = arr[0]+arr[1]; 
				continue;
			}
			if(i==2) {
				dp[i] = Math.max(dp[1], Math.max(arr[1]+arr[2], arr[0]+arr[2]));
				continue;
			}
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]));
		}
		System.out.println(dp[n-1]);

	}

}
