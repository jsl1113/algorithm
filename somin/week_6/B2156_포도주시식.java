package BOJ;
/*
 * 원래 생각 : 
 * XXOXXO../OXXOXX.. / XOXOXO.. 등의 방식으로만 하려하고 
 * XXOXOXOXX 등의 방식은 고려하지 못함
 * 그리고 그 알고리즘 또한 생각하지 못함
 * 해결방법 : 
 * 123456
 * 3번째는 XXO~ /OXX~/XOX~ 중에 합이 최대인 것을 dp[3]에 저장 
 * 4번째일 때 dp[3] 또는 dp[2] + arr[4] 또는 dp[1]+ arr[3]+arr[4] 중 최댓값을 dp[4]에 저장 
 * 이런 식으로 점화식을 만들었다. 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class B2156_포도주시식 {

	
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
