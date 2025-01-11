import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B7795_먹을것인가먹힐것인가 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		
		for(int i=0;i<t;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			int[] b = new int[m];
			
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				b[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a);
			Arrays.sort(b);
			
			int cnt=0;
			for(int aa=0;aa<n;aa++) {
				for(int bb=0;bb<m;bb++) {
					if(a[aa]>b[bb]) {
						cnt++;
					}else
						break;
				}
			}
			
			System.out.println(cnt);
			/*
			 //이분탐색으로 처음 할 때 m을 기준으로 했더니 잘 안 풀렸다.
			 //그래서 완탐으로 풀기는 했지만 이분탐색 방법도 찾았다.
			int ans =0;
			for(int k=0;k<n;k++) {
				int tmp=0;
				
				int s=0; int e = m-1;
				int now = a[k];
				
				while(s<=e) {
					int mid = (s+e)/2;
					if(now>b[mid]) {
						s = mid+1;
						tmp = mid+1;
					}else {
						e = mid-1;
					}
					
				}
				
				ans += tmp;
			}
			
			System.out.println(ans);
			 */
		}

		
	}

}
