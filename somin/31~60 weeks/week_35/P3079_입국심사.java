import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * long 과 싸움
 * 그리고 <=와의 싸움..
 */
public class P3079_입국심사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [] t = new int[n];
		
		for(int i=0;i<n;i++) {
			t[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(t);
		
		long max = t[n-1];
		long s = 0;
		long e = m * max;
	 
        long ans = Long.MAX_VALUE;
        
        while(s<=e) {
			long mid = (s+e)/2;
			
			long sum = 0;
			
			for(long tt : t) {
				long cnt = mid/tt;
				
				if(sum>=m) {
					break;
				}
				sum+=cnt;
			}
			
			if(sum>=m){
				e = mid-1;;
				ans = Math.min(ans, mid);
            }
            else{
            	s = mid+1;
            }
			
		}
//		System.out.println(s+" "+e);
		System.out.println(ans);
		
	}

}
