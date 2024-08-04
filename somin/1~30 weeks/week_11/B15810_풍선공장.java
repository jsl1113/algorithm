package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15810_풍선공장 {

	static long m;
	static int[] time;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		time= new int[n];
		
		long min=Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			time[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, time[i]);
		}
		
		//분 당 재는 것
		long s = 0;
		long e = min*m;
		long mid =0;
		
		while(s<=e) {
			mid = (s+e)/2;
			long sum=0;
			for(int i=0;i<n;i++) {
				sum+= mid / time[i];
			}

			if(sum<m) {
				s = mid+1;
			}else {
				e = mid-1;
			}

		}
		
		System.out.println(s);
		
	}


}
