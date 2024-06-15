import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RV_B3079_입국심사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[] arr= new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//이분 탐색
		//시간을 찾자
		Arrays.sort(arr);

		long s = 0;
		long e = m*arr[n-1];
		
		long ans = Long.MAX_VALUE;
		
		while(s<=e) {
			long mid = (s+e)/2;
			
			//이 시간 동안 다 할 수 있는지 판별을 어떻게 하지
			//
			long sum= 0;
			for(int i=0;i<n;i++) {
				sum += (mid/arr[i]);
				if(sum>=m) {
					break;
				}
			}
			if(sum>=m) {
				//줄여
//				e = mid-1;  // 원래 mid라고함 
				ans = Math.min(ans, mid);
				e = mid-1;
			}else if(sum<m) {
				//키워
				s = mid+1;
			} 
		}
		
		System.out.println(ans);
		
		
	}

}
