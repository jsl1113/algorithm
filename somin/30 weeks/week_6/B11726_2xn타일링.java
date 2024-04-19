package BOJ;

import java.util.Scanner;
/*
 * 첫째 줄에 2×n 크기의 직사각형을 채우는 
 * 방법의 수를 10,007로 나눈 나머지를 출력한다.
 * 
 * dp[n] = dp[n-1]+dp[n-2]
 * 너무 간단한 점화식 왜 못하니!!!!!
 */
public class B11726_2xn타일링 {

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
