import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B7795_�������ΰ��������ΰ� {

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
			 //�̺�Ž������ ó�� �� �� m�� �������� �ߴ��� �� �� Ǯ�ȴ�.
			 //�׷��� ��Ž���� Ǯ��� ������ �̺�Ž�� ����� ã�Ҵ�.
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
