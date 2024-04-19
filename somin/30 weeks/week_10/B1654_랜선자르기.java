package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 이분탐색.. 몰라서 못풀었지만
 * 이제 알았다.
 * 처음에 max+1을 해주는 게 사람들이 많이 틀린 요인인듯
 * min이 0이여서 ~요런저런 이유때문에..
 * 
 * 나는 max를 랜선 중 최대값이 아닌 랜선의 전체합/k를 해서 풀었더니 틀렸다. 
 */
public class B1654_랜선자르기 {

	static int n,k;
	static int[] lan;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		lan = new int[k];
		
		long max = 0;
		for(int i=0;i<k;i++) {
			lan[i] = Integer.parseInt(br.readLine());
			if(max<lan[i])max = lan[i];
		}
		max++;
		
		long min=0;
		while(min<max) {
			long mid = (min+max)/2;
			
			long cnt=0;
			for(int i=0;i<k;i++) {
				cnt+=lan[i]/mid;
			}
			
			if(cnt<n) {
				max = mid;
			}
			else {
				min = mid+1;
			}
	
			
		}
		System.out.println(min-1);
	}


}
