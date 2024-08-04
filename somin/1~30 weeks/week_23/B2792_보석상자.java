package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2792_보석상자 {

	static int n,m;
	
	static int min,ans = Integer.MAX_VALUE;
	static int[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new int[m];
		int max = 0;
		for(int i=0;i<m;i++) {
			list[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, list[i]);
		}
		
		int s = 1;
		int e = max;
		
		if(m ==1) {
			System.out.println(list[0]);
			return;
		}
		
		while(s<e) {
			int mid = (s+e)/2;
			
			if(check(mid)>n) {
				s = mid+1;
			}else{
				e = mid;
			}
			/*
			if(check(mid)>n) {
				s = mid+1;
			}else if(check(mid)<n){
				e = mid;
			}else {
				e = mid;
				ans = Math.min(ans, mid);		
				
				이런식으로 했었다. 이분탐색 죽어라..........
			}*/
			
			
		}
		System.out.println(e);
		
		
	
	}
	
	static int check(int mid) {
		int num =0;
		for(int i=0;i<m;i++) {
			if(mid>list[i]) {
				num++;
			}else if(mid==list[i]) {
				num++;
			}else {
				int ans = list[i] /mid;
				int r = list[i] %mid;
				
				if(r!=0) {
					num++;
				}
				num +=ans;
			}
		}
		
		return num;
		
	}

}
