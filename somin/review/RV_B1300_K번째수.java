package review.w14Over;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 이분탐색이라는 것을 보고 풀이방법이 생각났다.
 * 근데 범위를 조절해주는 것에서 헤맸다
 */
public class RV_B1300_K번째수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		//숫자를 찾는다
		long s = 1;
		long e = k; //? 처음에 n*n으로 썼다
		
		while(s<e) {
			
			long mid = (s+e)/2;
			
			long nums = 0;
			//1~n까지
			for(int i=1;i<=n;i++) {
				nums += Math.min(mid/i,n); //여기서 n과도 비교를 해줘야한다는 것을 빼먹음
				
			}
			System.out.println(nums);
			
			if(nums>=k) {
				e = mid;
			}else {
				s = mid+1;
			}
			
		}
		System.out.println(s);
		
		
		
		
	}

}
