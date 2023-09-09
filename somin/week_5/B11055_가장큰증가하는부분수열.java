package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 틀린이유 a[i]마다 증가하는 부분수열의 합을 구할 생각을 못했다.
 * 특히 if(a[j]<a[i] && dp[i]<dp[j]+a[i]) 이 뒤에 조건은 진짜 생각치도 못했다..
 * 수열에 더할라면 a[i] 보다 작아야하고 그 뒤에 조건은 반례를 찾아내서 이해함.
 * 너무 어렵다.
 * 점화식을 구할때 마지막 수를 기준으로 dp를 짜야한다는 생각! 해보자!
 */
public class B11055_가장큰증가하는부분수열 {

	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n =Integer.parseInt(st.nextToken());
		int [] dp = new int[n];
		int [] a = new int[n];

		
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(a[n-1]);
		
		for(int i=0;i<n;i++) {
			dp[i] = a[i];
//			System.out.println("dp["+i+"] = "+a[i]);
			for(int j=0;j<i;j++) {
				if(a[j]<a[i] && dp[i]<dp[j]+a[i]) {
//					System.out.println(j+"제이 dp[j]= "+ dp[j]+" , "+a[i]);
					dp[i] = dp[j]+a[i];
				}else if(dp[i]>=dp[j]+a[i]) {
//					System.out.println("***");
//					System.out.println(dp[i]+" vs "+dp[j]+" + "+a[i]);
				}else {
//					System.out.println(a[j]+" vs "+a[i] +" / "+ dp[i]+" vs "+dp[j]+" + "+a[i]);					
				}
			}
//			System.out.println("그래서 d["+i+"]= "+dp[i]);
		}
		//최댓값 찾기
		int ans = dp[0];
		for(int i=0;i<n;i++) {
//			System.out.println("dp["+i+"]= "+dp[i]);
			if(ans<dp[i]) ans = dp[i];
		}
		System.out.println(ans);
	}

}
