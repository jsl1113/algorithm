import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ����� �� ���ö�
 * ���� ���� ����/���� ������ ����/ ��1,2 ����
 * �������� ������ �϶�� �͸� ���� �����غô�..
 * 
 * n�� 4�̻��϶� �Ǵ� �ڵ带 ¥�� �ٽ� ¥���ߴ�..
 * �������� �ʹ� �����ߴ� �� 
 */
public class B21758_�ܵ��� {

	static int n;
	static long[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new long[n];
		long sum=0;
		long result = 0; //�ִ밪
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum+=arr[i];
		}
		
		//n ==3 
		if(n==3) {
			
			for(int i=0;i<n;i++) {
				long a = arr[i]*2;
				result = Math.max(result, a);
			}
			System.out.println(result);
			
			return;
		}
		
		
		//���ʹ��� + ������ ��1 + ��2 ���ϱ�
		long sumBee = sum - arr[n-1];
		long ans = sumBee;
		
		for(int i=n-2;i>=0;i--) {
			long t = sumBee - arr[i];
			ans -= arr[i];
			t+=ans;
			result = Math.max(t, result);			
		}
		
		//�����ʹ��� + ���� ��1 + ��2 ���ϱ�
		sumBee = sum - arr[0];
		ans = sumBee;

		for(int i=1;i<n-1;i++) {
			long t = sumBee - arr[i];
			ans-=arr[i];
			t +=ans;
			result = Math.max(t, result);
		}

		//���� ��1 + ������ ��2 +���� ���ϱ�
		sumBee = sum- arr[n-1];
		ans = 0;
		
		for(int i=1;i<n-1;i++) {
			ans +=arr[i];
			sumBee -=arr[i-1];
			result = Math.max(ans+sumBee, result);
		}
		
		
		System.out.println(result);
		
		
		
	}

}
