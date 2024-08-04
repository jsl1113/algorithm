package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * dp�����̱⵵ ��.
 * 
 * Ʋ������ : 
 * i�Ͽ� �ð�=1 ��=10 �϶� dp[i+1]���ٰ� �־��ָ� ���� ����̵��ٵ�
 * ���� dp[i]���ٰ� �־ ���� ���ΰ� ����.. 
 * ������ �˾Ҵµ� �ʹ� �����ؼ� ����� �������ص� ���� �ȳ��ͼ� �����ߴ�. 
 * �ᱹ�� ó���� �ߴ� ����̶� ���� ����ϴ�. ��
 *  
 */
public class B14501_��� {

	static int n;
	
	static int [] time;
	static int[] profit;
	
	static int [] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		time = new int[n];
		profit = new int[n];
		dp = new int[n+1];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(bf.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			profit[i] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * �Ųٷ� ���� ���
		
		for(int i=n-1;i>=0;i--) {
			if(time[i]==1) dp[i] = profit[i];
			for(int j=i-1;j>=0;j--) {
				//10-9+1 = 2���Ͽ�����
				if(time[j]<=i-j+1) dp[i] = Math.max(dp[j+time[j]-1],profit[j] );
			}
		}
		 */
		
		/*
		 * 1���� �����ϴ� ���
		*/
		for(int i=0;i<n;i++) {
//			System.out.println(i+1+"��");
			if(time[i]<=n-i) {
//				System.out.println(i+time[i]+" idx "+dp[i+time[i]]+" "+dp[i]+" "+profit[i]);				
				dp[i+time[i]]=Math.max(dp[i+time[i]], dp[i]+profit[i]);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]);
//			System.out.println(Arrays.toString(dp));
		}
		 
		
		/*
7
3 10
5 20
1 11
1 20
2 15
4 40
2 200
		 *  i���� �ִ������� dp�� �ֱ�
		 
		for(int i=0;i<n;i++) {
			if(time[i]==1) {
				dp[i]=  Math.max(dp[i],profit[i]);
				System.out.println("1��");
			}
			else if(time[i]<=n-i) {
				dp[time[i]-1+i] = Math.max(dp[time[i]-1+i], profit[i]);
				System.out.println(time[i]+"<"+(n-i)+" �ε�");
			}
			System.out.println(Arrays.toString(dp));
			for(int j=0;j<i;j++) {
//				if(time[j]<=i-j+1) dp[i] = Math.max(dp[i], profit[j]);
				
			}if(i!=0) dp[i] +=dp[i-1];
		}
		*/
		
		System.out.println(dp[n]);

	}

}
