import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//�ı� : ���� �̺�Ž���� �̷��� ���� Ǯ�ٴ�.. ���ݽ�����. ���� �� ���ذ� �� ��
public class B13702_�̻��Ѽ��� {

	static int n,k;
	static int pot[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		pot = new int[n];
		
		for(int i=0;i<n;i++) {
			pot[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(pot);
		
		if(n==k) {
			System.out.println(pot[n-1]);
			return;
		}
		
		
		int s = 0;
		int e = pot[n-1];
		
		while(s<e) {
			int mid = (s+e)/2;
			
			int cnt = 0;
			for(int i=0;i<n;i++) {
				cnt += pot[i]/mid;
			}
			
			if(cnt >= k) { 
				s = mid+1;
			}else if(cnt<k) { //�뷮�� �� �۾ƾ���
				e = mid;
			}
			
		}
		System.out.println(s-1);
	}

}
