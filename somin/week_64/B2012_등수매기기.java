import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//��... �ڷ��� ������ ��� Ʋ�ȴ�... (50000+50001) /2 ���ڰ� ũ��
public class B2012_����ű�� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		int sum = 0;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum +=arr[i];
		}
		Arrays.sort(arr);
		
		System.out.println(sum(n,arr));
	}
	
	static Long sum(int n, int[] arr ) {
		long all =0;
		for(int i=1;i<=n;i++) {
			if(i!=arr[i-1]) {
				all += Math.abs(arr[i-1]-i);
			}
		}
		return all;
		
	}

}
