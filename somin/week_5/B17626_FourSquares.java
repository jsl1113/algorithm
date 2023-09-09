package BOJ;
/*
 * �ذ� ���� 
 * dp ��ȭ���� ������ ���� ���ߴ�. ����ġ�� ���� ����....
 * ��� ����Ž���� �����ߴµ� �ʹ� ȿ�������� �ʾƼ� ����ϴٰ� ����
 * ������ ��ȭ���� �˾Ƴ��� ��.
< ���� ���� �� >
�ϴ�  n������ ������ ���� ���� �迭�� ������ dfs�ؾ��� �� ����
���ڱ� �������ǵ� list�� �����߿� 1���� �����ؼ� ���� ����� �� 2�� ����..
������ �ߺ��ؼ� ����°ų�..
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B17626_FourSquares {

	static ArrayList<Integer> list= new ArrayList<Integer>();
	static int [] dp;
	static int sum=0;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int ans=0;
		dp = new int[n+1];
		
		dp[0]=0;dp[1]=1;
		pow(n);
		System.out.println(dp[n]);
	}
	
	public static void pow(int n) {
		for(int i=2;i<=n;i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++) {
//				System.out.println(i+" "+j);
//				System.out.println(" dp["+(i-j*j)+"]= "+dp[i-j*j]);
				min = Math.min(min, dp[i-j*j]);
			}
			dp[i] = min+1;
		}
		
	}

}
