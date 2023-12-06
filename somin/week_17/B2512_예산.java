package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2512_¿¹»ê {

	static int n, bg;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		int sum=0;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			sum+=arr[i];
		}
		bg = Integer.parseInt(br.readLine());
		
		if(sum<=bg) {
			int max=0;
			for(int ii : arr) {
				if(max<ii) max = ii;
			}
			System.out.println(max);
			return;
		}
		Arrays.sort(arr);
		
		long ans = 0;
		long s=0; 
		long e=bg;
		
		while(s<=e) {
			long mid = (s+e)/2;
			
			long cnt=0;
			for(int i=0;i<n;i++) {
				if(mid>arr[i]) {
					cnt+=arr[i];
				}else {
					cnt+=mid;
				}
			}
			
			if(cnt>bg) {
				e = mid-1;
			}else {
				s = mid+1;
			}
		}
		System.out.println(e);
		
		
	}

}
