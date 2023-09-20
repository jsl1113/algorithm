package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RV_B11055_����ū�����ϴºκм��� {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int[] arr = new int [n];
		int[] dp = new int [n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		
		
		for(int i=1;i<n;i++) {
			dp[i]=arr[i];
			for(int j=0;j<i;j++) {
				//
				if(arr[j]<arr[i]&& dp[j]+arr[i]>dp[i])  {  //�ٺ�.
					dp[i] =dp[j]+arr[i];
				}
				
			}
					
		}
//		System.out.println(Arrays.toString(dp));
		
		int max = arr[0];
		for(int i:dp) {
			if(i>max) max = i;
		}
		System.out.println(max);
		
	}

}
