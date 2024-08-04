import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 이분탐색... 드디어 맞췄다.........
 */
public class B2343_기타레슨 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int [] arr = new int[n];
		
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//블루레이의 크기를 찾기 (모두 같아야하기 때문에 m개 중 최댓값)
		
		long s = 1;
		long e = n*10000;
		
		int ans = Integer.MAX_VALUE;
		
		while(s<e) {
			
			long mid = (s+e)/2;
//			System.out.println("mid "+mid);
			int sum = 0;
			int cnt = 1;
			int sss = 0;
			for(int i=0;i<n;i++) {
				if(sum + arr[i]<=mid) {
					sum+=arr[i];
				}else {
					sum = arr[i];
					cnt++;
				}
//				System.out.println("sum: "+sum);
				sss = Math.max(sss, sum);
			}
			
//			System.out.println(" * "+cnt+" * mid :"+mid);
			
			
			if(cnt<=m) {
				e = mid;
				ans = (int) Math.min(ans, sss);
//				System.out.println("<<<"+mid);
			}else {
				s = mid+1;
//				System.out.println(">>>"+mid);
			}
			
			
		}
		
		System.out.println(ans);
		
	}
}
