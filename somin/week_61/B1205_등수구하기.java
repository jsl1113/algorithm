import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1205_������ϱ� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		int n = Integer.parseInt(st.nextToken());
		int taesue = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		if(n==0) {
			System.out.println(1);
			return;
		}
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//�¼��� ������ �� �� �ֳ�
		if(n == p && arr[n-1] >= taesue) {
			System.out.println("-1");
			return;
		}
		
		//����Ʈ p������ n���� ũ�ų� ����
		
		int rank = 1;
		for(int i=0;i<arr.length;i++) {
			if(taesue < arr[i]) rank++;
			else {
				break;
			}
		}
		System.out.println(rank);
		
		
	}
	
}
