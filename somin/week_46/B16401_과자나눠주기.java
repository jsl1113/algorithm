
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16401_���ڳ����ֱ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int arr[] =new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int mm = arr[n-1];
		
		//�̺�Ž�� ��������� ���̸� ã��
		long s = 1; long e = mm;
		long ans= 0;
		while(s<=e) {
			long mid = (s+e)/2;
			
			//�������� �������� üũ
			int cnt = 0;
			for(int i=0;i<n;i++) {
				cnt += (arr[i]/mid);
			}
			
			if(cnt>=m) {
				s = mid+1;
				ans = Math.max(mid,ans);
			}else {
				e = mid-1;
			}
			
		}
		System.out.println(ans);
		
	}
}
