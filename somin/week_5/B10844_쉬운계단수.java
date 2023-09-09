package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
 * �ᱹ �� ���� ���̽� �ڵ带 ���� ���ߴµ�
 * �� Ʋ����.. ���� ���ϱ� long Ÿ���� ����ϴ���
 * 1 000 000 000 �̸� longŸ���ΰ���.
 * ��Ģ�� ������ ������ ���� �ϴ� ���� ���� ����. 
 * �ٽ� Ǯ�� �� �� �ֳ�..?
 */
public class B10844_�����ܼ� {

	static ArrayList<Integer>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int dp[][] = new int[n][10];
		for(int i=1;i<10;i++) dp[0][i] =1;
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<10;j++) {
				if(j==0) {
					dp[i][j] = dp[i-1][1];
					
				}
				else if(j==9) {
					dp[i][j] = dp[i-1][8];
				}
				else {
					dp[i][j] = dp[i-1][j-1]+dp[i-1][j+1];
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		long sum=0;
		for(int i:dp[n-1]) {
			sum+= i;
		}
		System.out.println(sum%1000000000);
		
		long ans = 0;
        for(int i=0; i<10; i++) {
            ans += dp[n-1][i];
        }
        System.out.println(ans%1000000000);
		
	}
	
	
}
