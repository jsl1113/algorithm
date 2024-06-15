import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RV_B3079_�Ա��ɻ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[] arr= new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//�̺� Ž��
		//�ð��� ã��
		Arrays.sort(arr);

		long s = 0;
		long e = m*arr[n-1];
		
		long ans = Long.MAX_VALUE;
		
		while(s<=e) {
			long mid = (s+e)/2;
			
			//�� �ð� ���� �� �� �� �ִ��� �Ǻ��� ��� ����
			//
			long sum= 0;
			for(int i=0;i<n;i++) {
				sum += (mid/arr[i]);
				if(sum>=m) {
					break;
				}
			}
			if(sum>=m) {
				//�ٿ�
//				e = mid-1;  // ���� mid����� 
				ans = Math.min(ans, mid);
				e = mid-1;
			}else if(sum<m) {
				//Ű��
				s = mid+1;
			} 
		}
		
		System.out.println(ans);
		
		
	}

}
