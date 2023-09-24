package review;

import java.util.Arrays;
import java.util.Scanner;

public class RV_B2156_포도주시식 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int [] arr = new int[n];
		int [] dp = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
//		System.out.println(Arrays.toString(arr));
		//[6, 10, 13, 9, 8, 1]
		
		dp[0] = arr[0];
		
		for(int i=1;i<n;i++) {
			if(i==1) dp[i] = arr[0]+arr[1];
			else if(i==2) dp[i] = Math.max(arr[i-1]+arr[i], Math.max(dp[i-1], arr[0]+arr[2]));
			else {
				
				dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+arr[i], arr[i-1]+arr[i]+dp[i-3]));
			}
			
		}
//		System.out.println(Arrays.toString(dp));

		System.out.println(dp[n-1]);
	}

}
