package BOJ.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * dp문제이기도 함.
 * 
 * 틀린이유 : 
 * i일에 시간=1 돈=10 일때 dp[i+1]에다가 넣어주면 쉽게 계산이될텐데
 * 굳이 dp[i]에다가 넣어서 괜히 꼬인것 같다.. 
 * 쉬운줄 알았는데 너무 복잡해서 방식을 여러개해도 답이 안나와서 포기했다. 
 * 결국은 처음에 했던 방법이랑 제일 비슷하다. ㅠ
 *  
 */
public class B14501_퇴사 {

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
		 * 거꾸로 가는 방식
		
		for(int i=n-1;i>=0;i--) {
			if(time[i]==1) dp[i] = profit[i];
			for(int j=i-1;j>=0;j--) {
				//10-9+1 = 2이하여야함
				if(time[j]<=i-j+1) dp[i] = Math.max(dp[j+time[j]-1],profit[j] );
			}
		}
		 */
		
		/*
		 * 1부터 시작하는 방식
		*/
		for(int i=0;i<n;i++) {
//			System.out.println(i+1+"일");
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
		 *  i까지 최대이익을 dp에 넣기
		 
		for(int i=0;i<n;i++) {
			if(time[i]==1) {
				dp[i]=  Math.max(dp[i],profit[i]);
				System.out.println("1임");
			}
			else if(time[i]<=n-i) {
				dp[time[i]-1+i] = Math.max(dp[time[i]-1+i], profit[i]);
				System.out.println(time[i]+"<"+(n-i)+" 인데");
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
