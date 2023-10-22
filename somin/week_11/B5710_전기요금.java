package BOJ.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5710_전기요금 {
	//200
	//   9900*3
	// 990000* 5
	//1000000 초과 *7
	// 200+  29700 + 4950000 + //4979900 이상이면 마지막임.

	static int a,b;
	static int one,two,three,four=0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(a==0 && b==0) break;
		
			int sum = dosum(a);

			//상근사용량 이웃사용량
			// x + y = sum
			//|use(x)-use(y)| = b

			int s = 0;
			int e = sum/2;
			int mid =0;
			while(s<=e) {
				mid = (s+e)/2;
				
				int y = sum - mid;
//				System.out.println(mid +" // "+s+" "+e);
//				System.out.println(y+" 와이");
//				System.out.println(use(y) - use(mid) +" 비교 "+ b);
				
				int dist = Math.abs(use(mid) - use(y));
				if(dist>b) { 
					s = mid+1;
				}else if(dist<b) { 
					e = mid-1;
				}else {
					System.out.println(use(mid));
					break;
				}
				
			}
	
			
		}
		
		
	}
	
	public static int dosum(int a) {
		/*
		 * 금액이
		 * 200 초과
		 * 29700 +200 초과
		 * 4950000 + 29700 + 200 초과 = 4979900 초과
		 */
		if(a<=200) {
			one = a/2;
			
			return one;
		}else if(a<=29900) {
			one =100;
			a = a-200;
			two = a/3;
			return one+two;
		}else if(a<=4979900) {
			one = 100;
			two = 9900;
			a = a-200 -29700;
			three = a/5;
			return one+two+three;
		}else {
			one = 100;
			two = 9900;
			three = 990000;
			a = a-200 -29700-4950000;
			four = a/7;
			return one+two+three+four;
		}
		
	}
	
	public static int use(int use) {
		if(use<=100) {
			return 2*use;
		}else if(use<=10000) {
			
			return 200 + (use-100)*3;
		}else if(use<=1000000) {
			
			return 200 + 3*9900 + (use-10000)*5;
		}else {
			
			return 200 + 3*9900 + 5*990000+ (use-1000000)*7;
		}
		
		
	}

}
